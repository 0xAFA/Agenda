package receta.ui;

import common.ui.Alertas;
import common.ui.Scenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import receta.model.IReceta;
import receta.model.Receta;
import receta.model.RecetaDieta;
import receta.repository.IRecetaManager;

import java.util.ArrayList;
import java.util.HashMap;

public class RecetaController {

    private IRecetaManager manager;
    private HashMap<String, Label> labels = new HashMap<>();

    @FXML
    private Button buttonExit;

    @FXML
    private VBox panelRecetas;

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

    private void askToSave() {
        if(Alertas.showYesNoDialog("¿Desea guardar las recetas?", "Guardar recetas")) {
            saveRecetas(new ActionEvent());
        }
    }

    @FXML
    void loadRecetas(ActionEvent event) {
        ArrayList<IReceta> recetas = manager.readAll();
        for (IReceta receta : recetas) {
            if(!labels.containsKey(receta.getNombre()))
                drawReceta(receta);
        }
    }

    private void drawReceta(IReceta receta) {
        Label label = new Label();
        String nombre = receta.getNombre();
        label.setText(nombre);
        label.setStyle("-fx-font: 22 System;");
        labels.put(nombre, label);
        panelRecetas.getChildren().add(label);
    }

    private void eraseReceta(String name) {
        panelRecetas.getChildren().remove(labels.get(name));
    }

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

    public void setManager(IRecetaManager manager) {
        this.manager = manager;
    }

}


