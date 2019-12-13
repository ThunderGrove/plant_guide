package ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

import java.io.IOException;
import java.util.ArrayList;

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
        PlantHandler plantHandler = new PlantHandler();
        ArrayList<PlantType> pTypes = plantHandler.getAllPlantTypes();
        ObservableList<String> pList = FXCollections.observableArrayList();

        for (int i = 0; i < pTypes.size(); i++) {
            pList.addAll(pTypes.get(i).getName());
        }

        ArrayList<SoilType> jTypes = plantHandler.getAllSoilTypes();
        ObservableList<String> jList = FXCollections.observableArrayList();

        for (int i = 0; i < jTypes.size(); i++) {
            jList.addAll(jTypes.get(i).getName());
        }


        ArrayList<LightTolerance> lights = plantHandler.getAllLightTolerances();
        ObservableList<String> lightList = FXCollections.observableArrayList();

        for (int i = 0; i < lights.size(); i++) {
            lightList.addAll(lights.get(i).getName());
        }

        pTypeChoice.setItems(pList);
        jTypeChoice.setItems(jList);
        lightChoice.setItems(lightList);

        nameText.setText(name);
        pTypeChoice.setValue(pType);
        jTypeChoice.setValue(jType);
        lightChoice.setValue(light);
        textArea.setText(comment);
    }

    @FXML
    void editPlant() throws IOException {
        if (nameText.getText().equals("") ||pTypeChoice.getValue() == null||jTypeChoice.getValue() == null||lightChoice.getValue() == null) {
            Main main = new Main();
            main.ErrorWindow("Nogle felter mangler værdier.");
            return;
        }

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
