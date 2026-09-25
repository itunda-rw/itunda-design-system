# IDS Quality Rubric

A component is system-quality only when its behavior is defined, reusable, accessible, and documented.

## 1. Structure
- Anatomy is explicit.
- Variants represent real product differences.
- API avoids one-off visual flags.
- Worst-case composition is documented.

## 2. States
Check default, pressed, focused, disabled, selected, loading, error, and success where relevant.

## 3. Content resilience
Test:
- long Korean, English, and Kinyarwanda labels
- large text
- narrow screens
- empty values
- localization expansion

## 4. Accessibility
Check:
- semantic role
- accessible name
- screen-reader reading order
- focus behavior
- minimum touch target
- contrast
- reduced motion

## 5. Theme
Check light/dark behavior and semantic-token usage. Components must not introduce product-specific hard-coded colors.

## 6. Interaction
Define press feedback, transitions, dismissal, focus restoration, and motion reduction where relevant.

## 7. Documentation
Every stable component should have:
- API
- full-option example
- states
- accessibility notes
- localization/large-text notes
- do/don't guidance

## 8. Verification
Check both implementation and rendered behavior where possible:
- generated token outputs are synchronized
- component registry entries exist for tokenized components
- accessibility semantics are present for interactive/overlay components
- localization-owned labels contain no reusable English defaults
- worst-case matrix coverage is documented

## 9. Adoption
Prefer one shared component over repeated product-local implementations. If teams repeatedly need an escape hatch, reconsider the component contract instead of multiplying custom variants.

This rubric reflects patterns described in Toss's published TDS guidance: full-option examples, explicit state/detail specifications, accessibility guidance, larger-text behavior, dark mode, and position rules for overlays. urlToss TDS guide methodologyhttps://toss.tech/article/toss-design-system-guide
