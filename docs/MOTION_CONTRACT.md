# IDS Motion Contract

Motion is part of the component contract, not an optional product-level afterthought.

## Principles

- Motion must communicate state, hierarchy, and continuity.
- Components must remain usable when motion is reduced or disabled.
- Avoid motion that is required to understand content or complete an action.
- Prefer shared motion tokens/primitives over component-specific timing values.
- Product surfaces may extend motion when they preserve the accessibility contract.

## Reduced motion

When the platform requests reduced motion:

- Replace movement-based transitions with immediate or low-motion state changes.
- Do not remove semantic state changes.
- Avoid large spatial travel, bouncing, and decorative looping animation.
- Preserve focus, dismissal, and action feedback.

## Overlay behavior

Dialogs, menus, tooltips, and sheets should define:

1. enter behavior
2. exit behavior
3. reduced-motion behavior
4. focus/open behavior
5. focus/return behavior
6. dismissal behavior

## Verification

Every stable component guide should document motion and reduced-motion behavior before release.
