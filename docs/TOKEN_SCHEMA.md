# Itunda Token Schema

## Purpose

The token source is moving from a flat color dictionary toward a machine-readable model that can support Web, Android, iOS, Flutter, and React Native without making component code depend on raw values.

This follows the useful architectural lesson in Toss Design System's 2025 color-system work: tokens should carry meaning and metadata so they can be transformed into platform outputs. IDS keeps the same engineering principle while retaining its own names, values, and brand identity.

## Current compatibility model

design-system/tokens/tokens.json remains backward-compatible with the current generator:

- colors — primitive color values used by the Android generator today.
- schemaVersion — declares the token-model version.
- metadata — describes the intended token dimensions for future semantic/component tokens.

The current generator still produces Android primitive colors only. No platform output should be described as generated until its generator exists and its output is validated.

## Target token record

Future semantic/component records should use:

| Field | Meaning |
| --- | --- |
| category | color, typography, spacing, radius, motion, elevation, etc. |
| styleElement | the design property being represented |
| level | primitive, semantic, or component |
| name | stable semantic identifier |
| type | color, dimension, duration, cubic-bezier, etc. |
| value | source value or reference |
| description | intended use and constraints |

## Rules

1. Components consume semantic tokens whenever a semantic role exists.
2. Raw hex values must not appear in reusable components unless they are true one-off illustration/content assets.
3. Primitive changes must be reviewed for every generated platform output.
4. Semantic names remain stable when visual values change.
5. Light/dark behavior belongs to theme mappings, not duplicated component logic.
6. Component tokens should be introduced only when a reusable component needs a stable local role.
7. Generated files are never hand-edited.

## Reference

Toss's published TDS material describes a token model with category, style element, level, name, type, value, and description, and describes a pipeline from token tooling through GitHub PRs and platform preprocessing. IDS is adopting the structural lesson, not copying TDS's proprietary naming or values.
