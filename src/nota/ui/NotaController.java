package nota.ui;

import common.ui.Scenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import common.ui.Alertas;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import nota.model.INota;
import nota.model.Nota;
import nota.repository.INotaManager;

import java.util.ArrayList;
import java.util.HashMap;

public class NotaController {

    private INotaManager manager;
    private HashMap<String, Label> labels = new HashMap<>();

    @FXML
    private Button buttonExit;

    @FXML
    private VBox panelNotas;

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
        String nombre = Alertas.showInputDialog("Introduce la nota:", "Introducir nota", "");
        Nota nota = new Nota(nombre);
        if(manager.create(nota)) {
            drawNota(nota);
        }
    }

    @FXML
    void exit(ActionEvent event) {
        askToSave();
        System.exit(0);
    }

    private void askToSave() {
        if(Alertas.showYesNoDialog("¿Desea guardar las notas?", "Guardar notas")) {
            saveNotas(new ActionEvent());
        }
    }

    @FXML
    void loadNotas(ActionEvent event) {
        ArrayList<INota> notas = manager.readAll();
        for (INota nota : notas) {
            if(!labels.containsKey(nota.getNombre()))
                drawNota(nota);
            }
    }

    private void drawNota(INota nota) {
        Label label = new Label();
        String nombre = nota.getNombre();
        label.setText(nombre);
        label.setStyle("-fx-font: 22 System;");
        labels.put(nombre, label);
        panelNotas.getChildren().add(label);
    }

    private void eraseNota(String name) {
        panelNotas.getChildren().remove(labels.get(name));
    }

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

    @FXML
    void returnToMenu(ActionEvent event) {

        askToSave();

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(Scenes.getData().getSceneAgenda());
    }

    @FXML
    void saveNotas(ActionEvent event) {
        manager.saveAll();
    }

    public void setManager(INotaManager manager) {
        this.manager = manager;
    }

}


