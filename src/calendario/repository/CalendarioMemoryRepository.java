package calendario.repository;

import nota.model.INota;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import calendario.model.ICalendario;

public class CalendarioMemoryRepository implements ICalendarioRepository {

    private HashMap<String, ICalendario> repo;

    public CalendarioMemoryRepository() {
        this.repo = new HashMap<>();
    }

    @Override
    public boolean exists(String nombre) {
        return repo.containsKey(nombre);
    }

    @Override
    public boolean create(ICalendario receta) {
        repo.put(receta.getNombre(), receta);
        return true;
    }

    @Override
    public ICalendario read(String nombre) {
        return repo.get(nombre);
    }

    @Override
    public void remove(String nombre) {
        repo.remove(nombre);
    }

    @Override
    public ArrayList<ICalendario> readAll() {
        Collection<ICalendario> values = repo.values(); // pasar los valores de map a arraylist
        ArrayList<ICalendario> rE=new ArrayList<>(values);
        return rE;
    }

    public void saveAll() {
        System.out.println("El MemoryRepository no tiene funcionalidad de guardar en archivo.");
    }

}
