# Token Architecture

## Goal
IDS uses a layered token model so a visual decision is made once and can propagate to every platform.

### 1. Primitive
Raw values that describe measurable scales: color, typography, spacing, radius, motion, elevation.
Primitive tokens should not be used directly by product screens when a semantic role exists.

### 2. Semantic
Semantic tokens describe intent: background, surface, text-primary/secondary/tertiary, brand, danger/warning/success, divider, icon-primary/secondary, pressed/selected.
Semantic tokens are where light/dark themes map to the same product intent.

### 3. Component
Component tokens describe a component-specific contract such as button-fill-primary, input-border-default, list-row-height, sheet-background, and navigation-active-icon.
Component tokens prevent components from reaching directly into unrelated primitives.

## Rules
- Prefer semantic names over visual names at call sites.
- Do not introduce external-product token names.
- Brand identity belongs to IDS.
- Keep token names stable even when underlying values change.
- New semantic tokens require documented usage, not a one-off screen.
- Platform implementations map to the same semantic vocabulary.
- Dark mode is a theme mapping, not a second unrelated palette.
- Accessibility constraints are checked when a token is introduced or changed.

## Source of truth
design-system/tokens/tokens.json is the primitive source for generated platform values. Hand-authored semantic mappings remain explicit so their intent is reviewable.

Current machine-readable registry: `design-system/tokens/semantic-component.tokens.json`. It records semantic intent and component contracts using category, style element, level, name, type, value/reference, and description. Primitive values remain canonical in `tokens.json`.

## Registry validation

`design-system/tokens/tokens.json` remains the canonical primitive source. `design-system/tokens/semantic-component.tokens.json` is the machine-readable semantic/component registry. CI validates both JSON documents before generating platform primitives, so malformed token metadata fails early rather than reaching generated outputs. This keeps the token model human- and machine-readable while preserving a clear source-of-truth boundary, consistent with TDS's documented token architecture. urlToss color/token systemhttps://toss.tech/article/43385
