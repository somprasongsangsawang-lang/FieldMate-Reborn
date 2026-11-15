# FieldMate-Reborn 0.2 — UI Master Rebuild

**Independent Android preview project. FieldMate-Android (original) must not be modified.**

## Goal

Implement the 8-screen visual direction from the user's Patch 6.4 image: airy mint + white, subtle iOS-inspired glass cards, balanced button size and minimal steps. The original project is a *behavioral reference only*, not copied wholesale.

Slogan: **แอปต้องทำงานเพื่อเรา ไม่ใช่เราต้องทำงานเพื่อแอป — เรียบง่าย เสร็จงานได้ในคลิกเดียว**

## 0.2 screens

1. Dashboard with today's work and quick shortcuts
2. People / houses list with search and status filters
3. One-screen person + existing/new house form
4. Person details with call, navigation, map, appointments and visit history
5. Appointment form (person pre-selected from detail)
6. Visit result form and status update
7. Map visual placeholder with **real Google Maps address search intent** (not a verified GPS pin)
8. Settings with clear, non-operational status of forthcoming integrations

## What works in 0.2 UI preview

- Android WebView local assets, single active index.html, no stale smartpin.html
- Local-only demo records (3 people, 2 houses, example visits/appointments) on fresh preview installs
- Add/edit person, choose an existing house or create a new house in one form
- Search people and addresses; filter visit status; switch to houses
- Create appointment, save visit result, inspect history; dashboard counters update
- Android dialer via ACTION_DIAL if phone recorded (does not make a call automatically)
- Open external Google Maps to **search the entered address**, not to navigate to a confirmed GPS pin
- Responsive layouts for phone and tablet; locally bundled SVG icons and illustration
- Basic localStorage key/schema compatibility with the 0.1 UI prototype **within the same app storage**

## Important limitations

**Do not enter real patient data.** This is a prototype with unencrypted browser localStorage and fictitious samples. It has no clinical data protection, access control, background reminders, native notification scheduling, Sheets OAuth, CSV import, GPS pinning, or migration.

For safe testing alongside 0.1, the **0.2 preview uses a separate application ID** `com.reborn.fieldmate.ui02`. 0.1 remains installed under `com.reborn.fieldmate`. This protects 0.1 and its data from replacement, but also means 0.2 does **not** automatically import data from the 0.1 installation. The local data schema was kept consistent for future controlled migration.

Do not claim production readiness based only on successful CI build. Verify Android dialer and Maps intents on physical devices; test display and action flows on vivo and Galaxy Tab S9 FE+.

## Build

Repository: `somprasongsangsawang-lang/FieldMate-Reborn` only.

```
gradle --no-daemon :app:assembleDebug
```

The existing GitHub Actions workflow (main branch `.github/workflows/build-apk.yml`) creates the debug APK artifact. **There is no stable release signing key**. The v0.2 test APK has a unique app ID to avoid unsigned/debug-key upgrade conflicts with v0.1.

## Test and rollback

Run the UI test checklist in `REBORN_0_2_TEST_CHECKLIST.md`. Keep the original v0.1 APK untouched. Only update this independent Reborn repository; never push into `FieldMate-Android`.
