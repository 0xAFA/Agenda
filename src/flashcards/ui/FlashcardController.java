package flashcards.ui;

import common.ui.Alertas;
import common.ui.Scenes;
import flashcards.model.Asignatura;
import flashcards.model.Flashcards;
import flashcards.model.IFlashcard;
import flashcards.repository.IFlashcardManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;

public class FlashcardController {

    private IFlashcardManager manager;
    private HashMap<String, Label> labels = new HashMap<>();

    @FXML
    private Button buttonExit;

    @FXML
    private VBox panelFlashcards;

    @FXML
    private Button buttonAddFlashcard;

    @FXML
    private Button buttonRemoveFlashcard;

    @FXML
    private Button buttonReturnToMenu;

    @FXML
    private Button buttonLoadFlashcard;

    @FXML
    private Button buttonSaveFlashcards;
    @FXML
    void addFlashcard(ActionEvent event) {

        String nombre = Alertas.showInputDialog("Introduce la flashcard:", "Introducir flashcard", "");
        Flashcards flashcard = new Flashcards("Definicion de átomo",new Asignatura("Fisica"));
        flashcard.setNombre(nombre);
        flashcard.setContenido("El átomo es la unidad constituyente más pequeña de la " +
                               "materia que tiene las propiedades de un elemento químico.");
        if(manager.create(flashcard)) {
            drawFlashcard(flashcard);
        }
    }

    @FXML
    void exit(ActionEvent event) {
        askToSave();
        System.exit(0);
    }

    private void askToSave() {
        if(Alertas.showYesNoDialog("¿Desea guardar las flashcards?", "Guardar flashcards")) {
            saveFlashcards(new ActionEvent());
        }
    }

    @FXML
    void loadRecetas(ActionEvent event) {
        ArrayList<IFlashcard> flashcards = manager.readAll();
        for (IFlashcard flashcard  : flashcards) {
            if(!labels.containsKey(flashcard.getNombre()))
                drawFlashcard(flashcard);
        }
    }

    private void drawFlashcard(IFlashcard flashcard) {
        Label label = new Label();
        String nombre = flashcard.getNombre();
        label.setText(nombre);
        label.setStyle("-fx-font: 22 System;");
        labels.put(nombre, label);
        panelFlashcards.getChildren().add(label);
    }

    private void eraseReceta(String name) {
        panelFlashcards.getChildren().remove(labels.get(name));
    }

    @FXML
    void removeFlashcard(ActionEvent event) {
        ArrayList<String> allNotes = new ArrayList<>();

        for (IFlashcard flashcard : manager.readAll()) {
            allNotes.add(flashcard.getNombre());
        }

        String nombre = Alertas.showChoiceDialog(allNotes, "Selecciona la flashcard que quieres borrar",
                                                             "Eliminar flashcard");

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
    void saveFlashcards(ActionEvent event) {
        manager.saveAll();
    }

    public void setManager(IFlashcardManager manager) {
        this.manager = manager;
    }
}
