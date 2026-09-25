# Component Audit Matrix

This audit turns the IDS quality gate into a repeatable component-by-component review.

TDS documents components from the large structure down to detailed states, then explicitly covers worst-case content, dark mode, larger text, screen-reader behavior, reduced motion, and overlay positioning where relevant. IDS follows the same discipline while preserving Itunda-owned tokens and APIs.

## Audit dimensions

| Dimension | Required evidence |
| --- | --- |
| Anatomy | Every visual/interactive region is named |
| Variants | Real product use cases are represented without one-off forks |
| States | Default, pressed, focused, disabled, loading, error and selected states are covered where applicable |
| Content resilience | Long text, multiline, localization and large text do not break layout |
| Accessibility | One clear semantic target, labels for meaningful icons, decorative icons excluded, appropriate roles |
| Theme | Light and dark are explicit; product themes use semantic overrides rather than raw color literals |
| Motion | Press/enter/exit behavior has a named rule; reduced-motion behavior is defined |
| Position | Overlays define placement, dismissal and layering |
| API | Defaults are safe, localization-owned copy is not hidden in reusable components |
| Documentation | Worst-case example, Do/Don't guidance and usage examples exist |

## Current priority audit

### 1. Dialog
**Implemented**
- Action labels are now caller-owned; IDS no longer embeds English `Confirm` / `Cancel` defaults.

**Gaps to close**
- Audit call sites for localized labels.
- Define focus/dismissal behavior for TalkBack.
- Document long-title and long-message cases.
- Document position/layering and back-button dismissal.
- Define reduced-motion behavior.

### 2. BottomSheet
**Implemented**
- Sheet description and heading semantics are exposed.
- Dismiss action is exposed to assistive technologies when provided.

**Gaps to close**
- Define focus entry/exit behavior for modal variants.
- Document nested scrolling/content overflow.
- Define reduced-motion behavior for detent transitions.
- Separate modal and non-modal contracts explicitly.

### 3. Button
**Gaps to close**
- Replace raw component color derivations with component-level semantic tokens.
- Document loading, focus, long-label and large-text cases.
- Define reduced-motion behavior for press feedback.
- Ensure icon-only buttons always require meaningful accessible labels.

### 4. TextField / SearchField
**Gaps to close**
- Keep all user-facing labels and accessibility descriptions caller-owned/localized.
- Document error/supporting-text semantics.
- Audit large text, multiline and IME behavior.
- Define clear-button accessibility and focus behavior.

### 5. Snackbar
**Implemented**
- Snackbar content is exposed as a polite live region.

**Gaps to close**
- Define action semantics and timeout expectations.
- Document when a snackbar is insufficient because information must persist.
- Audit implementation imports.

### 6. Feedback states
**Gaps to close**
- Remove English defaults from reusable copy APIs.
- Define loading announcement semantics.
- Define error/retry semantics.
- Add long-text and large-text examples.

## Next implementation wave

1. Dialog focus/dismissal contract.
2. BottomSheet focus, nested-scroll and reduced-motion contract.
3. Motion/easing implementation with reduced-motion behavior.
4. Client / Business / Developer derived theme values.
5. Worst-case component playground.
6. Automated accessibility/API checks.

## Definition of done

A component is not promoted to Ready merely because it renders correctly. It must have documented variants/states, content resilience, accessibility, theme behavior, interaction/motion rules, localization ownership, and a worst-case example.

Reference methodology: https://toss.tech/article/toss-design-system-guide
