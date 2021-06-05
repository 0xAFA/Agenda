package common;

import nota.model.Nota;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 * Clase con métodos que permiten leer y escribir datos desde archivo,
 * utilizando la funcionalidad de serialización de Java.
 */
public class FileMethods {

    /**
     * Escribe un HashMap en un archivo .dat.
     * @param repo HashMap
     * @param path Ruta del archivo, relativa al directorio de proyecto.
     */
    public static void writeMapToFile(HashMap repo, String path) {
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(repo);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Lee los datos en un archivo y los almacena en un HashMap.
     * @param path Ruta del archivo, relativa al directorio del proyecto.
     * @return HashMap
     */
    @SuppressWarnings("unchecked")
    public static HashMap readMapFromFile(String path) {
        HashMap<String, Nota> rHashmap = null;
        try (FileInputStream fos = new FileInputStream(path);
             ObjectInputStream oos = new ObjectInputStream(fos)){
            rHashmap = (HashMap) oos.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return rHashmap;
    }
}
