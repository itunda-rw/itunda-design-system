# Itunda Product Simplicity Standard

Status: proposal
Scope: Itunda mobile apps, web products, mini apps, SDKs, and internal tools.
Reference: learn from publicly documented Toss product/design principles; preserve Itunda's own identity, assets, and Rwanda-first product requirements.

## Product promise

A person should understand the purpose of a screen, the information that matters, and the next action without having to learn the interface.

## Principles

1. **One screen, one primary job.** Give each screen one clear outcome and one visually dominant primary action. Move secondary actions out of the primary path.
2. **Use familiar language.** Prefer short, everyday Kinyarwanda-first copy. Explain unfamiliar financial, identity, map, and technical concepts in context; never expose internal service names to customers.
3. **Remove work, not just pixels.** Default safe values, reuse verified information with consent, preserve progress, prefill known fields, and remove redundant confirmation steps. Keep confirmation for irreversible, high-impact, or regulated actions.
4. **Make the next step obvious.** Keep the main action in a predictable reachable location, visible above the keyboard when relevant, with clear enabled, disabled, loading, success, and error states.
5. **Progressive disclosure.** Show the minimum needed to complete the current task; reveal optional details when requested. Do not hide fees, risks, permissions, or consequential terms.
6. **Prevent errors and recover gracefully.** Validate inline, explain how to fix a problem, preserve entered data, and offer a retry or alternative. Errors must distinguish user input, network, service, and permission failures.
7. **Design for real conditions.** Support slower networks, low-end Android devices, interrupted sessions, localization, large text, screen readers, keyboard navigation, and reduced motion.
8. **Trust through clarity.** Before money movement, identity sharing, or publishing, show who receives what and what will happen. Never simplify away security or meaningful consent.
9. **Consistent patterns, not identical products.** Reuse Itunda Design System components and interaction patterns across products; adapt only when user research shows a real need.
10. **Measure outcomes.** Test simplification hypotheses with users and instrument task completion, time-to-complete, abandonment, error/retry rate, support contacts, and accessibility defects.

## Interaction rules

- Prefer one focused question per step when a task is unfamiliar or consequential; group fields only when they are naturally understood together.
- Keep labels persistent; do not use placeholder text as the only label.
- Use inline validation after a field has enough information to validate. Avoid premature red errors.
- Disable a primary action only when the reason is understandable and the user can see how to proceed.
- Use motion only to communicate state or spatial continuity; respect reduced-motion settings.
- Provide immediate feedback for actions, but never show success before the server confirms it.
- Empty states must explain why the page is empty and provide one useful next action.
- Keep navigation labels task-oriented and consistent across mobile and web.
- Do not add cards, borders, gradients, or glass effects unless they improve hierarchy or comprehension. Visual polish must not compete with the task.

## Itunda-specific application

- **Home:** prioritize a small set of high-frequency actions; make the neighborhood marketplace, communication, and identity services understandable without a crowded feature directory.
- **Maps and places:** show real, indexed Rwanda places only. Clearly distinguish loading, no results, location permission denied, offline, and service failure; never substitute placeholder pins for real data.
- **Authentication:** minimize repeated input without weakening phone verification or PIN security. Explain connectivity failures accurately and preserve the user's progress.
- **Payments and identity:** display amount, recipient, fees, data shared, and reversibility before confirmation. Require explicit consent for consequential actions.
- **Localization:** Kinyarwanda-first copy; allow translated content to expand without clipping, truncation, or moving the primary action off-screen.
- **Brand:** use Itunda's approved assets and current design tokens. Do not copy Toss logos, proprietary UI assets, or Toss branding.

## Review checklist

For every new or redesigned flow, answer:
- What is the single user goal?
- Can a first-time user explain the next action in a few seconds?
- Which steps, fields, decisions, and taps can be removed safely?
- Does the flow work with large text, a screen reader, reduced motion, and a slow/interrupted connection?
- Are loading, empty, success, failure, retry, and permission states designed?
- Are fees, privacy implications, and irreversible outcomes clear before commitment?
- What metric and usability test will tell us whether the change helped?

## Rollout method

1. Establish a baseline from current analytics and usability tests.
2. Map the highest-friction user journeys and rank them by impact, frequency, and failure severity.
3. Prototype one change at a time; test with Rwandan users across language, device, and connectivity conditions.
4. Ship behind a feature flag or staged rollout when feasible.
5. Compare completion, time, abandonment, error rate, and support contacts; keep or revert based on evidence.
6. Add successful patterns to IDS components, documentation, examples, and regression tests.

## First priorities

1. Authentication and PIN/network error recovery.
2. Maps search: genuine Rwanda place results and honest empty/error states.
3. Home navigation: fewer competing choices and a clearer primary task.
4. Shared form, button, loading, empty-state, and error components.
5. Public-site and developer-doc navigation: task-first information architecture and copy.
