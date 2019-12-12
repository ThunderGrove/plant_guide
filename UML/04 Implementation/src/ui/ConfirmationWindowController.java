package ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import logic.PlantHandler;

public class ConfirmationWindowController {
    @FXML private Button no;
    @FXML private Button yes;

    void close() {
        Stage stage = (Stage) no.getScene().getWindow();
        stage.close();
    }

    void accept() {
        PlantHandler plantHandler = new PlantHandler();
        plantHandler.deletePlant(DetailWindowController.currentPlantId);
        Stage stage = (Stage) yes.getScene().getWindow();
        stage.close();
    }
}
