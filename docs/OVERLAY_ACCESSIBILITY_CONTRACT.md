# Overlay Accessibility Contract

This contract applies to dialogs, bottom sheets, menus, tooltips, and snackbar-like transient surfaces.

## Dialogs

- The title identifies the decision or task.
- Dismissal is always available unless the product explicitly requires a blocking flow.
- Confirm and dismiss actions must have product-localized labels.
- Opening a dialog should establish a predictable accessibility focus target.
- Closing should return focus to the invoking control where the platform permits it.
- Content must remain usable when text size increases.

## Bottom sheets

- The sheet must expose its role and accessible heading.
- Drag gestures must not be the only way to dismiss or navigate.
- Scrollable content must remain discoverable when it exceeds the available viewport.
- Important actions should remain reachable without depending on animation.

## Menus and tooltips

- Menu items expose their action or selected state, not decorative icon descriptions.
- Long menus must scroll without hiding the existence of additional content.
- Tooltips supplement, rather than replace, an accessible label.

## Transient feedback

- Success, error, and loading states must communicate meaningful state changes to assistive technology.
- Visual color alone must not be the only state indicator.
- Snackbar actions should remain keyboard/screen-reader reachable.

## Localization

IDS components should avoid hard-coded user-facing English defaults where the component is expected to ship across locales. Labels belong to the product localization layer.

## Reduced motion

Motion may reinforce hierarchy and state transitions, but no essential meaning should depend on animation. Components should provide a reduced-motion path when platform preferences are available.

## Verification

For each overlay component, test:

1. default text;
2. long localized text;
3. large text;
4. dark theme;
5. screen reader;
6. keyboard/focus navigation where supported;
7. dismissal;
8. reduced motion;
9. loading/disabled states;
10. content exceeding the viewport.

This document defines the target contract; it does not claim that every current implementation has already passed every verification item.
