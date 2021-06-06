package receta.repository;

import nota.model.INota;
import receta.model.IReceta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class RecetaMemoryRepository implements IRecetaRepository {

    private HashMap<String, IReceta> repo;
    /**
     * Constructor que inicializa el HashMap.
     */
    public RecetaMemoryRepository() {
        this.repo = new HashMap<>();
    }

    /**
     * Comprueba si una receta existe.
     * @param nombre Nombre de la receta.
     * @return true si la receta existe, false si no.
     */
    @Override
    public boolean exists(String nombre) {
        return repo.containsKey(nombre);
    }
    /**
     * Añade una receta al repositorio.
     * @param receta Receta a añadir.
     * @return true si se ha añadido con éxito.
     */
    @Override
    public boolean create(IReceta receta) {
        repo.put(receta.getNombre(), receta);
        return true;
    }

    /**
     * Busca y devuelve la receta con un nombre dado.
     * @param nombre Nombre de la receta.
     * @return Receta.
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
    }

    /**
     * Devuelve todas las recetas en un ArrayList.
     * @return ArrayList con las recetas.
     */
    @Override
    public ArrayList<IReceta> readAll() {
        Collection<IReceta> values = repo.values(); // pasar los valores de map a arraylist
        ArrayList<IReceta> rE=new ArrayList<>(values);
        return rE;
    }
    /**
     * El MemoryRepository no dispone de esta funcionalidad.
     */
    public void saveAll() {
        System.out.println("El MemoryRepository no tiene funcionalidad de guardar en archivo.");
    }

}
