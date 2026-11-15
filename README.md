# FieldMate Reborn — INDEPENDENT UI Preview

New Android project; **not a branch of FieldMate-Android**. Different package ID `com.reborn.fieldmate` and app label `FieldMate Reborn PREVIEW`.

## Status
UI prototype with local-only sample workflows: people + house in one form, search, appointments, visit notes, dashboard, settings and map placeholder. **Not production ready.** Native Android notifications, background permissions, Google Sheets OAuth/CSV import, GPS/Google Maps, secure clinical data storage and migrations are **NOT implemented**. Do not enter real patient data.

## Build
1. Create a **new, empty** GitHub repository `FieldMate-Reborn` (not the old repository).
2. Upload all extracted files, including hidden `.github/workflows/build-apk.yml`, to the root of the new repository, branch `main`.
3. Open Actions > `FieldMate Reborn - Independent APK Preview` > Run workflow, or wait for the automatic push build.
4. After success, download the `FieldMate-Reborn-Preview-APK` artifact and extract `app-debug.apk`.

## Design requirements
Patch 6.4 screenshot is a **visual reference only**: minimal mint-white iOS-inspired glass style, eight conceptual screens, balanced controls, short workflows. Source code is independently authored, not copied from the original FieldMate source.

## Next development
Implement native functionality only after checking the original 6.3 TEST behavior, with regression testing on vivo and Samsung. Maintain strict repository separation.
