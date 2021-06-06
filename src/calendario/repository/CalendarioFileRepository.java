package calendario.repository;

import common.FileMethods;
import nota.model.INota;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import calendario.model.Calendario;
import calendario.model.ICalendario;
/**
 * Implementación del repositorio de calendario basada en archivos.
 */
public class CalendarioFileRepository implements ICalendarioRepository {

    private HashMap<String, Calendario> repo;
    private final String path = "data/calendario.dat";

    /**
     * Constructor que inicializa un repositorio vacío.
     */
    public CalendarioFileRepository() {
        this.repo = new HashMap<>();
    }

    /**
     * Comprueba si un evento forma parte del repositorio.
     * @param nombre Nombre del evento.
     * @return true si el evento existe, false en caso contrario.
     */
    @Override
    public boolean exists(String nombre) {
        return repo.containsKey(nombre);
    }

    /**
     * Añade un evento al repositorio.
     * @param calendario Evento
     * @return true si el evento se ha añadido con éxito.
     */
	@Override
    public boolean create(Calendario calendario) {
        repo.put(calendario.getNombre(), calendario);
        FileMethods.writeMapToFile(repo, path);
        return true;
    }
    /**
     * Devuelve un evento con un nombre dado.
     * @param nombre Nombre de la nota.
     * @return Evento.
     */
    @Override
    public Calendario read(String nombre) {
        return repo.get(nombre);
    }
    /**
     * Borra un evento.
     * @param nombre Nombre del evento.
     */
    @Override
    public void remove(String nombre) {
        repo.remove(nombre);
        FileMethods.writeMapToFile(repo, path);
    }
    /**
     * Carga en memoria todos los eventos contenidos en un archivo, y los devuelve en un ArrayList.
     * @return ArrayList con los eventos.
     */
    @Override
    @SuppressWarnings("unchecked")
    public ArrayList<Calendario> readAll() {
        repo = FileMethods.readMapFromFile(path);
        Collection<Calendario> values = repo.values(); // pasar los valores de map a arraylist
        ArrayList<Calendario> rE = new ArrayList<Calendario>(values);
        return rE;
    }
    /**
     * Guarda todos los eventos del repositorio en un archivo.
     */
    public void saveAll() {
        FileMethods.writeMapToFile(repo, path);
    }



}