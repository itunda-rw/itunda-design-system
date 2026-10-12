#!/usr/bin/env node
/**
 * IDS token contract checks.
 *
 * This validates the checked-in primitive palette and semantic web token surface.
 * It intentionally does not regenerate platform files: the referenced generator
 * is not present in this standalone repository yet, so claiming drift-free
 * generation would be premature.
 */
import { readFileSync } from "node:fs";

const fail = (message) => {
  console.error(`✗ ${message}`);
  process.exitCode = 1;
};
const pass = (message) => console.log(`✓ ${message}`);

let palette;
try {
  palette = JSON.parse(readFileSync("design-system/tokens/tokens.json", "utf8"));
} catch (error) {
  console.error("✗ Cannot parse design-system/tokens/tokens.json:", error.message);
  process.exit(1);
}

const css = readFileSync("design-system/tokens/tokens.css", "utf8");
const requiredScales = ["grey", "blue", "red"];
const requiredSteps = ["50", "100", "200", "300", "400", "500", "600", "700", "800", "900"];
const hex = /^#?[0-9a-fA-F]{6}$/;

for (const scaleName of requiredScales) {
  const scale = palette.colors?.[scaleName];
  if (!scale || typeof scale !== "object") {
    fail(`Missing primitive color scale: colors.${scaleName}`);
    continue;
  }
  for (const step of requiredSteps) {
    const value = scale[step];
    if (typeof value !== "string" || !hex.test(value)) {
      fail(`Invalid or missing colors.${scaleName}.${step}: expected a six-digit hex color`);
    }
  }
}
if (typeof palette.colors?.green500 !== "string" || !hex.test(palette.colors.green500)) {
  fail("Invalid or missing colors.green500");
}
if (typeof palette.colors?.white !== "string" || !hex.test(palette.colors.white)) {
  fail("Invalid or missing colors.white");
}
if (!process.exitCode) pass("Primitive palette has all required scales and valid six-digit hex values");

const requiredSemanticTokens = [
  "--itunda-indigo",
  "--itunda-indigo-active",
  "--itunda-indigo-light",
  "--itunda-red",
  "--itunda-red-light",
  "--itunda-green",
  "--itunda-grey-100",
  "--itunda-grey-200",
  "--itunda-grey-500",
  "--itunda-grey-700",
  "--itunda-grey-900",
  "--itunda-white",
];
const lightRoot = css.match(/:root\s*\{([\s\S]*?)\}/);
const darkBlock = css.match(/@media\s*\(prefers-color-scheme:\s*dark\)\s*\{([\s\S]*?)\n\}/);

if (!lightRoot) {
  fail("Cannot find the default :root token block");
} else {
  for (const token of requiredSemanticTokens) {
    if (!new RegExp(`(?:^|\\n)\\s*${token}\\s*:`, "m").test(lightRoot[1])) {
      fail(`Missing default-theme semantic token: ${token}`);
    }
  }
  if (!process.exitCode) pass("Required semantic tokens exist in the default theme");
}
if (!darkBlock) {
  fail("Cannot find the prefers-color-scheme: dark token block");
} else {
  for (const token of requiredSemanticTokens) {
    if (!darkBlock[1].includes(token)) fail(`Missing dark-theme semantic token: ${token}`);
  }
  if (!process.exitCode) pass("Required semantic tokens exist in the system dark theme");
}

if (process.exitCode) {
  console.error("\nIDS token validation failed. Fix the source contract before publishing.");
} else {
  console.log("\nIDS token validation passed.");
}
