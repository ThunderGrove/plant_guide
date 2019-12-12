package ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class DetailWindowController {
    static int currentPlantId;

    static String name;
    static String pType;
    static String jType;
    static String light;
    static String comment;

    @FXML Label nameLabel;
    @FXML Label pTypeLabel;
    @FXML Label jTypeLabel;
    @FXML Label lightLabel;

    @FXML TextArea textArea;

    @FXML Button edit;
    @FXML Button delete;

    public void initialize() {
        nameLabel.setText(name);
        pTypeLabel.setText(pType);
        jTypeLabel.setText(jType);
        lightLabel.setText(light);

        textArea.setText(comment);
        textArea.setEditable(false);
    }

    @FXML
    public void moveToEditWindow() throws IOException {
        EditWindowController.currentPlantId = currentPlantId;
        EditWindowController.name = name;
        EditWindowController.pType = pType;
        EditWindowController.jType = jType;
        EditWindowController.light = light;
        EditWindowController.comment = comment;

        Parent root = FXMLLoader.load(getClass().getResource("EditWindow.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.setTitle("Rediger plante");
        stage.setResizable(false);
        stage.initOwner(edit.getScene().getWindow());
        stage.initModality(Modality.WINDOW_MODAL);

        stage.show();
    }

    @FXML
    public void moveToConfirmationWindow() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ConfirmationWindow.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.setTitle("Slet plante - bekræft sletning");
        stage.setResizable(false);
        stage.initOwner(delete.getScene().getWindow());
        stage.initModality(Modality.WINDOW_MODAL);

        stage.show();
    }
}
