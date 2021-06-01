package nota.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import main.ui.Alertas;

public class NotasController {

    @FXML
    private Button buttonExit;

    @FXML
    private ScrollPane panelNotas;

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

    @FXML
    void addNota(ActionEvent event) {
        Alertas.showWarning("Función no implementada.");
    }

    @FXML
    void exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void loadNotas(ActionEvent event) {
        Alertas.showWarning("Función no implementada.");
    }

    @FXML
    void removeNota(ActionEvent event) {
        Alertas.showWarning("Función no implementada.");
    }

    @FXML
    void returnToMenu(ActionEvent event) {

    }

    @FXML
    void saveNotas(ActionEvent event) {
        Alertas.showWarning("Función no implementada.");
    }

}


