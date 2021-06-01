import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainJavaFX extends Application {
    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/Agenda.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            stage.setTitle("LeagueManager");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println("Error en la carga del archivo FXML.");
            System.out.println(e);
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        launch();
    }

}