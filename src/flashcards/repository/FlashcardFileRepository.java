package flashcards.repository;

import common.FileMethods;
import flashcards.model.IFlashcard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class FlashcardFileRepository implements IFlashcardRepository {
    private HashMap<String, IFlashcard> repo;
    private final String path = "data/receta.dat";

    public FlashcardFileRepository() {
        this.repo = new HashMap<>();
    }

    @Override
    public boolean exists(String nombre) {
        return repo.containsKey(nombre);
    }

    @Override
    public boolean create(IFlashcard flashcard) {
        repo.put(flashcard.getNombre(), flashcard);
        FileMethods.writeMapToFile(repo, path);
        return true;
    }

    @Override
    public IFlashcard read(String nombre) {
        return repo.get(nombre);
    }

    @Override
    public void remove(String nombre) {
        repo.remove(nombre);
        FileMethods.writeMapToFile(repo, path);
    }

    @Override
    @SuppressWarnings("unchecked")
    public ArrayList<IFlashcard> readAll() {
        repo = FileMethods.readMapFromFile(path);
        Collection<IFlashcard> values = repo.values(); // pasar los valores de map a arraylist
        ArrayList<IFlashcard> rE = new ArrayList<>(values);
        return rE;
    }

    public void saveAll() {
        FileMethods.writeMapToFile(repo, path);
    }




}
