package ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import logic.*;

import java.io.IOException;
import java.util.ArrayList;

public class MainWindowController {
    @FXML private TableView<Plant> plantList;
    @FXML private TableColumn<Plant, String> navnColumn;
    @FXML private TableColumn<Plant, PlantType> plantetypeColumn;
    @FXML private TableColumn<Plant, SoilType> jordtypeColumn;
    @FXML private TableColumn<Plant, LightTolerance> lystoleranceColumn;
    @FXML private TableColumn<Plant, String> infoColumn;
    @FXML private TextField search;

    public void initialize() {
        showPlants();
    }

    @FXML
    public void moveToCreateWindow() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CreateWindow.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.setTitle("Ny plante");
        stage.setResizable(false);
        stage.initOwner(Main.window);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();
        stage.setOnHidden(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                showPlants();
            }
        });
    }

    @FXML
    public void moveToDetailWindow() throws IOException {
        if (plantList.getSelectionModel().getSelectedItem() == null)
            return;

        DetailWindowController.currentPlantId = plantList.getSelectionModel().getSelectedItem().getPlantID();
        DetailWindowController.name = plantList.getSelectionModel().getSelectedItem().getName();
        DetailWindowController.jType = "" + plantList.getSelectionModel().getSelectedItem().getSoilType().getName();
        DetailWindowController.pType = "" + plantList.getSelectionModel().getSelectedItem().getPlantType().getName();
        DetailWindowController.light = "" + plantList.getSelectionModel().getSelectedItem().getLighttolerance().getName();
        DetailWindowController.comment = "" + plantList.getSelectionModel().getSelectedItem().getExtra();

        Parent root = FXMLLoader.load(getClass().getResource("DetailWindow.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.setTitle("Detaljeret");
        stage.setResizable(false);
        stage.initOwner(Main.window);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();
        stage.setOnHidden(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                showPlants();
            }
        });
    }

    public void showPlants() {
        PlantHandler plantHandler = new PlantHandler();
        ArrayList<Plant> array = plantHandler.search();

        ObservableList<Plant> list = FXCollections.observableArrayList();

        list.addAll(array);

        navnColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        plantetypeColumn.setCellValueFactory(new PropertyValueFactory<>("plantTypeUI"));
        jordtypeColumn.setCellValueFactory(new PropertyValueFactory<>("soilTypeUI"));
        lystoleranceColumn.setCellValueFactory(new PropertyValueFactory<>("lighttoleranceUI"));
        infoColumn.setCellValueFactory(new PropertyValueFactory<>("extra"));

        plantList.setItems(list);
    }

    @FXML
    public void search() {
        PlantHandler plantHandler = new PlantHandler();
        ArrayList<Plant> array = plantHandler.search(search.getText());

        ObservableList<Plant> list = FXCollections.observableArrayList();

        list.addAll(array);

        navnColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        plantetypeColumn.setCellValueFactory(new PropertyValueFactory<>("plantTypeUI"));
        jordtypeColumn.setCellValueFactory(new PropertyValueFactory<>("soilTypeUI"));
        lystoleranceColumn.setCellValueFactory(new PropertyValueFactory<>("lighttoleranceUI"));
        infoColumn.setCellValueFactory(new PropertyValueFactory<>("extra"));

        plantList.setItems(list);
    }
}
