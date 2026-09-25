# IDS Token Model

The Itunda Design System follows a three-layer token model so visual decisions can evolve without rewriting components.

## 1. Primitive tokens

Raw scales such as blue-500, grey-700, and red-500. They are canonical building blocks and are not intended to encode product meaning.

## 2. Semantic tokens

Stable meanings such as brand, textPrimary, surface, divider, danger, and success. Components should consume semantic tokens whenever possible.

Semantic tokens are the contract for Light/Dark mode and future Itunda product themes. A theme may change the value while preserving the meaning.

## 3. Component tokens

Component-specific decisions such as button fill, field border, selected-tab indicator, or dialog surface. These prevent component implementation details from leaking into global primitives.

## Metadata target

As IDS grows, canonical token data should expose machine-readable metadata for every token:

| Field | Purpose |
| --- | --- |
| category | Broad family such as Color, Typography, Layout, Effect |
| styleElement | Specific element such as Color, Spacing, Radius, Shadow |
| level | base, semantic, or component |
| name | Stable token identifier |
| type | Token value type |
| value | Literal value or token reference |
| description | Human-readable intent |

This mirrors the useful structural principle documented by Toss's token-system work while keeping IDS naming, values, and ownership independent. The immediate source remains the current primitive JSON; migration to richer metadata should be incremental and generator-backed.

## Rules

- Never make a component depend directly on a brand hex value.
- Prefer semantic tokens over primitive numbers in component code.
- Keep Light/Dark mappings in the theme layer.
- Generated files must not be hand-edited.
- A token change must be validated across affected platforms before release.
