package flashcards.repository;

import flashcards.model.IFlashcard;
import nota.model.INota;


import java.util.ArrayList;
/**
 * Interfaz para las implementaciones del repositorio de flashcards.
 */
public interface IFlashcardRepository {

    boolean exists(String nombre);
    boolean create(IFlashcard flashcard);
    IFlashcard read(String nombre);
    void remove(String nombre);
    ArrayList<IFlashcard> readAll();
    void saveAll();
}
