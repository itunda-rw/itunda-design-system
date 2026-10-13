# Itunda Simplification Implementation Backlog

Status: proposed acceptance criteria
Parent standard: [Product Simplicity Standard](./product-simplicity.md)

This backlog translates the standard into testable work. It does not claim the existing app currently satisfies any item. Implementation owners must inspect current code and collect baseline behavior before changing production flows.

## P0 — Authentication: clear recovery, not extra taps

### Required behavior
- Distinguish invalid PIN, offline/no connection, request timeout, rate limit, and server failure with accurate, user-facing copy.
- Never describe a connectivity/server failure as an incorrect PIN.
- Preserve the phone number and safe, non-secret progress when retrying.
- Never persist or log the PIN in analytics, crash reports, or debug logs.
- Keep PIN entry masked and use a numeric keypad.
- Show progress while submitting; prevent duplicate submissions without trapping the user.
- Provide a clear retry path and a useful alternative when retry is not possible.
- Do not show a success state until the server confirms authentication.

### Acceptance checks
- Unit tests cover each mapped error category and unknown errors.
- UI tests verify progress, retry, duplicate-tap handling, and preserved non-secret input.
- Security tests or code review verify no PIN logging or persistence.
- Manual test on a real Android device covers airplane mode, slow connection, timeout, wrong PIN, and recovered connection.

## P0 — Maps: honest search states and real data

### Required behavior
- Render only places returned by the configured, indexed Rwanda place data source.
- Keep loading, successful results, zero results, permission denied, offline, timeout, and server failure as distinct states.
- A zero-result state offers a clear next step: edit query, widen the area, or retry when relevant.
- A service error must not be presented as a legitimate empty search result.
- Do not generate placeholder pins or invented business names.
- Keep the query and map viewport stable when recovering from a transient error, where safe.
- Make map/list state coherent: selected result, map marker, and detail view refer to the same place identifier.

### Acceptance checks
- Contract tests validate the expected place schema and required stable identifiers.
- Integration tests verify results originate from the actual configured place index.
- Tests cover zero results separately from network and backend errors.
- A production smoke test searches for known, independently verified Rwanda places and checks their identifiers and coordinates.
- Manual checks cover location permission denied, no location, slow network, and empty search.

## P1 — Home: one clear next action

### Required behavior
- Identify top user jobs from research and analytics rather than adding more shortcuts by intuition.
- Give the primary task stronger hierarchy than secondary destinations.
- Remove duplicate entry points unless testing shows they help discovery.
- Keep labels short, task-oriented, and Kinyarwanda-first.
- Avoid forcing onboarding users to understand the entire super-app before completing a first useful task.

### Acceptance checks
- Run a first-click test with representative users.
- Compare task completion, time-to-first-success, abandonment, and support questions to baseline.
- Confirm text scaling and screen-reader navigation remain usable.

## P1 — Shared interaction components in IDS

Standardize component contracts for:
- Primary/secondary/destructive actions.
- Text, phone, numeric, search, and PIN fields.
- Inline validation and field errors.
- Loading, retry, offline, empty, and success states.
- Confirmation for irreversible or high-impact actions.
- Permission requests and explanations.

Each component needs documented states, keyboard/focus behavior, accessibility semantics, localization constraints, examples, and tests. Avoid introducing a component solely for visual novelty.

## P2 — Public websites and developer tools

- Organize pages by visitor task: use Itunda, run a business, integrate, build, or get support.
- Make API authentication, errors, examples, rate limits, and versioning discoverable.
- Ensure every code example is runnable against a supported environment and does not expose secrets.
- Keep status and release claims tied to observable deployments and CI evidence.
- Measure search success, documentation task completion, broken links, and repeated support questions.

## Measurement contract

Record baseline and post-change measurements for:
- Task completion rate.
- Median and p90 time to complete.
- Abandonment at each step.
- Error and retry rates by error category.
- Accessibility defects.
- Support contacts attributable to the flow.

Segment results by device capability, language, and connectivity where privacy-safe and statistically meaningful. Do not optimize click count alone: removing a necessary consent or safety step is not simplification.

## Rollout gates

1. Code owner maps each requirement to an existing file, screen, API contract, and test.
2. Tests pass locally and in CI; failures are investigated rather than bypassed.
3. Accessibility, security, and localization review pass.
4. Staged rollout or feature flag is used where practical.
5. Production smoke test confirms real backend behavior.
6. Metrics show improvement without increased errors, fraud risk, or support burden.
7. Update this backlog with evidence and close only verified items.
