# Token code generation

Itunda Design System keeps primitive color values in:

`design-system/tokens/tokens.json`

The token source currently generates deterministic primitive outputs for Android and Web:

- Android: `design-system/android/theme/IdsColors.kt`
- Web: `design-system/web/ids-primitives.css`

Run both generators:

```bash
node packages/design-tokens/generate-tokens.js
node packages/design-tokens/generate-web-primitives.js
```

CI regenerates both outputs and fails when the generated files drift from the committed source.

## Rules

1. Edit the JSON source, not generated Android or Web primitive values.
2. Keep product meaning in semantic tokens rather than component code.
3. Keep the Itunda brand token independent: the primary brand is Itunda blue `#1F78FF`.
4. Generated regions must remain deterministic and bounded by explicit markers.
5. Semantic and component tokens should become machine-readable before adding additional platform generators.
6. Cross-platform outputs must preserve token names and semantic meaning even when platform syntax differs.

This follows the same general direction described by Toss: machine-readable tokens, semantic/component layers, automated platform output, theme support, and a single source of truth. urlToss color-system architecturehttps://toss.tech/article/43385
