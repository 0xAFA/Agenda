package main.ui;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AgendaController {

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
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/Notas.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println("Error en la carga del archivo FXML.");
            System.out.println(e);
            System.exit(1);
        }
    }

    @FXML
    void goToRecetas(ActionEvent event) {
        Alertas.showWarning("Función no implementada.");
    }

    @FXML
    void goToTareas(ActionEvent event) {
        Alertas.showWarning("Función no implementada.");
    }

}
