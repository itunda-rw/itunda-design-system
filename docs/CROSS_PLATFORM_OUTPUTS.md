# Cross-Platform Outputs

IDS is intentionally platform-neutral at the token-definition level, while generated outputs are added one platform at a time and validated before being called canonical.

## Current

| Platform | Primitive source | Generated output | Status |
| --- | --- | --- | --- |
| Android | tokens.json | android/theme/IdsColors.kt | Active |
| Web | tokens.json | web/ids-primitives.css | Added |
| iOS | tokens.json | — | Planned |
| Flutter | tokens.json | — | Planned |
| React Native | tokens.json | — | Planned |

## Design-system rule

A platform is not considered supported merely because its values happen to match another platform. It becomes supported when IDS owns a generator/output, documents the mapping, and validates drift in CI.

This prevents the common failure mode where several products independently copy a palette and gradually diverge.
