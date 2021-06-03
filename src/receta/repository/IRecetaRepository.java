package receta.repository;

import nota.model.INota;
import receta.model.IReceta;

import java.util.ArrayList;

public interface IRecetaRepository {

    boolean exists(String nombre);
    boolean create(IReceta receta);
    INota read(String nombre);
    void remove(String nombre);
    ArrayList<IReceta> readAll();
    void saveAll();


}
