# Component Specification

A shared component is not complete when it merely renders correctly in the happy path.

## Required contract
### Anatomy
Document structural parts and which parts are optional.
### Variants
Use explicit variants for meaningful product differences. Avoid separate components for small visual changes that belong in a variant or size.
### States
At minimum: default, pressed, focused, disabled, selected, loading, and error/success where applicable.
### Content
Components must survive long labels, localization, empty content, large text settings, and narrow screens.
### Accessibility
Define semantic role, accessible name, focus behavior, screen-reader behavior, minimum touch target, and contrast expectations.
### Motion
Define entry/exit and press behavior where motion communicates state. Respect reduced-motion preferences.
### Theme
Define light and dark behavior using semantic tokens. Do not hard-code screen-level colors.
### Documentation
Each component should eventually have API, examples, variants, states, accessibility notes, and do/don't guidance.

## Adoption rule
If a product screen needs a visual treatment more than once, first ask whether the behavior belongs in IDS. Repeated local implementations are a signal that the system is missing a reusable primitive.