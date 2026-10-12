# IDS → TDS Maturity Roadmap

**Status:** audit and implementation plan  
**Brand:** Itunda Indigo `#7472F4`; canonical Itunda logo assets remain unchanged.  
**Benchmark:** publicly documented design-system practices, including Toss TDS. IDS remains an independent Itunda system.

## Verified baseline

- `design-system/tokens/tokens.css` contains web semantic color tokens, Pretendard font declarations, typography and motion tokens, plus a dark palette under `prefers-color-scheme: dark`.
- `design-system/README.md` describes cross-platform foundations and components, but still describes the repository as being in an extraction stage.
- `showcase/index.html` includes working examples for actions, fields, navigation, selection, feedback and a sheet pattern. It explicitly notes that showcase examples do not prove every product consumes a published package.
- The showcase has a theme control; verify its implementation against actual system, light and dark modes before treating theme behavior as complete.
- Do not infer that a token or showcase example is consumed by production apps without checking imports and build/test evidence.

## Current repository evidence (2026-10-12)

- The tracked tree on this branch contains `design-system/tokens/tokens.json`, `design-system/tokens/tokens.css`, and `design-system/android/theme/IdsColors.kt`.
- The referenced `packages/design-tokens/generate-tokens.js` path is absent from this repository tree. A local deterministic generator now exists at `scripts/generate-design-tokens.mjs` and currently owns only the Android primitive-color generated region.
- The README describes SwiftUI support, but this standalone repository tree does not contain the claimed iOS source target. The main app repository **does** contain real Android, iOS, web, and Saronite/React Native design-system sources, and code search confirms iOS screens consume `IDS.Colors`; see [`MONOREPO_ADOPTION_AUDIT.md`](./MONOREPO_ADOPTION_AUDIT.md). Source-level consumers do not prove that current builds or visual parity pass.
- The main app has a token-parity contract and `scripts/design-system-parity.mjs`, but these were not run in this audit. The main app's `client/design-system/tokens.json`, `packages/design-tokens/tokens.json`, and this standalone repo's `design-system/tokens/tokens.json` are distinct files. The CSS token surfaces are also split. Their ownership/update direction must be made explicit before extending generation.
- CI in this standalone repository checks generated Android color parity and selected, explicitly documented semantic contrast pairs. These are narrow contract checks, not full-site WCAG certification or cross-platform parity proof.

## Work order

### 0. Establish evidence
- Inventory repository files, package manifests, CI workflows, test commands and current branch protections.
- Map each token source to its generated outputs and consumers.
- Record existing behavior and baseline test results before changing production components.

### 1. Canonical token contract
- First document ownership across the distinct token files in `MONOREPO_ADOPTION_AUDIT.md`; distinguish primitive palette, product semantic roles, typography/layout/motion, and web-only tokens.
- Select one machine-readable canonical source **per token family** only after verifying generators and consumers; do not flatten semantic theme-specific values into primitive colors.
- Define schema/version, required semantic roles, token naming, references, generated-file markers and deprecation rules.
- Extend deterministic generation only after tracing the main app's actual source targets and imports. The standalone repository currently generates/checks only its Android primitive-color region; web semantic CSS remains hand-authored until mappings and intentional light/dark differences are verified.
- Keep web-only layout tokens clearly separated from platform-neutral tokens.
- Add deterministic generation and a CI drift check; generated files must not be edited independently.

### 2. Theme and accessibility contract
- Define semantic light/dark roles for text, surfaces, actions, borders, focus, disabled states, success, warning and danger.
- Support explicit user theme selection as well as system preference, where product requirements allow.
- Validate contrast for text, icons and interactive controls against actual semantic backgrounds.
- Test keyboard focus, screen-reader labels, reduced motion, large text and touch targets.

### 3. Core component contracts
For Button, TextField, navigation, selection controls, feedback banners/toasts and sheets/dialogs, document:
- API and intended usage;
- default, pressed, focused, disabled, loading, error and success states where applicable;
- accessibility semantics and keyboard behavior;
- localization, long-content and narrow-screen behavior;
- platform-specific behavior and cross-platform invariants;
- unit, accessibility and visual regression tests.

### 4. Package and developer experience
- Define package ownership, public exports, supported platform matrix and minimum runtime versions.
- Adopt semantic versioning, changelogs, deprecation windows and migration guides.
- Provide copyable examples that import actual published components.
- Keep illustrative prototypes clearly marked as examples, not production guarantees.

### 5. Showcase and governance
- Demonstrate real package components wherever possible.
- Make system/light/dark theme behavior explicit and testable.
- Add component status labels: experimental, stable, deprecated.
- Require review for token changes, public API changes, accessibility regressions and brand-asset changes.

## Acceptance criteria

- Token generation is reproducible and CI detects drift.
- Required semantic roles exist in all supported themes.
- Automated checks cover token references and contrast thresholds; exceptions are documented with rationale.
- Core components have documented states and automated behavioral/accessibility tests.
- Cross-platform differences are intentional and documented.
- Documentation distinguishes implemented, tested, generated and planned capabilities.
- Brand archive/logo integrity is preserved.
- No claim of TDS parity is made until package adoption, CI, accessibility and consumer-app integration are verified.

## Public reference

Toss's public `create-ait-app` demonstrates a project generator with a dedicated React 18 + TDS scaffold and explicit template/build behavior. Use that as a reference for generator ergonomics and clear constraints, not as code to transplant into IDS.
