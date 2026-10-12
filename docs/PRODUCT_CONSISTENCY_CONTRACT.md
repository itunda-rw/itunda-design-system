# IDS Product Consistency Contract

**Status:** proposed implementation contract  
**Owner:** Itunda Design System (IDS)  
**Benchmark:** publicly documented Toss Design System practices; this is an Itunda-owned system, not a rebrand or a claim of internal Toss equivalence.  
**Brand:** preserve canonical Itunda assets and Brand v3; current brand accent is `#8F89FF`. Do not regenerate or alter locked logo assets as part of token work.

## Purpose

A design system is only consistent when the same user intent produces the same visual hierarchy, interaction, accessibility behavior, and failure recovery across the consumer app, business app, developer portal, web products, and Saronite mini-apps.

A token or showcase example is not evidence that a production screen consumes it. Each adoption claim must name the actual consumer and the check that verifies it.

## 1. Ownership rules

1. Maintain an explicit inventory of token files, generators, generated regions, package exports, and production imports before changing ownership.
2. Define canonical sources per token family: primitive palette, semantic roles, typography, layout/spacing, shape, elevation, motion, and component-specific tokens. Do not collapse semantic light/dark mappings into primitive palette values.
3. Mark generated regions and make generation deterministic. CI must fail on drift; generators must never silently overwrite hand-authored code outside owned regions.
4. Keep web-only and platform-specific tokens explicit where native platform conventions differ. Shared meaning is required; identical implementation syntax is not.
5. Version breaking token or component-contract changes, document migration steps, and retain compatibility until consumers have migrated.
6. Preserve the Itunda brand and canonical assets. Toss values or patterns may be used only where publicly documented and technically verified; undocumented spacing, elevation, or internal architecture must not be presented as Toss facts.

## 2. Cross-platform semantic contract

Every supported platform must map the same semantic roles to its native implementation:

- Content: primary, secondary, tertiary, inverse, disabled.
- Surfaces: canvas, elevated surface, grouped surface, overlay.
- Borders and focus: subtle border, strong border, focus indicator.
- Actions: primary, secondary, destructive, quiet, disabled.
- Feedback: success, warning, danger, informational.
- Interaction states: default, pressed, focused, selected, disabled, loading, and error.
- Themes: light and dark, plus system preference where supported.

The mapping may use platform-native APIs, but meaning, contrast intent, and state behavior must not drift. Brand accent is not automatically a valid text color; every foreground/background pair must be checked in its actual usage.

## 3. Component quality contract

Every shared component must document and test:

- Purpose and appropriate use; when not to use it.
- API, required/optional parameters, defaults, and platform differences.
- Visual states and state transitions, including loading, empty, success, and failure where relevant.
- Keyboard/focus behavior on web and assistive-technology labels on native platforms.
- Minimum touch targets, readable large text, truncation/wrapping, and reduced-motion behavior.
- Localization, including long Korean and Kinyarwanda strings and currency/date formatting where applicable.
- Light/dark theme behavior and contrast for text, icons, borders, and focus indicators.
- Unit/component tests plus at least one representative integration or visual-regression check.

A component is not complete merely because it renders in the showcase.

## 4. Product-level consistency rules

1. **One primary action per decision point.** Secondary actions must not visually compete with the intended next step.
2. **Purpose → context → action.** Explain why a screen exists, show the context needed to decide, then expose the next safe action.
3. **Consistent navigation semantics.** Back, close, cancel, dismiss, and destructive confirmation must mean the same thing across products.
4. **Consistent feedback.** Loading, success, validation errors, network errors, retry, and offline states must be recognizable and recoverable.
5. **Consistent financial presentation.** Amounts, RWF currency, fees, recipients, review steps, pending states, and final confirmation must use shared patterns. Never imply a transfer succeeded before the server confirms it.
6. **Consistent identity and consent.** Login, session expiry, permissions, data-sharing consent, and logout must have a predictable contract across native apps and mini-apps.
7. **Accessible by default.** Color is never the only signal. Preserve screen-reader semantics, logical focus order, large-text layouts, and reduced motion.
8. **Localized by design.** Avoid hardcoded user-facing strings and fixed-width layouts that break for Kinyarwanda, Korean, or English.
9. **No false affordances.** Every enabled-looking action must work, or be clearly disabled with a useful explanation.
10. **Respect product identity.** Reuse interaction principles, not Toss logos, proprietary assets, or unverified internal implementation assumptions.

## 5. Evidence and release gates

| Gate | Required evidence | Does not prove |
|---|---|---|
| Token validation | Schema and required-role checks pass | Production adoption |
| Drift check | Generated outputs match canonical inputs | Runtime visual correctness |
| Contrast check | Explicitly tested foreground/background pairs pass the chosen WCAG target | Whole-site accessibility compliance |
| Component tests | State, API, and accessibility assertions pass | End-to-end product quality |
| Platform build | Android/iOS/web/mini-app build succeeds | On-device or production behavior |
| Integration journey | Real navigation and backend behavior verified | All user journeys |
| Visual/runtime review | Light/dark, large text, localization, and representative screens inspected | Full accessibility certification |
| Deployment check | Correct revision and health confirmed in target environment | Business or regulatory readiness |

Report each gate separately as **not run**, **passed**, **failed**, or **blocked**. Never convert a source-level check into a claim of live verification.

## 6. Initial adoption audit

For each surface, record the actual file/package consumer, semantic-token source, component source, theme coverage, accessibility checks, test command, last verified revision, and remaining gaps.

| Surface | Required first check |
|---|---|
| Android native | Trace IDS/TDS imports and verify real light/dark screens, states, and accessibility |
| iOS native | Trace IDS semantic colors and component usage; distinguish parse, build, simulator, and device evidence |
| Web consumer/business/developer sites | Trace CSS/package imports and check responsive layouts, contrast, focus, and errors |
| Saronite mini-apps | Verify host-provided tokens/components are actually consumed by each mini-app |
| Showcase and docs | Ensure examples match shipped APIs and clearly label examples that are not production components |
| Internal tools | Apply the same roles, navigation, form validation, permission, and error-state contracts |

## 7. Recommended implementation sequence

1. Complete the current token ownership and monorepo adoption audit.
2. Select canonical sources per token family based on real imports and existing generators.
3. Add schema validation, deterministic generation, and drift checks without broad rewrites.
4. Add cross-platform semantic and contrast contract tests.
5. Establish component specs and migrate the highest-traffic primitives first: button, text field, list row, card, feedback, dialog/sheet, and navigation.
6. Audit one representative end-to-end journey per surface; start with authentication and a money-related journey because inconsistent states there carry higher user risk.
7. Expand to every product area, then gate new components and product screens on these contracts.

## Acceptance criteria

- Every token family has a documented owner and migration path.
- Every production surface has a verified consumer inventory.
- CI detects token drift and required-role omissions.
- Shared components have documented states and accessibility/localization requirements.
- Light/dark and responsive behavior are checked on representative real screens.
- Product journeys use consistent navigation, feedback, and error recovery.
- Verification reports distinguish source checks, builds, runtime checks, and deployments.
