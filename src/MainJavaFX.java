import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainJavaFX extends Application {
    @Override
    public void start(Stage stage) {        Group root = new Group();
        Scene scene = new Scene(root, 640, 640, Color.BLUE);
        stage.setTitle("Prueba JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}