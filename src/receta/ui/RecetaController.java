package receta.ui;

import common.ui.Alertas;
import common.ui.Scenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import nota.model.INota;
import receta.model.IReceta;
import receta.model.Receta;
import receta.model.RecetaDieta;
import receta.repository.IRecetaManager;

import java.util.ArrayList;
import java.util.HashMap;
//Controlador de la interfaz gráfica de la aplicación de flashcards.

public class RecetaController {

    private IRecetaManager manager;
    private HashMap<String, Label> labels = new HashMap<>();

    //Elementos gráficos.

    @FXML
    private ListView<String> panelRecetas;

    @FXML
    private Button buttonExit;

    @FXML
    private Button buttonAddReceta;

    @FXML
    private Button buttonRemoveReceta;

    @FXML
    private Button buttonReturnToMenu;

    /**
     * Añade una receta al Manager.
     * @param event
     */
    @FXML
    void addRecetaDieta(ActionEvent event) {
        String nombre = Alertas.showInputDialog("Introduce la receta:", "Introducir receta", "");
        Receta receta = new RecetaDieta(4208430);
        receta.setNombre(nombre);
        if(manager.create(receta)) {
            drawReceta(receta);
        }
    }

    @FXML
    void exit(ActionEvent event) {
        askToSave();
        System.exit(0);
    }
    /**
     * Pregunta al usuario si quiere guardar las recetas antes de salir.
     */
    private void askToSave() {
        if(Alertas.showYesNoDialog("¿Desea guardar las recetas?", "Guardar recetas")) {
            saveRecetas(new ActionEvent());
        }
    }
    /**
     * Lee las recetas contenidas en el archivo.
     */
    @FXML
    void loadRecetas() {
        panelRecetas.getItems().clear();
        ArrayList<IReceta> recetas = manager.readAll();
        for (IReceta receta : recetas) {
            if(!labels.containsKey(receta.getNombre()))
                drawReceta(receta);
        }
    }
    /**
     * Dibuja las recetas en pantalla.
     * @param receta Receta que se va a dibujar.
     */
    private void drawReceta(IReceta receta) {
        panelRecetas.getItems().add(receta.getNombre());
    }

    /**
     * Borra una receta de la pantalla.
     * @param name Nombre de la receta.
     */
    private void eraseReceta(String name) {
        panelRecetas.getItems().remove(labels.get(name));
        loadRecetas();    }
    /**
     * Permite al usuario seleccionar una receta para eliminar de la aplicación.
     * @param event
     */
    @FXML
    void removeReceta(ActionEvent event) {
        ArrayList<String> allNotes = new ArrayList<>();

        for (IReceta receta : manager.readAll()) {
            allNotes.add(receta.getNombre());
        }

        String nombre = Alertas.showChoiceDialog(allNotes, "Selecciona la receta que quieres borrar", "Eliminar receta");

        manager.remove(nombre);
        eraseReceta(nombre);
    }
    /**
     * Vuelve al menú principal, preguntando antes al usuario si desea guardar las recetas.
     * @param event
     */
    @FXML
    void returnToMenu(ActionEvent event) {

        askToSave();

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(Scenes.getData().getSceneAgenda());
    }

    @FXML
    void saveRecetas(ActionEvent event) {
        manager.saveAll();
    }
    /**
     * Asigna una receta a la aplicación.
     * @param manager RecetaManager.
     */
    public void setManager(IRecetaManager manager) {
        this.manager = manager;
    }

}


