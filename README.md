Commit Messages may look funky

## Getting Started

### 🚀 Just want to use it?
Head to the [Releases](../../releases) page and download the latest `ReplayGlitch.exe`. No Java, no build tools, no setup — just download and run.

> **Note:** The app requires administrator privileges to add/remove the Windows Firewall rule. You'll see a UAC prompt when launching it — this is expected and required for it to work.

### 🛠️ Building from source
If you want to modify the code and build it yourself, you'll need:

- **JDK 21+** (with JavaFX support)
- **Maven**
- **[Resource Hacker](https://www.angusj.com/resourcehacker/)** — free tool used to embed the admin-elevation manifest into the built `.exe`. Install it to the default location, or edit the `RESHACKER` path at the top of `build.bat` if yours installs elsewhere.

Then, from the project root:

```bat
mvn clean package
build.bat
```

This will:
1. Package the app with `jpackage`
2. Embed a manifest requiring administrator privileges (needed for firewall rule changes)
3. Output the final executable to `dist\ReplayGlitch\ReplayGlitch.exe`

If `build.bat` reports Resource Hacker isn't found, install it from the link above and re-run.
