package flashcards.model;

import nota.model.INota;

import java.util.ArrayList;

//Interfaz para las implementaciones de la clase Flashcard (hereda de nota)

public interface IFlashcard extends INota {

    String getNombre();

    void setNombre(String nombre);

    ArrayList<String> getEtiquetas();

    boolean hasEtiqueta(String etiqueta);

    void addEtiqueta(String etiqueta);

    void removeEtiqueta(String etiqueta);
}
