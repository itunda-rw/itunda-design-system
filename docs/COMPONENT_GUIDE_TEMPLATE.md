# Component Guide: [Component Name]

Use this template for every stable IDS component. The order is intentional: understand the whole component first, then its options, then edge cases, then accessibility.

## 1. Overview

- Purpose:
- When to use:
- When not to use:
- Platform availability:
- Stability: Draft / Experimental / Stable

## 2. Worst-case example

Show the component with the maximum realistic combination of content and options: long localized labels, optional leading/trailing content, error/loading states, and the narrowest supported width.

## 3. Anatomy

| Part | Required | Behavior |
| --- | --- | --- |
| | | |

## 4. Variants and sizes

| Variant | Use |
| --- | --- |
| | |

## 5. States

Document default, pressed, focused, disabled, selected, loading, error, success, and any component-specific states.

## 6. Content resilience

Check:
- localization / translated text
- long labels and values
- large text / font scaling
- narrow screens
- empty or missing optional content
- dynamic content updates

## 7. Position and layering

For overlays, sheets, dialogs, menus, tooltips, and floating UI, document anchor, placement, dismissal, z-order, safe areas, and focus restoration.

## 8. Accessibility

- Semantic role:
- Accessible name:
- Focus order:
- Screen-reader behavior:
- Touch target:
- Contrast:
- Keyboard / switch access:
- Reduced motion:

## 9. Theme

Document Light/Dark semantic-token mappings and any future theme constraints. Components must not depend on product-specific hex values.

## 10. Motion

Document state-change motion, duration/easing or spring behavior, and reduced-motion behavior.

## 11. API and examples

Provide copyable examples for common and edge-case usage.

## 12. Do / Don't

### Do

### Don't

## 13. Quality checklist

- [ ] API matches the component contract
- [ ] Worst-case case reviewed
- [ ] Localization reviewed
- [ ] Large text reviewed
- [ ] Accessibility reviewed
- [ ] Light/Dark reviewed
- [ ] Reduced motion reviewed
- [ ] Narrow-screen behavior reviewed
- [ ] Documentation reviewed
- [ ] Generated/platform outputs synchronized
