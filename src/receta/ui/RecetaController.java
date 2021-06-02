package receta.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import nota.model.INota;

public class RecetaController {

    @FXML
    private Button buttonExit;

    @FXML
    private VBox panelNotas;

    @FXML
    private Button buttonRecetaNormal;

    @FXML
    private Button buttonRecetaDieta;

    @FXML
    private Button buttonAddNota;

    @FXML
    private Button buttonRemoveNota;

    @FXML
    private Button buttonReturnToMenu;

    @FXML
    private Button buttonLoadNotas;

    @FXML
    private Button buttonSaveNotas;

    private void drawNota(INota nota) {
        Button button = new Button();
        String nombre = nota.getNombre();
        label.setText(nombre);
        label.setStyle("-fx-font: 22 System;");
        labels.put(nombre, label);
        panelNotas.getChildren().add(label);
    }
    @FXML
    void addNota(ActionEvent event) {

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
