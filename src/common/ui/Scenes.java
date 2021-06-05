package common.ui;

import calendario.repository.ICalendarioManager;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nota.repository.INotaManager;
import receta.repository.IRecetaManager;


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
    private Scene sceneReceta;
    private Scene sceneCalendario;
    // ...

    // Managers
    private INotaManager notaManager;
    private IRecetaManager recetaManager;
    private ICalendarioManager calendarioManager;
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

    
    public Scene getSceneCalendario() { return sceneCalendario; }

    public void setSceneCalendario(Scene sceneCalendario) {
        this.sceneCalendario = sceneCalendario;
    }

    public ICalendarioManager getCalendarioManager() {
        return calendarioManager;
    }

    public void setCalendarioManager(ICalendarioManager calendarioManager) {
        this.calendarioManager = calendarioManager;
    }
    
    
    
    public Scene getSceneReceta() { return sceneReceta; }

    public void setSceneReceta(Scene sceneReceta) {
        this.sceneReceta = sceneReceta;
    }

    public IRecetaManager getRecetaManager() {
        return recetaManager;
    }

    public void setRecetaManager(IRecetaManager recetaManager) {
        this.recetaManager = recetaManager;
    }
}
