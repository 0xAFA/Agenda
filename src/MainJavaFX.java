import common.ui.Scenes;
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

public class MainJavaFX extends Application {

    static NotaFileRepository notaRepo;
    static INotaManager notaManager;

    static RecetaFileRepository recetaRepo;
    static IRecetaManager recetaManager;

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

    private void initRepos() {

        // Inicializar todos los repositorios
        notaRepo = new NotaFileRepository();
        notaManager = new NotaManager(notaRepo);

        recetaRepo = new RecetaFileRepository();
        recetaManager = new RecetaManager(recetaRepo);

        // ...
    }

    @Override
    public void start(Stage stage) {
        initRepos();
        initAgenda(stage);
        initNotas(stage);
        initRecetas(stage);
        stage.setTitle("Agenda");
        stage.setScene(Scenes.getData().getSceneAgenda());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}