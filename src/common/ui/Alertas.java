package common.ui;

import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Clase que contiene varios cuadros de diálogo y alertas.
 * Código adaptado de https://code.makery.ch/blog/javafx-dialogs-official/ por Marco Jakob.
 */
public class Alertas {

    /**
     * Muestra un mensaje con un símbolo de advertencia.
     * @param mensaje Mensaje.
     */
    public static void showWarning (String mensaje) {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Advertencia");
        alert.setHeaderText("Advertencia");
        alert.setContentText(mensaje);

        alert.showAndWait();

    }

    /**
     * Muestra un mensaje con un símbolo de error.
     * @param mensaje Mensaje.
     */
    public static void showError (String mensaje) {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error");
        alert.setContentText(mensaje);

        alert.showAndWait();

    }

    /**
     * Pide al usuario que introduzca un texto.
     * @param mensaje Mensaje a mostrar.
     * @param titulo Título del cuadro de diálogo.
     * @param textoPorDefecto Texto mostrado por defecto.
     * @return Texto introducido por el usuario.
     */
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

    /**
     * Muestra un diálogo que permite al usuario elegir entre varias opciones.
     * @param opciones Opciones que damos al usuario.
     * @param mensaje Mensaje mostrado.
     * @param titulo Título del cuadro de diálogo.
     * @return Opción elegida.
     */
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

    /**
     * Diálogo que permite al usuario elegir entre dos opciones.
     * @param mensaje Mensaje a mostrar.
     * @param titulo Título del cuadro de diálogo.
     * @return Opción elegida.
     */
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
