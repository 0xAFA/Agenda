package receta.repository;

import nota.model.INota;
import receta.model.IReceta;

import java.util.ArrayList;

public class RecetaManager implements IRecetaManager {

    private final IRecetaRepository repo;
    /**
     * Constructor.
     * @param repo
     */
    public RecetaManager(IRecetaRepository repo) {
       this.repo = repo;
    }
    /**
     * Añade una receta al Manager.
     * @param receta Receta.
     * @return true si la receta se ha añadido correctamente.
     */
    public boolean create(IReceta receta) {
        boolean bRes=false;
        if(!repo.exists(receta.getNombre())){
            repo.create(receta);
            bRes=true;
        }
        return bRes;
    }
    /**
     * Borra una receta del Manager.
     * @param receta Receta.
     */
    public void remove(IReceta receta) {
        remove(receta.getNombre());
    }
    /**
     * Borra una receta del Manager dado su título.
     * @param titulo Título de la receta.
     */
    public void remove(String titulo) {
        if (repo.exists(titulo)) {
            repo.remove(titulo);
        }
    }
    /**
     * Carga en memoria todas las recetas, y las devuelve en un ArrayList.
     * @return ArrayList con las recetas.
     */
    public ArrayList<IReceta> readAll(){
        return repo.readAll();
    }
    /**
     * Guarda todas las rectas en el repositorio en un archivo
     */
    public void saveAll() {repo.saveAll();}


}