package nota.repository;

import nota.model.INota;

import java.util.ArrayList;

/**
 * Interfaz para los managers de notas.
 */
public interface INotaManager {

    boolean create(INota nota);

    void remove(INota nota);

    void remove(String titulo);

    ArrayList<INota> readAll();

    void saveAll();
}
