package common.ui;

import javafx.scene.control.Alert;

public class Alertas {

    /**
     *
     * Obtenido de https://code.makery.ch/blog/javafx-dialogs-official/
     * @param mensaje
     */
    public static void showWarning (String mensaje) {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Advertencia");
        alert.setHeaderText("Advertencia");
        alert.setContentText(mensaje);

        alert.showAndWait();

    }

}
