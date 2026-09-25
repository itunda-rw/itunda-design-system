# Component Roadmap

## Core components
| Component | Status | Contract |
| --- | --- | --- |
| Button | Ready | variants, sizes, loading/disabled, icon, press motion |
| TextField | Added | error/supporting text, icons, localization-safe layout |
| ListRow | Added | flexible title/subtitle, leading/trailing affordances |
| Card | Ready | semantic surface, border, theme-safe elevation |
| BottomSheet | Ready | Peek/Half/Full, shared overlay, compound + flat APIs |
| Dialog | Added | decision-oriented modal contract |
| Snackbar | Added | transient feedback with semantic colors |

## Next component wave
- Checkbox / Radio / Switch
- Tabs / SegmentedControl
- SearchField
- TopAppBar
- NavigationBar
- Skeleton / Loading
- EmptyState / ErrorState
- Menu / Dropdown

## Completion rule
A component is promoted from experimental to stable only after its API, states, accessibility behavior, theme behavior, localization behavior, and documentation are defined.

## Design-system principle
Components should encode repeated product decisions instead of merely wrapping platform widgets. This is important because Toss's published design-system work describes patternizing real usage cases, polishing interaction details, and handling accessibility inside the shared component so product teams do not have to repeatedly solve those cases. urlToss Design System component researchhttps://toss.tech/article/toss-design-system