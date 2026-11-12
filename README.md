# Commute Cards (Android)

The whole app (decks, explanations, diagrams, games) is bundled inside, so it works with no signal.

## Get the APK (no Android tools needed)
1. Create a free GitHub account if you don't have one, then make a **new repository** (it can be private).
2. On the repo page click **Add file → Upload files** and drag in everything from this folder
   (including the `.github` folder). Click **Commit changes**.
3. Open the **Actions** tab. A "Build APK" run starts automatically and takes about 3–5 minutes.
4. When it shows a green tick, open the run and download **CommuteCards-apk** at the bottom (a zip with `app-debug.apk` inside).
5. Send `app-debug.apk` to your phone, tap it, and allow "Install unknown apps" when Android asks.

## Notes
- Features that need Claude (account sync, "Make cards from my notes", "Ask a question", tougher-choice downloads)
  are hidden in the APK. Everything else works offline.
- Your progress is stored in the app. Use the ⋯ menu → Copy backup now and then.
