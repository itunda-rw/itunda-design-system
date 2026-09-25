# Itunda Design System

A cross-platform design system for the Itunda ecosystem.

IDS is built around one token vocabulary, semantic roles, reusable components, accessibility, and predictable interaction behavior across Web, Android, and iOS. The goal is not to copy another product's UI; it is to reach the same level of systemization and product-quality discipline while keeping Itunda's own visual identity.

## Current foundation
- Itunda blue brand semantics
- Light and dark semantic color roles
- Typography scale and Pretendard
- Spacing, shape, elevation, and motion primitives
- Android Jetpack Compose theme and components
- Web CSS tokens
- iOS token/theme source
- Accessibility-oriented touch targets and contrast checks

## Architecture
design-system/tokens  — source tokens and web primitives
design-system/android — Compose theme and components
design-system/ios    — SwiftUI theme and components
docs/                — system rules and contribution guidance

### Token flow
Primitive tokens → Semantic tokens → Component tokens → Platform outputs

A component should consume semantic or component tokens rather than hard-coded brand values.

## Design-system quality bar
Every shared component should define:
1. Structure and anatomy
2. Variants and sizes
3. Interaction states
4. Loading and error behavior where applicable
5. Dark-mode behavior
6. Large-text / dynamic-type behavior
7. Screen-reader semantics
8. Minimum touch target
9. Motion and reduced-motion behavior
10. Usage guidance and anti-patterns

## Brand
The current IDS semantic brand color is Itunda Blue #1F78FF. Brand identity stays in the Itunda token layer; reference systems can inform architecture and research, but IDS remains an independent implementation.

## Open source
Itunda-authored source is MIT licensed. Pretendard assets remain under the SIL Open Font License; see the bundled license file.

See docs/TOKEN_ARCHITECTURE.md and docs/COMPONENT_SPEC.md for the working rules.