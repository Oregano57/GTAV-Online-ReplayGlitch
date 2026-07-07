module com.tymon.replayglitch {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tymon.replayglitch to javafx.fxml;
    exports com.tymon.replayglitch;
}