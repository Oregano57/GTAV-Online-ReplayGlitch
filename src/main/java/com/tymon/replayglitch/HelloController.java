package com.tymon.replayglitch;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.io.IOException;

public class HelloController {
    @FXML
    private Label statusLabel;


    @FXML
    protected void onActionOneClick() {
        String command = "netsh advfirewall firewall add rule name=GTAReplayGlitch dir=out action=block remoteip=192.81.241.171";
        runWindowsCommand(command, "Firewall Rule Added");
    }
    @FXML
    protected void onActionTwoClick(){
        String command = "netsh advfirewall firewall delete rule name=GTAReplayGlitch";
        runWindowsCommand(command, "Firewall Rule Removed");
    }

    private void runWindowsCommand(String command, String successMessage){
        try {
            ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", command);
            Process process = pb.start();
            int exitCode = process.waitFor();

            if(exitCode == 0) {
                statusLabel.setText("Active");
                System.out.println(successMessage);
            }
            else {
                System.out.println("Error Code: " + exitCode);
            }
        }
        catch (IOException | InterruptedException e){
            statusLabel.setText("System Error");
            e.printStackTrace();
        }

    }
}
