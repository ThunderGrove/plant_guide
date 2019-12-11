package ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindowController {

    @FXML
    public void moveToCreateWindow() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Plant Guide-3.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.setTitle("Ny plante");
        stage.setResizable(false);
        stage.initOwner(Main.window);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();
    }

    @FXML
    public void moveToEditWindow() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Plant Guide-4.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.setTitle("Rediger plante");
        stage.setResizable(false);
        stage.initOwner(Main.window);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();
    }
}
