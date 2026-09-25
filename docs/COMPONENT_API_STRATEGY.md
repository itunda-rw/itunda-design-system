# Component API Strategy

IDS uses a hybrid API strategy.

## Flat APIs

Use a flat API when a component has a small, stable set of common options. This keeps everyday usage discoverable and concise.

Examples:
- Button
- TextField
- SearchField
- simple Card

## Compound APIs

Use compound/slot APIs when a component has meaningful internal structure or when product teams need controlled composition.

Examples:
- BottomSheet
- complex Card layouts
- future complex navigation or data-display components

## Rules

- Do not add a prop for every hypothetical use case.
- Prefer a slot when the variation is structural.
- Keep common cases flat.
- Reuse the same primitive implementation underneath flat and compound entry points.
- Preserve accessibility semantics across both APIs.
- A product-specific need should become a reusable extension point when it is likely to recur.

This follows the current TDS direction: flat APIs for simple frequent cases, compound APIs for complex and variable cases, with shared primitives underneath rather than duplicated implementations.
