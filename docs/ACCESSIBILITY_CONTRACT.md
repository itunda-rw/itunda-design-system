# Accessibility Contract

Every stable IDS component must make accessibility behavior part of its API and specification rather than leaving it to each product team.

## Required checks

- Name: interactive icons expose a meaningful action label; decorative icons are not announced.
- Role: controls expose the correct semantic role.
- State: selected, checked, disabled, expanded, loading, and error states are exposed when applicable.
- Target: interactive controls preserve a usable touch target even when their visual icon is small.
- Text: content can grow for large-text settings and long localized strings.
- Focus: overlays define opening, dismissal, and focus behavior.
- Contrast: text, icons, states, and interactive surfaces are checked in light and dark themes.
- Motion: essential state changes remain understandable when reduced-motion preferences are enabled.
- Localization: labels and user-facing strings are supplied by the product or localization layer rather than hidden English defaults.

## Component review evidence

A component guide should include at least one worst-case example covering long content, the maximum relevant combination of optional elements, and the accessibility behavior of that state.

This mirrors the practical approach described by Toss TDS: components are expected to absorb edge cases such as large text, screen readers, dark mode, and interaction details so product teams do not repeatedly solve them themselves.
