package receta.repository;

import receta.model.IReceta;

import java.util.ArrayList;

public interface IRecetaManager {

    boolean create(IReceta nota);

    void remove(IReceta nota);

    void remove(String titulo);

    ArrayList<IReceta> readAll();

    void saveAll();

    String getPropiedades(IReceta receta);

}
