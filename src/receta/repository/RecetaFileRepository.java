package receta.repository;

import common.FileMethods;
import nota.model.INota;
import receta.model.IReceta;
import receta.model.Receta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
/**
 * Implementación del repositorio de recetas basada en archivos.
 */
public class RecetaFileRepository implements IRecetaRepository {

    private HashMap<String, IReceta> repo;
    private final String path = "data/receta.dat";
    /**
     * Constructor que inicializa un repositorio vacío.
     */
    public RecetaFileRepository() {
        this.repo = new HashMap<>();
    }
    /**
     * Comprueba si una receta forma parte del repositorio.
     * @param nombre Nombre de la receta.
     * @return true si la receta existe, false en caso contrario.
     */
    @Override
    public boolean exists(String nombre) {
        return repo.containsKey(nombre);
    }
    /**
     * Añade una receta al repositorio.
     * @param receta Receta
     * @return true si la receta se ha añadido con éxito.
     */
    @Override
    public boolean create(IReceta receta) {
        repo.put(receta.getNombre(), receta);
        FileMethods.writeMapToFile(repo, path);
        return true;
    }
    /**
     * Devuelve una receta con un nombre dado.
     * @param nombre Nombre de la receta.
     * @return receta.
     */
    @Override
    public IReceta read(String nombre) {
        return repo.get(nombre);
    }
    /**
     * Borra una receta.
     * @param nombre Nombre de la receta.
     */
    @Override
    public void remove(String nombre) {
        repo.remove(nombre);
        FileMethods.writeMapToFile(repo, path);
    }
    /**
     * Carga en memoria todas las recetas contenidas en un archivo, y las devuelve en un ArrayList.
     * @return ArrayList con las recetas.
     */
    @Override
    @SuppressWarnings("unchecked")
    public ArrayList<IReceta> readAll() {
        repo = FileMethods.readMapFromFile(path);
        Collection<IReceta> values = repo.values(); // pasar los valores de map a arraylist
        ArrayList<IReceta> rE = new ArrayList<>(values);
        return rE;
    }
    /**
     * Guarda todas las recetas en el repositorio en un archivo.
     */
    public void saveAll() {
        FileMethods.writeMapToFile(repo, path);
    }



}