package flashcards.repository;

import flashcards.model.IFlashcard;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
/**
 * Implementación del repositorio de flashcadrs en memoria.
 */
public class FlashcardMemoryRepository implements IFlashcardRepository{

    private HashMap<String, IFlashcard> repo;
    /**
     * Constructor que inicializa el HashMap.
     */
    public FlashcardMemoryRepository() {
        this.repo = new HashMap<>();
    }
    /**
     * Comprueba si una flashcard existe.
     * @param nombre Nombre de la flashcard.
     * @return true si la flashcard existe, false si no.
     */
    @Override
    public boolean exists(String nombre) {
        return repo.containsKey(nombre);
    }
    /**
     * Añade una flashcard al repositorio.
     * @param flashcard Flashcard a añadir.
     * @return true si se ha añadido con éxito.
     */
    @Override
    public boolean create(IFlashcard flashcard) {
        repo.put(flashcard.getNombre(), flashcard);
        return true;
    }

    /**
     * Busca y devuelve la flashcard con un nombre dado.
     * @param nombre Nombre de la flashcard.
     * @return Flashcard.
     */
    @Override
    public IFlashcard read(String nombre) {
        return repo.get(nombre);
    }
    /**
     * Borra una flashcard.
     * @param nombre Nombre de la flashcard.
     */
    @Override
    public void remove(String nombre) {
        repo.remove(nombre);
    }
    /**
     * Devuelve todas las flashcards en un ArrayList.
     * @return ArrayList con las flashcards.
     */
    @Override
    public ArrayList<IFlashcard> readAll() {
        Collection<IFlashcard> values = repo.values(); // pasar los valores de map a arraylist
        ArrayList<IFlashcard> rE=new ArrayList<>(values);
        return rE;
    }
    /**
     * El MemoryRepository no dispone de esta funcionalidad.
     */
    public void saveAll() {
        System.out.println("El MemoryRepository no tiene funcionalidad de guardar en archivo.");
    }

}

