package flashcards.repository;

import flashcards.model.IFlashcard;


import java.util.ArrayList;

public class FlashcardManager implements IFlashcardManager{

    private final IFlashcardRepository repo;

    public FlashcardManager(IFlashcardRepository repo) {
        this.repo = repo;
    }

    public boolean create(IFlashcard flashcard) {
        boolean bRes=false;
        if(!repo.exists(flashcard.getNombre())){
            repo.create(flashcard);
            bRes=true;
        }
        return bRes;
    }

    public IFlashcard read(String nombre) {
        return repo.read(nombre);
    }

    public void remove(IFlashcard flashcard) {
        remove(flashcard.getNombre());
    }

    public void remove(String titulo) {
        if (repo.exists(titulo)) {
            repo.remove(titulo);
        }
    }

    public ArrayList<IFlashcard> readAll(){
        return repo.readAll();
    }

    public void saveAll() {
        repo.saveAll();
    }
}
