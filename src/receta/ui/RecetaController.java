package receta.ui;

import common.ui.Alertas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import nota.model.INota;
import nota.model.Nota;
import receta.model.IReceta;
import receta.model.Receta;
import receta.model.RecetaNormal;
import receta.repository.IRecetaManager;

import java.util.HashMap;


public class RecetaController {
    private IRecetaManager manager;
    private HashMap<String, Button> buttons = new HashMap<>();

    @FXML
    private Button buttonExit;

    @FXML
    private VBox panelNotas;

    @FXML
    private Button buttonRecetaNormal;

    @FXML
    private Button buttonRecetaDieta;

    @FXML
    private Button buttonAddReceta;

    @FXML
    private Button buttonRemoveReceta;

    @FXML
    private Button buttonReturnToMenu;

    @FXML
    private Button buttonLoadRecetas;

    @FXML
    private Button buttonSaveRecetas;

    private void drawNota(IReceta receta) {
        Button button = new Button();
        String nombre = receta.getNombre();
        button.setText(nombre);
        button.setStyle("-fx-font: 22 System;");
        buttons.put(nombre, button);
        panelNotas.getChildren().add(button);
    }

    @FXML
    void addReceta(ActionEvent event) {

    }

    @FXML
    void exit(ActionEvent event) {

    }

    @FXML
    void loadNotas(ActionEvent event) {

    }

    @FXML
    void recetaDieta(ActionEvent event) {

    }

    @FXML
    void recetaNormal(ActionEvent event) {

    }

    @FXML
    void removeNota(ActionEvent event) {

    }

    @FXML
    void returnToMenu(ActionEvent event) {

    }

    @FXML
    void saveNotas(ActionEvent event) {

    }

}

