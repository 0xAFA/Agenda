package flashcards.repository;

import flashcards.model.IFlashcard;

import java.util.ArrayList;

public interface IFlashcardManager {

    boolean create(IFlashcard flashcard);

    void remove(IFlashcard flashcard);

    void remove(String titulo);



    ArrayList<IFlashcard> readAll();

    void saveAll();
}
