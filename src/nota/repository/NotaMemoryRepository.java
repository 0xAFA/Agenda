package nota.repository;

import nota.model.INota;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * Implementación del repositorio de notas en memoria.
 */
public class NotaMemoryRepository implements INotaRepository {

    private HashMap<String, INota> repo;

    /**
     * Constructor que inicializa el HashMap.
     */
    public NotaMemoryRepository() {
        this.repo = new HashMap<>();
    }

    /**
     * Comprueba si una nota existe.
     * @param nombre Nombre de la nota.
     * @return true si la nota existe, false si no.
     */
    @Override
    public boolean exists(String nombre) {
        return repo.containsKey(nombre);
    }

    /**
     * Añade una nota al repositorio.
     * @param nota Nota a añadir.
     * @return true si se ha añadido con éxito.
     */
    @Override
    public boolean create(INota nota) {
        repo.put(nota.getNombre(), nota);
        return true;
    }

    /**
     * Busca y devuelve la nota con un nombre dado.
     * @param nombre Nombre de la nota.
     * @return Nota.
     */
    @Override
    public INota read(String nombre) {
        return repo.get(nombre);
    }

    /**
     * Borra una nota.
     * @param nombre Nombre de la nota.
     */
    @Override
    public void remove(String nombre) {
        repo.remove(nombre);
    }

    /**
     * Devuelve todas las notas en un ArrayList.
     * @return ArrayList con las notas.
     */
    @Override
    public ArrayList<INota> readAll() {
        Collection<INota> values = repo.values(); // pasar los valores de map a arraylist
        ArrayList<INota> rE=new ArrayList<>(values);
        return rE;
    }

    /**
     * El MemoryRepository no dispone de esta funcionalidad.
     */
    @Override
    public void saveAll() {
        System.out.println("El MemoryRepository no tiene funcionalidad de guardado en archivo.");
    }
}
