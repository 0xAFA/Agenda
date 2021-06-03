package main.ui;
import common.ui.Alertas;
import common.ui.Scenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import nota.repository.INotaManager;
import receta.repository.IRecetaManager;

public class AgendaController {

    private INotaManager notaManager;
    private Scene sceneNota;

    public Scene getSceneNota() {
        return sceneNota;
    }

    public void setSceneNota(Scene sceneNota) {
        this.sceneNota = sceneNota;
    }

    @FXML
    private Button buttonExit;

    @FXML
    private Button buttonGoToNotas;

    @FXML
    private Button buttonGoToTareas;

    @FXML
    private Button buttonGoToRecetas;

    @FXML
    private Button buttonGoToCalendario;

    @FXML
    private Button buttonGoToFlashcards;

    public void setNotaManager(INotaManager manager) {
        this.notaManager = manager;
    }

    @FXML
    void exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void goToCalendario(ActionEvent event) {
        Alertas.showWarning("Función no implementada.");
    }

    @FXML
    void goToFlashcards(ActionEvent event) {
        Alertas.showWarning("Función no implementada.");
    }

    @FXML
    void goToNotas(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(Scenes.getData().getSceneNota());
    }

    @FXML
    void goToRecetas(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(Scenes.getData().getSceneReceta());
    }

    @FXML
    void goToTareas(ActionEvent event) {
        Alertas.showWarning("Función no implementada.");
    }

}
