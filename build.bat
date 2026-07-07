@echo off
setlocal

set PROJECT_DIR=%~dp0
set RESHACKER="C:\Program Files (x86)\Resource Hacker\ResourceHacker.exe"

if not exist %RESHACKER% (
    echo [ERROR] Resource Hacker not found at %RESHACKER%
    echo Download it free from https://www.angusj.com/resourcehacker/ and install it, then re-run this script.
    exit /b 1
)

echo === Cleaning old build ===
rmdir /s /q "%PROJECT_DIR%dist" 2>nul

echo === Running jpackage ===
jpackage --type app-image --name "ReplayGlitch" --input "%PROJECT_DIR%target" --main-jar ReplayGlitch-1.0-SNAPSHOT.jar --main-class com.tymon.replayglitch.Launcher --dest "%PROJECT_DIR%dist" --module-path "%PROJECT_DIR%target\libs" --add-modules javafx.controls,javafx.fxml

if not exist "%PROJECT_DIR%dist\ReplayGlitch\ReplayGlitch.exe" (
    echo [ERROR] jpackage failed - exe not found. Stopping.
    exit /b 1
)

echo === Embedding UAC manifest ===
%RESHACKER% -open "%PROJECT_DIR%dist\ReplayGlitch\ReplayGlitch.exe" -save "%PROJECT_DIR%dist\ReplayGlitch\ReplayGlitch.exe" -action addoverwrite -res "%PROJECT_DIR%app.manifest" -mask MANIFEST,1,1033

echo === Build complete: dist\ReplayGlitch\ReplayGlitch.exe ===
endlocal