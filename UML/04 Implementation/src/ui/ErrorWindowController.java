package ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ErrorWindowController {
    static String message;

    @FXML Label label;
    @FXML Button button;

    @FXML
    void initialize() {
        label.setText(message);
    }

    @FXML
    void close() {
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }
}
