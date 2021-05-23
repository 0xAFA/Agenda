package common;

import nota.model.Nota;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class FileMethods {

    public static void writeMapToFile(HashMap repo, String path) {
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(repo);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

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
