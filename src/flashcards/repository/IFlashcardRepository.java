package flashcards.repository;

import flashcards.model.IFlashcard;
import nota.model.INota;


import java.util.ArrayList;

public interface IFlashcardRepository {

    boolean exists(String nombre);
    boolean create(IFlashcard flashcard);
    IFlashcard read(String nombre);
    void remove(String nombre);
    ArrayList<IFlashcard> readAll();
    void saveAll();
}
