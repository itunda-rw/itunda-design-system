#!/usr/bin/env node

const fs = require("node:fs");
const path = require("node:path");

const root = path.resolve(__dirname, "../..");
const source = path.join(root, "design-system/tokens/tokens.json");
const output = path.join(root, "design-system/web/ids-primitives.css");

const tokens = JSON.parse(fs.readFileSync(source, "utf8"));
const lines = [
  ":root {",
  "  /* GENERATED:BEGIN -- do not hand-edit; regenerate from design-system/tokens/tokens.json. */",
];

for (const [group, values] of Object.entries(tokens.colors)) {
  if (typeof values === "string") {
    lines.push("  --ids-" + group + ": #" + values + ";");
    continue;
  }
  for (const [step, hex] of Object.entries(values)) {
    lines.push("  --ids-" + group + "-" + step + ": #" + hex + ";");
  }
}

lines.push("  /* GENERATED:END */", "}", "");
fs.mkdirSync(path.dirname(output), { recursive: true });
fs.writeFileSync(output, lines.join("\n"));
console.log("Generated Web primitive color tokens from design-system/tokens/tokens.json");
