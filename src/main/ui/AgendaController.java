package main.ui;

import common.ui.Alertas;
import common.ui.Scenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Controlador del menú principal del programa.
 */
public class AgendaController {

    // Elementos gráficos

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

    /**
     * Salir de la aplicación.
     * @param event
     */
    @FXML
    void exit(ActionEvent event) {
        System.exit(0);
    }

    /**
     * Ir a la aplicación Calendario.
     * @param event
     */
    @FXML
    void goToCalendario(ActionEvent event) {
    	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(Scenes.getData().getSceneCalendario());
    }

    /**
     * Ir a la aplicación Flashcards.
     * @param event
     */
    @FXML
    void goToFlashcards(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(Scenes.getData().getSceneFlashcard());
    }
    /**
     * Ir a la aplicación Notas.
     * @param event
     */
    @FXML
    void goToNotas(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(Scenes.getData().getSceneNota());
    }

    /**
     * Ir a la aplicación Recetas.
     * @param event
     */
    @FXML
    void goToRecetas(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(Scenes.getData().getSceneReceta());
    }

    /**
     * Ir a la aplicación Tareas.
     * @param event
     */
    @FXML
    void goToTareas(ActionEvent event) {
        Alertas.showWarning("Funcion no implementada.");
    }

}
