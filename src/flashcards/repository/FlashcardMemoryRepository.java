package flashcards.repository;

import flashcards.model.IFlashcard;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class FlashcardMemoryRepository implements IFlashcardRepository{

    private HashMap<String, IFlashcard> repo;
    public FlashcardMemoryRepository() {
        this.repo = new HashMap<>();
    }

    @Override
    public boolean exists(String nombre) {
        return repo.containsKey(nombre);
    }

    @Override
    public boolean create(IFlashcard flashcard) {
        repo.put(flashcard.getNombre(), flashcard);
        return true;
    }

    @Override
    public IFlashcard read(String nombre) {
        return repo.get(nombre);
    }

    @Override
    public void remove(String nombre) {
        repo.remove(nombre);
    }

    @Override
    public ArrayList<IFlashcard> readAll() {
        Collection<IFlashcard> values = repo.values(); // pasar los valores de map a arraylist
        ArrayList<IFlashcard> rE=new ArrayList<>(values);
        return rE;
    }

    public void saveAll() {
        System.out.println("El MemoryRepository no tiene funcionalidad de guardar en archivo.");
    }

}

