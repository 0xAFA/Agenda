package flashcards.repository;

import flashcards.model.IFlashcard;
import receta.model.IReceta;

import java.util.ArrayList;

public interface IFlashcardManager {

    boolean create(IFlashcard nota);

    void remove(IFlashcard nota);

    void remove(String titulo);

    ArrayList<IFlashcard> readAll();

    void saveAll();
}
