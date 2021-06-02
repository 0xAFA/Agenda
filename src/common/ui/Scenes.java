package common.ui;

import javafx.scene.Scene;
import javafx.stage.Stage;
import nota.repository.INotaManager;

/**
 * Clase singleton que contiene referencias a todas las escenas y los Managers correspondientes.
 */
public class Scenes {

    // --- Implementación del patrón Singleton: objeto individual con getter, y constructor privado ---

    private final static Scenes data = new Scenes();

    private Scenes() {}

    public static Scenes getData()
    {
        return data;
    }

    // --- Información ---

    // Escenario
    private Stage stage;

    // Escenas
    private Scene sceneAgenda;
    private Scene sceneNota;
    // ...

    // Managers
    private INotaManager notaManager;
    // ...

    // --- Getters y setters ---

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getSceneAgenda() {
        return sceneAgenda;
    }

    public void setSceneAgenda(Scene sceneAgenda) {
        this.sceneAgenda = sceneAgenda;
    }

    public Scene getSceneNota() {
        return sceneNota;
    }

    public void setSceneNota(Scene sceneNota) {
        this.sceneNota = sceneNota;
    }

    public INotaManager getNotaManager() {
        return notaManager;
    }

    public void setNotaManager(INotaManager notaManager) {
        this.notaManager = notaManager;
    }

}
