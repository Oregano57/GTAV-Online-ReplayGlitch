package com.tymon.replayglitch;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.io.IOException;

public class HelloController {
    @FXML
    private Label statusLabel;

    @FXML
    protected void onActionOneClick() {
        // Enclosed the rule name in explicit quotes \" to ensure Windows parses it cleanly
        String command = "netsh advfirewall firewall add rule name=\"GTAReplayGlitch\" dir=out action=block remoteip=192.81.241.171";
        runWindowsCommand(command, "Firewall Rule Added", "Active");
    }

    @FXML
    protected void onActionTwoClick(){
        // Enclosed the rule name in explicit quotes \" to ensure Windows parses it cleanly
        String command = "netsh advfirewall firewall delete rule name=\"GTAReplayGlitch\"";
        runWindowsCommand(command, "Firewall Rule Removed", "Inactive");
    }

    private void runWindowsCommand(String command, String successMessage, String uiStatus){
        try {
            ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", command);
            pb.redirectErrorStream(true);
            Process process = pb.start();

            java.io.BufferedReader reader = new java.io.BufferedReader(
                    new java.io.InputStreamReader(process.getInputStream())
            );
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("CMD Output: " + line);
            }

            int exitCode = process.waitFor();
            if(exitCode == 0) {
                statusLabel.setText(uiStatus); // Dynamically updates to "Active" or "Inactive"
                System.out.println(successMessage);
            } else {
                System.out.println("Error Code: " + exitCode);
            }
        }
        catch (IOException | InterruptedException e){
            statusLabel.setText("System Error");
            e.printStackTrace();
        }
    }
}