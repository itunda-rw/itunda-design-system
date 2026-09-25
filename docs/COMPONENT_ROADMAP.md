# Component Roadmap

## Core components
| Component | Status | Contract |
| --- | --- | --- |
| Button | Ready | variants, sizes, disabled, icon, press motion |
| TextField | Added | error/supporting text, icons, localization-safe layout |
| SearchField | Added | search affordance, clear action, semantic focus |
| ListRow | Added | flexible title/subtitle, leading/trailing affordances |
| Card | Ready | semantic surface, border, theme-safe elevation |
| BottomSheet | Ready | Peek/Half/Full, shared overlay, compound + flat APIs |
| Dialog | Added | decision-oriented modal contract |
| Snackbar | Added | transient feedback with semantic colors |
| Checkbox | Added | shared selection row |
| Radio | Added | shared single-selection row |
| Switch | Added | shared preference toggle row |
| Tabs | Added | horizontal scrolling, selected/unselected states |

## Next component wave
- SegmentedControl
- TopAppBar
- NavigationBar
- Skeleton / Loading
- EmptyState / ErrorState
- Menu / Dropdown
- Focus/error/disabled state audit across every component
- Component tokens and generated platform outputs

## Completion rule
A component is promoted from experimental to stable only after its API, states, accessibility behavior, theme behavior, localization behavior, and documentation are defined.

## Design-system principle
Components should encode repeated product decisions instead of merely wrapping platform widgets. Toss's published design-system work emphasizes patternizing real usage cases, interaction quality, accessibility, and consistent component guidance. urlToss Design System component researchhttps://toss.tech/article/toss-design-system
