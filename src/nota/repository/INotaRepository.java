package nota.repository;

import nota.model.INota;

import java.util.ArrayList;

public interface INotaRepository {

    boolean exists(String nombre);
    boolean create(INota nota);
    INota read(String nombre);
    void remove(String nombre);
    ArrayList<INota> readAll();
    //INota search(String nombre);





}
