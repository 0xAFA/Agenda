package calendario.repository;

import java.util.ArrayList;

import calendario.model.Calendario;
import calendario.model.ICalendario;

public interface ICalendarioManager {

    boolean create(Calendario cal);

    void remove(Calendario cale);

    void remove(String titulo);

    ArrayList<Calendario> readAll();

    void saveAll();

}
