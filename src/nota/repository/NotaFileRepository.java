package nota.repository;

import common.FileMethods;
import nota.model.INota;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * Implementación del repositorio de notas basada en archivos.
 */
public class NotaFileRepository implements INotaRepository {

    private HashMap<String, INota> repo;
    private final String path = "data/nota.dat";

    /**
     * Constructor que inicializa un repositorio vacío.
     */
    public NotaFileRepository() {
        this.repo = new HashMap<>();
    }

    /**
     * Comprueba si una nota forma parte del repositorio.
     * @param nombre Nombre de la nota.
     * @return true si la nota existe, false en caso contrario.
     */
    @Override
    public boolean exists(String nombre) {
        return repo.containsKey(nombre);
    }

    /**
     * Añade una nota al repositorio.
     * @param nota Nota
     * @return true si la nota se ha añadido con éxito.
     */
    @Override
    public boolean create(INota nota) {
        repo.put(nota.getNombre(), nota);
        FileMethods.writeMapToFile(repo, path);
        return true;
    }

    /**
     * Devuelve una nota con un nombre dado.
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
        FileMethods.writeMapToFile(repo, path);
    }

    /**
     * Carga en memoria todas las notas contenidas en un archivo, y las devuelve en un ArrayList.
     * @return ArrayList con las notas.
     */
    @Override
    @SuppressWarnings("unchecked")
    public ArrayList<INota> readAll() {
        repo = FileMethods.readMapFromFile(path);
        Collection<INota> values = repo.values(); // pasar los valores de map a arraylist
        ArrayList<INota> rE = new ArrayList<>(values);
        return rE;
    }

    /**
     * Guarda todas las notas en el repositorio en un archivo.
     */
    public void saveAll() {
        FileMethods.writeMapToFile(repo, path);
    }

}