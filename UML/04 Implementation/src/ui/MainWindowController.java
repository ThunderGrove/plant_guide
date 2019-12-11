package ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import logic.Plant;
import persistence.DBPlant;

import java.io.IOException;
import java.util.ArrayList;

public class MainWindowController {
    @FXML private TableView<Plant> plantList;
    @FXML private TableColumn<Plant, String> navnColumn;
    @FXML private TableColumn<Plant, Integer> plantetypeColumn;
    @FXML private TableColumn<Plant, Integer> jordtypeColumn;
    @FXML private TableColumn<Plant, Integer> lystoleranceColumn;
    @FXML private TableColumn<Plant, String> infoColumn;

    public void initialize() {
    }

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

    public void showPlants() {
        ArrayList<Plant> array = DBPlant.getPlants();

        ObservableList<Plant> list = FXCollections.observableArrayList();

        list.addAll(array);

        navnColumn.setCellValueFactory(new PropertyValueFactory<>("plantName"));
        plantetypeColumn.setCellValueFactory(new PropertyValueFactory<>("plantType"));
        jordtypeColumn.setCellValueFactory(new PropertyValueFactory<>("soilType"));
        lystoleranceColumn.setCellValueFactory(new PropertyValueFactory<>("lighttolerance"));
        infoColumn.setCellValueFactory(new PropertyValueFactory<>("comment"));

        plantList.setItems(list);
    }
}
