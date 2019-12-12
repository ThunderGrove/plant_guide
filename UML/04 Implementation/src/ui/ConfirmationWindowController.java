package ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import logic.PlantHandler;

import java.io.IOException;

public class ConfirmationWindowController {
    @FXML private Button no;
    @FXML private Button yes;

    @FXML
    void close() {
        Stage stage = (Stage) no.getScene().getWindow();
        stage.close();
    }

    @FXML
    void accept() {
        PlantHandler plantHandler = new PlantHandler();
        plantHandler.deletePlant(DetailWindowController.currentPlantId);
        Stage stage = (Stage) yes.getScene().getWindow();
        stage.close();
        Stage stage2 = (Stage) stage.getOwner();
        stage2.close();
    }
}
