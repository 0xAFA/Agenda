package nota.repository;

import nota.model.INota;

import java.util.ArrayList;

/**
 * Interfaz para las implementaciones del repositorio de notas.
 */
public interface INotaRepository {

    boolean exists(String nombre);
    boolean create(INota nota);
    INota read(String nombre);
    void remove(String nombre);
    ArrayList<INota> readAll();
    void saveAll();

}
