#!/usr/bin/env node
/**
 * Generate the Android primitive palette from design-system/tokens/tokens.json.
 *
 * Semantic aliases and all code outside the GENERATED markers are preserved.
 * Run with --check in CI to detect stale generated output without writing files.
 */
import { readFileSync, writeFileSync } from "node:fs";

const sourcePath = "design-system/tokens/tokens.json";
const targetPath = "design-system/android/theme/IdsColors.kt";
const checkOnly = process.argv.includes("--check");
const source = JSON.parse(readFileSync(sourcePath, "utf8"));
let target = readFileSync(targetPath, "utf8");

const beginMarker = "// GENERATED:BEGIN";
const endMarker = "// GENERATED:END";
if (target.split(beginMarker).length !== 2 || target.split(endMarker).length !== 2) {
  console.error(`Expected exactly one generated region in ${targetPath}`);
  process.exit(1);
}

const scales = ["grey", "blue", "red"];
const steps = ["50", "100", "200", "300", "400", "500", "600", "700", "800", "900"];
const required = [];
for (const scaleName of scales) {
  const scale = source.colors?.[scaleName];
  if (!scale || typeof scale !== "object") throw new Error(`Missing colors.${scaleName}`);
  for (const step of steps) {
    const value = scale[step];
    if (typeof value !== "string" || !/^[0-9a-fA-F]{6}$/.test(value)) {
      throw new Error(`colors.${scaleName}.${step} must be a six-digit hex string`);
    }
    required.push({ name: `${scaleName[0].toUpperCase()}${scaleName.slice(1)}${step}`, value });
  }
}
for (const [key, value] of [["Green500", source.colors?.green500], ["White", source.colors?.white]]) {
  if (typeof value !== "string" || !/^[0-9a-fA-F]{6}$/.test(value)) {
    throw new Error(`colors.${key === "Green500" ? "green500" : "white"} must be a six-digit hex string`);
  }
  required.push({ name: key, value });
}

const generated = required.map(({ name, value }) => `    val ${name} = Color(0xFF${value.toUpperCase()})`).join("\n");
const start = target.indexOf(beginMarker);
const end = target.indexOf(endMarker);
if (end < start) throw new Error("Generated region markers are reversed");
const prefixEnd = target.indexOf("\n", start);
const suffixStart = end;
const next = target.slice(0, prefixEnd + 1) + generated + "\n    " + target.slice(suffixStart);

if (next === target) {
  console.log(`✓ ${targetPath} is in sync with ${sourcePath}`);
  process.exit(0);
}
if (checkOnly) {
  console.error(`✗ ${targetPath} is stale. Run node scripts/generate-design-tokens.mjs and commit the result.`);
  process.exit(1);
}
writeFileSync(targetPath, next);
console.log(`✓ Generated Android primitive colors in ${targetPath}`);
