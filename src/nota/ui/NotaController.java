package nota.ui;

import common.ui.Scenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import common.ui.Alertas;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import nota.model.INota;
import nota.model.Nota;
import nota.repository.INotaManager;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Controlador de la interfaz gráfica de la aplicación de notas.
 */
public class NotaController {

    private INotaManager manager;
    private HashMap<String, Label> labels = new HashMap<>();

    // Elementos gráficos

    @FXML
    private ListView<String> panelNotas;
    
    @FXML
    private Button buttonAddNota;

    @FXML
    private Button buttonRemoveNota;

    @FXML
    private Button buttonReturnToMenu;

//    @FXML
//    private Button buttonLoadNotas;

//    @FXML
//    private Button buttonSaveNotas;

    /**
     * Añade una nota al Manager.
     * @param event
     */
    @FXML
    void addNota(ActionEvent event) {
        String nombre = Alertas.showInputDialog("Introduce la nota:", "Introducir nota", "");
        Nota nota = new Nota(nombre);
        if(manager.create(nota)) {
            drawNota(nota);
        }
    }

    /**
     * Permite al usuario seleccionar una nota para eliminar de la aplicación.
     * @param event
     */
    @FXML
    void removeNota(ActionEvent event) {
        ArrayList<String> allNotes = new ArrayList<>();

        for (INota nota : manager.readAll()) {
            allNotes.add(nota.getNombre());
        }

        String nombre = Alertas.showChoiceDialog(allNotes, "Selecciona la nota que quieres borrar", "Eliminar nota");

        manager.remove(nombre);
        eraseNota(nombre);
    }

    /**
     * Lee las notas contenidas en el archivo..
     * @param event
     */
   // @FXML
    public void loadNotas(/*ActionEvent event*/) {
    	panelNotas.getItems().clear();
        ArrayList<INota> notas = manager.readAll();
        for (INota nota : notas) {
            if(!labels.containsKey(nota.getNombre()))
                drawNota(nota);
            }
    }

    /**
     * Dibuja las notas en pantalla.
     * @param nota Nota que se va a dibujar.
     */
    private void drawNota(INota nota) {
//        Label label = new Label();
//        String nombre = nota.getNombre();
//        label.setText(nombre);
//        label.setStyle("-fx-font: 22 System;");
//        labels.put(nombre, label);
        panelNotas.getItems().add(nota.getNombre());
    }

    /**
     * Borra una nota de la pantalla.
     * @param name Nombre de la nota.
     */
    private void eraseNota(String name) {
        panelNotas.getItems().remove(labels.get(name));
        loadNotas();
        
    }

    /**
     * Vuelve al menú principal, preguntando antes al usuario si desea guardar las notas.
     * @param event
     */
    @FXML
    void returnToMenu(ActionEvent event) {

        askToSave();

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(Scenes.getData().getSceneAgenda());
    }

    /**
     * Cierra la aplicación, solicitando antes al usuario si desea guardar las notas.
     * @param event
     */

    /**
     * Guarda las notas en un archivo.
     * @param event
     */


    /**
     * Pregunta al usuario si quiere guardar las notas antes de salir.
     */
    private void askToSave() {
        if(Alertas.showYesNoDialog("¿Desea guardar las notas?", "Guardar notas")) {
            saveNotas(new ActionEvent());
        }
    }

    @FXML
    void saveNotas(ActionEvent event) {
        manager.saveAll();
    }

    /**
     * Asigna un NotaManager a la aplicación.
     * @param manager NotaManager.
     */
    public void setManager(INotaManager manager) {
        this.manager = manager;
    }

}


