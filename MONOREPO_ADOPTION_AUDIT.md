# Monorepo Adoption Audit — IDS Standalone vs Itunda App

**Audit date:** 2026-10-12  
**Scope:** Public tracked files in `itunda-rw/itunda` on `main` and the standalone `itunda-rw/itunda-design-system` maturity branch. This is a source-tree audit, not a local build or device test.

## Verified implementation exists in the main app repository

The earlier standalone-repository limitation must not be generalized to the product repository. The main Itunda repository contains platform implementations and source-map contracts:

- **Web:** `client/design-system/tokens.css`, `components.css`, `tokens.json`, plus a `token-parity.json` contract.
- **Android:** `android/core/designsystem/src/main/java/rw/itunda/core/designsystem/theme/IdsColors.kt`, `IdsSemanticColors.kt`, `IdsTheme.kt`, and component sources.
- **iOS:** `ios/Core/DesignSystem/Sources/IDS.swift`, `ios/Core/DesignSystem/Sources/Theme/IdsTheme.swift`, and shared components.
- **React Native/Saronite:** `packages/saronite/packages/ids-react-native/` is named by the source map.
- **Parity tooling:** `scripts/design-system-parity.mjs` reads `client/design-system/token-parity.json` and inspects web, Android and iOS sources.
- **Consumer evidence:** public code search finds production iOS screens referencing `IDS.Colors`; for example, `ios/App/Sources/HoodJobs.swift`, `TalkLists.swift`, `HoodScreen.swift`, and `BusScreenView.swift`. This proves source-level use, not successful current builds or full visual parity.

Reference files:
- `client/design-system/PLATFORM_SOURCES.md`
- `client/design-system/PARITY.md`
- `client/design-system/source-map.json`
- `client/design-system/token-parity.json`
- `scripts/design-system-parity.mjs`
- `ios/App/Sources/ItundaApp.swift` (imports `CoreDesignSystem`)

## Important architecture finding: token sources are split

At least three distinct machine-readable token files are present across the repositories:

1. Standalone repo: `design-system/tokens/tokens.json`
2. Main app repo: `client/design-system/tokens.json`
3. Main app repo: `packages/design-tokens/tokens.json`

There are also two CSS token surfaces in the main app repository: `client/design-system/tokens.css` and `packages/design-tokens/tokens.css`.

The main app's `client/design-system/tokens.json` labels `client/design-system/tokens.css` as its canonical source, while `client/design-system/source-map.json` maps primitive colors to `packages/design-tokens/tokens.json` and motion to `packages/design-tokens/tokens.css`. The standalone repository has its own primitive palette and generator. These may serve distinct semantic and legacy purposes, but their ownership and update direction are not yet enforced as one machine-checkable contract.

**Do not blindly merge the files or regenerate all outputs from one source yet.** Semantic tokens include role-specific and theme-specific values that intentionally differ from raw numbered primitives. First document ownership per token family and inspect all consumers.

## Recommended next implementation sequence

1. **Choose explicit ownership by token family:** product semantic roles, primitive color scales, typography, layout, motion, and web-only tokens.
2. **Run and harden the main app parity script:** verify that it catches missing tokens, incorrect values, malformed source files and unsupported mappings; make it a required CI check for relevant changes.
3. **Add a token-source manifest:** list every source, generated output, owner, generator, and whether a file is canonical, derived, or legacy compatibility.
4. **Add deterministic drift checks per actual platform output:** only after a file is proven generated and its semantic exceptions are preserved.
5. **Verify consumer builds/tests:** Android, iOS, web and Saronite; record actual commands and results. Source presence is not build proof.
6. **Add component contracts and visual regression:** test representative button, field, list row, bottom CTA, error/empty/loading state and dark mode across supported platforms.

## Claims discipline

- The standalone repository currently generates/checks only its marked Android primitive palette.
- The main app repository does have real iOS, Android and web design-system source files and iOS source-level consumers.
- This audit did not run builds, simulators, device tests, accessibility audits, or the main app parity script.
- No claim of full Toss parity or cross-platform visual equivalence is warranted from these source checks alone.
