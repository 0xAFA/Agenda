package calendario.repository;

import nota.model.INota;

import java.util.ArrayList;

import calendario.model.ICalendario;

public interface ICalendarioRepository {

    boolean exists(String nombre);
    boolean create(ICalendario receta);
    INota read(String nombre);
    void remove(String nombre);
    ArrayList<ICalendario> readAll();
    void saveAll();


}
