# Theme Architecture

IDS uses a derived-theme model so Client, Business, and Developer surfaces can share the same foundations and components without forking implementations.

## Layers

1. Primitive tokens — raw scales such as grey, blue, red, and green.
2. Semantic tokens — meaning such as brand, surface, text-primary, and danger.
3. Component tokens — component-specific geometry and behavior such as Button height and radius.
4. Derived themes — product/surface-specific overrides applied to semantic and component tokens.

## Rules

- Core IDS owns the default Itunda blue brand (#1F78FF).
- Derived themes override meaning, not component implementation.
- A Client, Business, or Developer surface should not fork shared components just to change branding.
- Overrides should be expressed through stable semantic/component token names.
- Primitive palettes remain shared foundations.
- Light/Dark remains an orthogonal mode; a derived theme must work in both modes.
- New overrides should be added only when a real product requirement exists.

## Android API

IdsThemeVariant identifies the intended product surface:

- Core
- Client
- Business
- Developer

IdsThemeOverrides provides controlled semantic override points. The default variants intentionally inherit Core values until a product-specific brand decision is required.

This keeps the architecture ready for white-label and multi-product expansion without inventing three separate design systems.

## TDS alignment

Toss describes derived themes as a way to share foundations while overriding semantic and component tokens for different products and functions. IDS follows the same architectural principle while keeping its own token names, APIs, and brand.
