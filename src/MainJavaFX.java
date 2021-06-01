import common.ui.Scenes;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.ui.AgendaController;
import nota.model.Nota;
import nota.repository.INotaManager;
import nota.repository.INotaRepository;
import nota.repository.NotaFileRepository;
import nota.repository.NotaManager;
import nota.ui.NotasController;

import java.util.ArrayList;

public class MainJavaFX extends Application {

    static NotaFileRepository notaRepo;
    static INotaManager notaManager;

    static Scene sceneAgenda;
    static Scene sceneNota;

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
            NotasController controller = new NotasController();
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

    private void initRepos() {

        // Inicializar todos los repositorios
        notaRepo = new NotaFileRepository();
        notaManager = new NotaManager(notaRepo);

        // ...
    }

    @Override
    public void start(Stage stage) {
        initRepos();
        initAgenda(stage);
        initNotas(stage);
        stage.setTitle("Agenda");
        stage.setScene(Scenes.getData().getSceneAgenda());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}