package receta.repository;

import receta.model.IReceta;

import java.util.ArrayList;
/**
 * Interfaz para los managers de recetas.
 */
public interface IRecetaManager {

    boolean create(IReceta nota);

    void remove(IReceta nota);

    void remove(String titulo);

    ArrayList<IReceta> readAll();

    void saveAll();

}
