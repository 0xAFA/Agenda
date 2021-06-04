package flashcards.model;

import nota.model.INota;

import java.util.ArrayList;

public interface IFlashcard extends INota {

    String getNombre();

    void setNombre(String nombre);

    ArrayList<String> getEtiquetas();

    boolean hasEtiqueta(String etiqueta);

    void addEtiqueta(String etiqueta);

    void removeEtiqueta(String etiqueta);
}
