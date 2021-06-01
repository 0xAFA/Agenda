package nota.ui;

import common.ui.Scenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import common.ui.Alertas;
import javafx.stage.Stage;
import nota.repository.INotaManager;

public class NotasController {

    private INotaManager manager;

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
        //askToSave();
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

        // preguntar si se quieren guardar las notas antes de salir
        //askToSave();

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(Scenes.getData().getSceneAgenda());
    }

    @FXML
    void saveNotas(ActionEvent event) {
        Alertas.showWarning("Función no implementada.");
    }

    public void setManager(INotaManager manager) {
        this.manager = manager;
    }

}


