package calendario.repository;

import java.util.ArrayList;

import calendario.model.ICalendario;

public interface ICalendarioManager {

    boolean create(ICalendario nota);

    void remove(ICalendario nota);

    void remove(String titulo);

    ArrayList<ICalendario> readAll();

    void saveAll();

}
