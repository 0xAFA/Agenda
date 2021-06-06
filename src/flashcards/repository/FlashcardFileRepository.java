package flashcards.repository;

import common.FileMethods;
import flashcards.model.IFlashcard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
/**
 * Implementación del repositorio de flashcards basada en archivos.
 */
public class FlashcardFileRepository implements IFlashcardRepository {
    private HashMap<String, IFlashcard> repo;
    private final String path = "data/flashcard.dat";
    /**
     * Constructor que inicializa un repositorio vacío.
     */
    public FlashcardFileRepository() {
        this.repo = new HashMap<>();
    }
    /**
     * Comprueba si una flashcard forma parte del repositorio.
     * @param nombre Nombre de la flashcard.
     * @return true si la flashcard existe, false en caso contrario.
     */
    @Override
    public boolean exists(String nombre) {
        return repo.containsKey(nombre);
    }
    /**
     * Añade una flashcard al repositorio.
     * @param flashcard Flashcard
     * @return true si la flashcard se ha añadido con éxito.
     */
    @Override
    public boolean create(IFlashcard flashcard) {
        repo.put(flashcard.getNombre(), flashcard);
        FileMethods.writeMapToFile(repo, path);
        return true;
    }
    /**
     * Devuelve una flashcard con un nombre dado.
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
        FileMethods.writeMapToFile(repo, path);
    }
    /**
     * Carga en memoria todas las flashcards contenidas en un archivo, y las devuelve en un ArrayList.
     * @return ArrayList con las flashcard.
     */
    @Override
    @SuppressWarnings("unchecked")
    public ArrayList<IFlashcard> readAll() {
        repo = FileMethods.readMapFromFile(path);
        Collection<IFlashcard> values = repo.values(); // pasar los valores de map a arraylist
        ArrayList<IFlashcard> rE = new ArrayList<>(values);
        return rE;
    }
    /**
     * Guarda todas las flashcards en el repositorio en un archivo.
     */
    public void saveAll() {
        FileMethods.writeMapToFile(repo, path);
    }




}
