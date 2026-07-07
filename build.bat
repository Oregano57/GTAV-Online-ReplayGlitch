@echo off
rmdir /s /q dist
jpackage --type app-image --name "ReplayGlitch" --input target --main-jar ReplayGlitch-1.0-SNAPSHOT.jar --main-class com.tymon.replayglitch.Launcher --dest dist --module-path target/libs --add-modules javafx.controls,javafx.fxml

"C:\Program Files (x86)\Resource Hacker\ResourceHacker.exe" -open "dist\ReplayGlitch\ReplayGlitch.exe" -save "dist\ReplayGlitch\ReplayGlitch.exe" -action addoverwrite -res "app.manifest" -mask MANIFEST,1,1033