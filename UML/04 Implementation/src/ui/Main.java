package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static Stage window;
    public static Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;

        Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        window.setTitle("Plant Guide");
        scene = new Scene(root, 771.0,468.0);
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void ErrorWindow(String message) throws IOException {
        ErrorWindowController.message = message;

        Parent root = FXMLLoader.load(getClass().getResource("ErrorWindow.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        
        stage.setScene(scene);
        stage.setTitle("Fejl");
        stage.setResizable(false);
        stage.initOwner(Main.window);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();
    }
}
