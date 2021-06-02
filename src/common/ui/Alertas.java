package common.ui;

import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Clase que contiene varios diálogos y alertas.
 * Código adaptado de https://code.makery.ch/blog/javafx-dialogs-official/ por Marco Jakob.
 */
public class Alertas {

    public static void showWarning (String mensaje) {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Advertencia");
        alert.setHeaderText("Advertencia");
        alert.setContentText(mensaje);

        alert.showAndWait();

    }

    public static void showError (String mensaje) {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error");
        alert.setContentText(mensaje);

        alert.showAndWait();

    }

    public static String showInputDialog (String mensaje, String titulo, String textoPorDefecto) {
        TextInputDialog dialog = new TextInputDialog(textoPorDefecto);
        String sRet = "";
        dialog.setTitle(titulo);
        dialog.setHeaderText(titulo);
        dialog.setContentText(mensaje);
        ((Button) dialog.getDialogPane().lookupButton(ButtonType.CANCEL)).setText("Cancelar");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            sRet = result.get();
        }
        return sRet;
    }

    public static String showChoiceDialog (ArrayList<String> opciones, String mensaje, String titulo) {
        String sRet = "";

        ChoiceDialog<String> dialog = new ChoiceDialog<>(opciones.get(0), opciones);
        dialog.setTitle(titulo);
        dialog.setHeaderText(titulo);
        dialog.setContentText(mensaje);
        ((Button) dialog.getDialogPane().lookupButton(ButtonType.CANCEL)).setText("Cancelar");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            sRet = result.get();
        }
        return sRet;
    }

    public static boolean showYesNoDialog (String mensaje, String titulo){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        boolean bRet = false;
        alert.setTitle(titulo);
        alert.setHeaderText(titulo);
        alert.setContentText(mensaje);
        ((Button) alert.getDialogPane().lookupButton(ButtonType.OK)).setText("Sí");
        ((Button) alert.getDialogPane().lookupButton(ButtonType.CANCEL)).setText("No");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            bRet = true;
        }
        return bRet;
    }


}
