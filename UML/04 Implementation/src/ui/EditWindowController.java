package ui;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EditWindowController {
    static int currentPlantId;

    static String name;
    static String pType;
    static String jType;
    static String light;
    static String comment;

    @FXML TextField nameText;
    @FXML ChoiceBox pTypeChoice;
    @FXML ChoiceBox jTypeChoice;
    @FXML ChoiceBox lightChoice;

    @FXML
    TextArea textArea;

    public void initialize() {
        pTypeChoice.setItems(FXCollections.observableArrayList("Busk", "Staude", "Slyngplante", "Løgplante"));
        jTypeChoice.setItems(FXCollections.observableArrayList("Ler/Silt", "Sand", "Kalk", "Sur"));
        lightChoice.setItems(FXCollections.observableArrayList("Sol", "Skygge", "Tolerant"));
    }
}
