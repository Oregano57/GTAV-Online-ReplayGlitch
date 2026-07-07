Commit Messages may look funky

## Getting Started

### 🚀 Just want to use it?
Head to the [Releases](../../releases) page and download the latest `ReplayGlitch-<version>.exe` installer. No Java, no build tools, no setup — just run the installer.

> **Note:** The app requires administrator privileges to add/remove the Windows Firewall rule. You'll see a UAC prompt both when running the installer and when launching the app — this is expected and required for it to work.

### 🛠️ Building from source
If you want to modify the code and build it yourself, you'll need:

- **JDK 21+** (with JavaFX support)
- **Maven**
- **[Resource Hacker](https://www.angusj.com/resourcehacker/)** — free tool used to embed the admin-elevation manifest into the built `.exe`. Install it to the default location, or edit the `RESHACKER` path at the top of `build.bat` if yours installs elsewhere.
- **[WiX Toolset v3.11.2](https://github.com/wixtoolset/wix3/releases/tag/wix3112rtm)** — download `wix311.exe` from that page and run it. Used to build the Windows installer. Use v3.11.2 specifically, not v4/v5 — those aren't currently compatible with jpackage. Requires the **.NET Framework 3.5** Windows feature (Control Panel → Programs → Turn Windows features on or off) if not already enabled.

Then, from the project root:

```bat
mvn clean package
build.bat
```

This will:
1. Package the app with `jpackage`
2. Embed a manifest requiring administrator privileges (needed for firewall rule changes)
3. Build a Windows installer with WiX
4. Output the final installer to `installer\ReplayGlitch-<version>.exe`

Before building a new release, bump the `APP_VERSION` variable near the top of `build.bat` to match your intended git tag.

If `build.bat` reports Resource Hacker isn't found, install it from the link above and re-run.
