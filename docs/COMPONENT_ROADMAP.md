# Component Roadmap

## Core components
| Component | Status |
| --- | --- |
| Button | Ready |
| TextField | Refined |
| SearchField | Added |
| ListRow | Refined |
| Card | Ready |
| BottomSheet | Ready |
| Dialog | Added |
| Snackbar | Added |
| Checkbox / Radio / Switch | Added |
| Tabs | Refined |
| TopAppBar | Added |
| NavigationBar | Added |
| SegmentedControl | Added |
| Loading / Empty / Error | Added |

## Next wave
- Menu / Dropdown — Refined (long-list scrolling + selected state)
- Skeleton — Added
- Tooltip — Added
- Date / time selection patterns
- Component-level token layer — Expanded (Button + Card)
- Theme overrides for client / business / developer surfaces — Architecture added (docs/THEME_ARCHITECTURE.md)
- Generated iOS / Flutter / React Native outputs
- Full accessibility and localization audit — In progress (`docs/COMPONENT_AUDIT.md`)
- Component API strategy — Documented (flat + compound)\n- Component examples and worst-case playgrounds — Contract matrix added (`docs/WORST_CASE_MATRIX.md`)

## Quality gate
A component becomes stable only after API, states, accessibility, theme, localization, large-text, motion, documentation, and worst-case usage are defined.

TDS explicitly treats long text, dark mode, screen-reader behavior, reduced motion, and overlay positioning as component-guide concerns rather than product-by-product decisions. IDS uses the same quality gate while keeping Itunda's own blue brand and component APIs. urlToss component guide methodologyhttps://toss.tech/article/toss-design-system-guide
