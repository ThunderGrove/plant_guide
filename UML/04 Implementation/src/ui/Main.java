package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        window.setTitle("Plant Guide");
        window.setScene(new Scene(root, 771.0, 468.0));
        window.setResizable(false);
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
