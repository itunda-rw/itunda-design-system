# Worst-Case Component Matrix

IDS components are treated as reusable product infrastructure, not just visual primitives. Before a component is considered stable, verify the cases below on Android and document equivalent expectations for other platforms.

| Component | Long text | Large text | Dark mode | Disabled/loading | Screen reader | Focus/dismiss | Reduced motion | Overflow |
|---|---|---|---|---|---|---|---|---|
| Button | Required | Required | Required | Required | Required | N/A | Required | Required |
| TextField | Required | Required | Required | Required | Required | Required | N/A | Required |
| SearchField | Required | Required | Required | Required | Required | Required | N/A | Required |
| ListRow | Required | Required | Required | Required | Required | N/A | N/A | Required |
| Card | Required | Required | Required | N/A | Required | N/A | N/A | Required |
| Dialog | Required | Required | Required | Required | Required | Required | Required | Required |
| BottomSheet | Required | Required | Required | Required | Required | Required | Required | Required |
| DropdownMenu | Required | Required | Required | Required | Required | Required | Required | Required |
| Snackbar | Required | Required | Required | Required | Required | Required | Required | Required |
| Tabs | Required | Required | Required | Required | Required | Required | N/A | Required |
| NavigationBar | Required | Required | Required | Required | Required | Required | Required | Required |
| SegmentedControl | Required | Required | Required | Required | Required | Required | N/A | Required |
| SelectionControls | Required | Required | Required | Required | Required | Required | N/A | Required |
| Feedback states | Required | Required | Required | Required | Required | Required | Required | Required |

## Stability rule

A component should not be promoted to stable solely because its default state looks correct. The implementation and documentation should cover the states and environmental conditions that commonly cause product teams to fork a component.

## Accessibility contract

At minimum, verify:

- visible labels remain understandable when text scales;
- interactive elements expose their purpose rather than decorative icon names;
- modal surfaces define predictable open, close, and focus behavior;
- menus and sheets remain navigable when content becomes scrollable;
- disabled, loading, selected, and error states are conveyed non-visually;
- decorative icons do not create duplicate announcements.

## Localization contract

Do not rely on English as an implicit default for user-visible component labels. Product-facing labels should be supplied by the product's localization layer, while IDS should provide structural APIs that make localization possible.

## Motion contract

Interactive motion should have a documented purpose and should degrade gracefully when reduced-motion preferences are enabled. Avoid making animation a prerequisite for understanding state changes.

This matrix is intentionally a contract rather than a claim that every current component already satisfies every cell.
