package ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.util.ArrayList;

public class CreateWindowController {
    @FXML TextField nameText;
    @FXML ChoiceBox<String> pTypeChoice;
    @FXML ChoiceBox<String> jTypeChoice;
    @FXML ChoiceBox<String> lightChoice;

    @FXML TextArea textArea;

    @FXML Button confirm;

    @FXML
    void initialize() {
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
