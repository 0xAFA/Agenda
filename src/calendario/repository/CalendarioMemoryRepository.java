package calendario.repository;

import nota.model.INota;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import calendario.model.Calendario;
import calendario.model.ICalendario;
/**
 * Implementación del repositorio de calendario en memoria.
 */
public class CalendarioMemoryRepository implements ICalendarioRepository {

    private HashMap<String, Calendario> repo;
    /**
     * Constructor que inicializa el HashMap.
     */
    public CalendarioMemoryRepository() {
        this.repo = new HashMap<>();
    }
    /**
     * Comprueba si un evento existe.
     * @param nombre Nombre del evento.
     * @return true si el vento existe, false si no.
     */
    @Override
    public boolean exists(String nombre) {
        return repo.containsKey(nombre);
    }
    /**
     * Añade un evento al repositorio.
     * @param evento Evento a añadir.
     * @return true si se ha añadido con éxito.
     */
    @Override
    public boolean create(Calendario evento) {
        repo.put(evento.getNombre(), evento);
        return true;
    }
    /**
     * Busca y devuelve el evento con un nombre dado.
     * @param nombre Nombre del evento.
     * @return Evento.
     */
    @Override
    public ICalendario read(String nombre) {
        return repo.get(nombre);
    }
    /**
     * Borra un evento.
     * @param nombre Nombre del evento.
     */
    @Override
    public void remove(String nombre) {
        repo.remove(nombre);
    }
    /**
     * Devuelve todos los eventos en un ArrayList.
     * @return ArrayList con los eventos.
     */
    @Override
    public ArrayList<Calendario> readAll() {
        Collection<Calendario> values = repo.values(); // pasar los valores de map a arraylist
        ArrayList<Calendario> rE=new ArrayList<>(values);
        return rE;
    }
    /**
     * El MemoryRepository no dispone de esta funcionalidad.
     */
    public void saveAll() {
        System.out.println("El MemoryRepository no tiene funcionalidad de guardar en archivo.");
    }

}
