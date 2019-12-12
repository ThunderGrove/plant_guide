package ui;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import logic.LightTolerance;
import logic.PlantHandler;
import logic.PlantType;
import logic.SoilType;

public class EditWindowController {
    static int currentPlantId;

    static String name;
    static String pType;
    static String jType;
    static String light;
    static String comment;

    @FXML TextField nameText;
    @FXML ChoiceBox<String> pTypeChoice;
    @FXML ChoiceBox<String> jTypeChoice;
    @FXML ChoiceBox<String> lightChoice;

    @FXML TextArea textArea;

    @FXML Button confirm;

    public void initialize() {
        pTypeChoice.setItems(FXCollections.observableArrayList("Busk", "Staude", "Slyngplante", "Løgplante"));
        jTypeChoice.setItems(FXCollections.observableArrayList("Ler/Silt", "Sand", "Kalk", "Sur"));
        lightChoice.setItems(FXCollections.observableArrayList("Sol", "Skygge", "Tolerant"));

        nameText.setText(name);
        pTypeChoice.setValue(pType);
        jTypeChoice.setValue(jType);
        lightChoice.setValue(light);
        textArea.setText(comment);
    }

    @FXML
    void editPlant() {
        String name = nameText.getText();
        String pType = pTypeChoice.getValue();
        String jType = jTypeChoice.getValue();
        String light = lightChoice.getValue();
        String comment = textArea.getText();

        PlantType plantType = new PlantType(pTypeChoice.getSelectionModel().getSelectedIndex()+1, pType);
        SoilType soilType = new SoilType(jTypeChoice.getSelectionModel().getSelectedIndex()+1, jType);
        LightTolerance lightTolerance = new LightTolerance(lightChoice.getSelectionModel().getSelectedIndex()+1, light);

        PlantHandler plantHandler = new PlantHandler();
        plantHandler.editPlant(currentPlantId, name, plantType, soilType, lightTolerance, comment);

        Stage stage = (Stage) confirm.getScene().getWindow();
        stage.close();
        Stage stage2 = (Stage) stage.getOwner();
        stage2.close();
    }
}
