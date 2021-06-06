package flashcards.ui;

import common.ui.Alertas;
import common.ui.Scenes;
import flashcards.model.Flashcards;
import flashcards.model.IFlashcard;
import flashcards.repository.IFlashcardManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;

public class FlashcardController {

    private IFlashcardManager manager;
    private HashMap<String, Label> labels = new HashMap<>();

    @FXML
    private Button buttonExit;

    @FXML
    private ListView<String> panelFlashcard;

    @FXML
    private Button buttonAddFlashcard;

    @FXML
    private Button buttonRemoveFlashcard;

    @FXML
    private Button buttonReturnToMenu;

    @FXML
    private Button buttonLoadFlashcard;

    @FXML
    private Button buttonSaveFlashcard;

    @FXML
    void addFlashcard(ActionEvent event) {

        String nombre = Alertas.showInputDialog("Introduce el titulo de la flashcard: ", "Flashcard", "");
        String contenido= Alertas.showInputDialog("Introduce el contenido de la flashcard:", "Contenido", "");
        Flashcards flashcard = new Flashcards(nombre,contenido);
        flashcard.setNombre(nombre);
        flashcard.setContenido(contenido);
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
            saveFlashcard(new ActionEvent());
        }
    }

    @FXML
    void loadFlashcard(/*ActionEvent event*/) {
        panelFlashcard.getItems().clear();
        ArrayList<IFlashcard> flashcards = manager.readAll();
        for (IFlashcard flashcard  : flashcards) {
            if(!labels.containsKey(flashcard.getNombre()))
                drawFlashcard(flashcard);
        }
    }

    private void drawFlashcard(IFlashcard flashcard) {
        panelFlashcard.getItems().add(flashcard.getNombre());
    }

    public void makePanelClickable() {
        panelFlashcard.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                String nombreFlashcard = panelFlashcard.getSelectionModel().getSelectedItem();
                String contenidoFlashcard = manager.read(nombreFlashcard).getContenido();
                Alertas.showInfo(contenidoFlashcard, nombreFlashcard + ":");
            }
        });
    }

    private void eraseFlashcard(String name) {
        panelFlashcard.getItems().remove(labels.get(name));
        loadFlashcard();
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
        eraseFlashcard(nombre);
    }

    @FXML
    void returnToMenu(ActionEvent event) {

        askToSave();

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(Scenes.getData().getSceneAgenda());
    }

    @FXML
    void saveFlashcard(ActionEvent event) {
        manager.saveAll();
    }

    public void setManager(IFlashcardManager manager) {
        this.manager = manager;
    }
}
