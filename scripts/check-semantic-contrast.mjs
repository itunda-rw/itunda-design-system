#!/usr/bin/env node
/**
 * WCAG 2.x contrast checks for explicitly documented IDS semantic color pairs.
 * Pair thresholds are role-specific: 4.5:1 for normal text, 3:1 for large text
 * or meaningful UI components. This is not a substitute for auditing every usage.
 */
import { readFileSync } from "node:fs";

const css = readFileSync("design-system/tokens/tokens.css", "utf8");
const lightMatch = css.match(/:root\s*\{([\s\S]*?)\n\}/);
const darkMatch = css.match(/@media\s*\(prefers-color-scheme:\s*dark\)\s*\{\s*:root\s*\{([\s\S]*?)\n\s*\}\s*\}/);
if (!lightMatch || !darkMatch) {
  console.error("✗ Could not identify light and dark semantic token blocks");
  process.exit(1);
}

function readTokens(block) {
  const tokens = {};
  for (const match of block.matchAll(/(--itunda-[\w-]+)\s*:\s*(#[0-9a-fA-F]{6})\s*;/g)) {
    tokens[match[1]] = match[2];
  }
  return tokens;
}
function linearize(value) {
  const channel = parseInt(value, 16) / 255;
  return channel <= 0.04045 ? channel / 12.92 : ((channel + 0.055) / 1.055) ** 2.4;
}
function luminance(hex) {
  const value = hex.replace("#", "");
  return 0.2126 * linearize(value.slice(0, 2)) +
    0.7152 * linearize(value.slice(2, 4)) +
    0.0722 * linearize(value.slice(4, 6));
}
function contrast(a, b) {
  const values = [luminance(a), luminance(b)].sort((x, y) => y - x);
  return (values[0] + 0.05) / (values[1] + 0.05);
}

const suites = [
  {
    name: "light",
    tokens: readTokens(lightMatch[1]),
    pairs: [
      ["--itunda-grey-500", "--itunda-grey-100", 4.5, "tertiary text on app background"],
      ["--itunda-grey-500", "--itunda-white", 4.5, "tertiary text on card surface"],
      ["--itunda-green", "--itunda-white", 4.5, "success text/icon on white surface"],
      ["--itunda-indigo", "--itunda-grey-100", 3, "brand UI component on app background"],
      ["--itunda-red", "--itunda-white", 3, "danger UI component on white surface"],
    ],
  },
  {
    name: "dark",
    tokens: readTokens(darkMatch[1]),
    pairs: [
      ["--itunda-grey-500", "--itunda-grey-100", 4.5, "tertiary text on app background"],
      ["--itunda-grey-500", "--itunda-white", 4.5, "tertiary text on card surface"],
      ["--itunda-green", "--itunda-grey-100", 4.5, "success text/icon on app background"],
      ["--itunda-indigo", "--itunda-grey-100", 4.5, "brand text on app background"],
      ["--itunda-red", "--itunda-grey-100", 3, "danger UI component on app background"],
    ],
  },
];

let failures = 0;
for (const suite of suites) {
  console.log(`\n${suite.name.toUpperCase()} THEME`);
  for (const [foreground, background, minimum, role] of suite.pairs) {
    const fg = suite.tokens[foreground];
    const bg = suite.tokens[background];
    if (!fg || !bg) {
      console.error(`✗ Missing token for ${role}: ${foreground} / ${background}`);
      failures++;
      continue;
    }
    const ratio = contrast(fg, bg);
    if (ratio + 1e-9 < minimum) {
      console.error(`✗ ${role}: ${ratio.toFixed(2)}:1; requires ${minimum}:1 (${fg} on ${bg})`);
      failures++;
    } else {
      console.log(`✓ ${role}: ${ratio.toFixed(2)}:1 (minimum ${minimum}:1)`);
    }
  }
}
if (failures) {
  console.error(`\n${failures} contrast check(s) failed. Review the role, actual usage, and token values.`);
  process.exit(1);
}
console.log("\n✓ All documented IDS semantic contrast pairs pass.");
