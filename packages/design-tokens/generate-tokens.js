#!/usr/bin/env node

const fs = require("node:fs");
const path = require("node:path");

const root = path.resolve(__dirname, "../..");
const source = path.join(root, "design-system/tokens/tokens.json");
const android = path.join(root, "design-system/android/theme/IdsColors.kt");

const tokens = JSON.parse(fs.readFileSync(source, "utf8"));
const lines = [];

const groups = [
  ["Grey", tokens.colors.grey],
  ["Blue", tokens.colors.blue],
  ["Red", tokens.colors.red],
];

for (const [name, values] of groups) {
  for (const [step, hex] of Object.entries(values)) {
    lines.push(`    val ${name}${step} = Color(0xFF${hex})`);
  }
  lines.push("");
}

lines.push(`    val Green500 = Color(0xFF${tokens.colors.green500})`);
lines.push(`    val White = Color(0xFF${tokens.colors.white})`);

function replaceGeneratedRegion(file, generated) {
  const input = fs.readFileSync(file, "utf8");
  const start = input.indexOf("// GENERATED:BEGIN");
  const end = input.indexOf("// GENERATED:END", start);
  if (start < 0 || end < 0 || end < start) {
    throw new Error(`Missing generated markers in ${file}`);
  }

  const before = input.slice(0, start);
  const after = input.slice(end + "// GENERATED:END".length);
  const marker = "// GENERATED:BEGIN -- do not hand-edit; regenerate from design-system/tokens/tokens.json.\n";
  fs.writeFileSync(file, before + marker + generated.join("\n") + "\n    // GENERATED:END" + after);
}

replaceGeneratedRegion(android, lines);
console.log("Generated Android primitive color tokens from design-system/tokens/tokens.json");
