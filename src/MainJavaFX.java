import calendario.repository.CalendarioFileRepository;
import calendario.repository.CalendarioManager;
import calendario.repository.ICalendarioManager;
import calendario.ui.CalendarioController;
import common.ui.Scenes;
import flashcards.repository.FlashcardFileRepository;
import flashcards.repository.FlashcardManager;
import flashcards.repository.IFlashcardManager;
import flashcards.ui.FlashcardController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.ui.AgendaController;
import nota.repository.*;
import receta.repository.*;
import nota.ui.NotaController;
import receta.ui.RecetaController;

/**
 * Punto de inicio de la aplicación.
 */
public class MainJavaFX extends Application {

    static NotaFileRepository notaRepo;
    static INotaManager notaManager;

    static RecetaFileRepository recetaRepo;
    static IRecetaManager recetaManager;
    
    static CalendarioFileRepository calendarioRepo;
    static ICalendarioManager calendarioManager;

    static FlashcardFileRepository flashcardRepo;
    static IFlashcardManager flashcardManager;

    /**
     * Punto de inicio de la aplicación, que llama a los inicializadores de las distintas escenas
     * y coloca el menú principal como escena activa.
     * @param stage Escenario JavaFX.
     */
    @Override
    public void start(Stage stage) {
        initRepos();
        initAgenda(stage);
        initNotas(stage);
        initRecetas(stage);
        initCalendario(stage);
        initFlashcard(stage);
        stage.setTitle("Agenda");
        stage.setScene(Scenes.getData().getSceneAgenda());
        stage.show();
    }

    /**
     * Inicializa la aplicación Agenda.
     * @param stage Escenario JavaFX.
     */
    public void initAgenda(Stage stage) {

        Scene scene = null;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/Agenda.fxml"));
            AgendaController controller = new AgendaController();
            loader.setController(controller);
            Parent root = loader.load();
            scene = new Scene(root);

        } catch (Exception e) {
            System.out.println("Error en la carga del archivo FXML.");
            System.out.println("Mensaje de error: " + e.getMessage());
            System.exit(1);
        }

        Scenes.getData().setSceneAgenda(scene);
    }

    /**
     * Inicializa la aplicación Notas.
     * @param stage Escenario JavaFX.
     */
    public void initNotas(Stage stage) {

        Scene scene = null;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/Notas.fxml"));
            NotaController controller = new NotaController();
            controller.setManager(notaManager);
            loader.setController(controller);
            Parent root = loader.load();
            scene = new Scene(root);
            stage.setTitle("Notas");

        } catch (Exception e) {
            System.out.println("Error en la carga del archivo FXML.");
            System.out.println("Mensaje de error: " + e.getMessage());
            System.exit(1);
        }

        Scenes.getData().setSceneNota(scene);
    }

    /**
     * Inicializa la aplicación Recetas.
     * @param stage Escenario JavaFX.
     */
    public void initRecetas(Stage stage) {

        Scene scene = null;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/Receta.fxml"));
            RecetaController controller = new RecetaController();
            controller.setManager(recetaManager);
            loader.setController(controller);
            Parent root = loader.load();
            scene = new Scene(root);
            stage.setTitle("Recetas");

        } catch (Exception e) {
            System.out.println("Error en la carga del archivo FXML.");
            System.out.println("Mensaje de error: " + e.getMessage());
            System.exit(1);
        }

        Scenes.getData().setSceneReceta(scene);
    }

    /**
     * Inicializa la aplicación Calendario.
     * @param stage Escenario JavaFX.
     */
    public void initCalendario(Stage stage) {

        Scene scene = null;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/Calendario.fxml"));
            CalendarioController controller = new CalendarioController();
            controller.setManager(calendarioManager);
            loader.setController(controller);
            Parent root = loader.load();
            scene = new Scene(root);
            stage.setTitle("Recetas");

        } catch (Exception e) {
            System.out.println("Error en la carga del archivo FXML.");
            System.out.println("Mensaje de error: " + e.getMessage());
            System.exit(1);
        }

        Scenes.getData().setSceneCalendario(scene);
    }
    /**
     * Inicializa la aplicación Flashcards.
     * @param stage Escenario JavaFX.
     */
    public void initFlashcard(Stage stage) {

        Scene scene = null;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/Flashcard.fxml"));
            FlashcardController controller = new FlashcardController();
            controller.setManager(flashcardManager);
            loader.setController(controller);
            Parent root = loader.load();
            scene = new Scene(root);
            stage.setTitle("Flashcards");

        } catch (Exception e) {
            System.out.println("Error en la carga del archivo FXML.");
            System.out.println("Mensaje de error: " + e.getMessage());
            System.exit(1);
        }

        Scenes.getData().setSceneFlashcard(scene);
    }

    /**
     * Inicializa los Managers y repositorios.
     */
    private void initRepos() {

        // Inicializar todos los repositorios
        notaRepo = new NotaFileRepository();
        notaManager = new NotaManager(notaRepo);

        recetaRepo = new RecetaFileRepository();
        recetaManager = new RecetaManager(recetaRepo);
        
        calendarioRepo = new CalendarioFileRepository();
        calendarioManager = new CalendarioManager(calendarioRepo);

        flashcardRepo = new FlashcardFileRepository();
        flashcardManager = new FlashcardManager(flashcardRepo);

        // ...
    }

    public static void main(String[] args) {
        launch();
    }

}