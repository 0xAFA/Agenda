package nota.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Interfaz para las implementaciones de la clase Nota.
 */
public interface INota extends Serializable {

    String getNombre();

    void setNombre(String nombre);

    ArrayList<String> getEtiquetas();

    boolean hasEtiqueta(String etiqueta);

    void addEtiqueta(String etiqueta);

    void removeEtiqueta(String etiqueta);

}
