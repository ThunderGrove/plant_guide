package ui;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import logic.LightTolerance;
import logic.PlantHandler;
import logic.PlantType;
import logic.SoilType;

import java.io.IOException;

public class CreateWindowController {
    @FXML TextField nameText;
    @FXML ChoiceBox<String> pTypeChoice;
    @FXML ChoiceBox<String> jTypeChoice;
    @FXML ChoiceBox<String> lightChoice;

    @FXML TextArea textArea;

    @FXML Button confirm;

    @FXML
    void initialize() {
        pTypeChoice.setItems(FXCollections.observableArrayList("Busk", "Staude", "Slyngplante", "Løgplante"));
        jTypeChoice.setItems(FXCollections.observableArrayList("Ler/Silt", "Sand", "Kalk", "Sur"));
        lightChoice.setItems(FXCollections.observableArrayList("Sol", "Skygge", "Tolerant"));
    }

    @FXML
    void createPlant() throws IOException {
        if (nameText.getText().equals("") ||pTypeChoice.getValue() == null||jTypeChoice.getValue() == null||lightChoice.getValue() == null) {
            Main main = new Main();
            main.ErrorWindow("Nogle felter mangler værdier.");
            return;
        }

        PlantHandler plantHandler = new PlantHandler();
        String name = nameText.getText();
        String pType = pTypeChoice.getValue();
        String jType = jTypeChoice.getValue();
        String light = lightChoice.getValue();
        String comment = textArea.getText();
        plantHandler.createPlant(name, new PlantType(pTypeChoice.getSelectionModel().getSelectedIndex()+1, pType), new SoilType(jTypeChoice.getSelectionModel().getSelectedIndex()+1, jType), new LightTolerance(lightChoice.getSelectionModel().getSelectedIndex()+1, light), comment);
        Stage stage = (Stage) confirm.getScene().getWindow();
        stage.close();
    }
}
