# FieldMate-Reborn 0.2 — Device Acceptance Checklist

Use **fictitious entries only**. Build/installation success is not equivalent to functional readiness.

- [ ] Installs beside 0.1 without removing/altering it (different application ID)
- [ ] Home loads, 4 cards and quick action look balanced on vivo (portrait)
- [ ] Home and bottom navigation remain readable on Galaxy Tab S9 FE+
- [ ] People tab, house tab, search and each status filter respond to touch
- [ ] Add a person using an existing house; reopen the detail
- [ ] Add a person and create a new house in the *same* screen
- [ ] Edit the person's name, age or phone; verify update
- [ ] Create an appointment from a person's detail in a short flow
- [ ] Record visit result; detail and counters reflect new status
- [ ] Save, close and reopen the 0.2 app; demo data remains (only test data)
- [ ] Test phone button with a user-supplied **test phone number**, verify dialer only
- [ ] Test Google Maps external address-search; confirm no false GPS marker
- [ ] Settings clearly marks notification, OAuth, CSV and backup as not implemented
- [ ] System Android Back returns to previous in-app view
- [ ] No crashes, blank screen or unresponsive buttons

## Known limitations

- Preview's data is localStorage, **not private/secure clinical storage**
- No native reminder scheduling or background notifications
- No Google Sheets OAuth or CSV import
- No GPS pin, no real embedded map
- 0.2 does not read 0.1 package's app-private storage

**Do not present this version as clinical-ready.**
