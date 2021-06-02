package receta.repository;

import nota.model.INota;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class NotaMemoryRepository implements INotaRepository {

    private HashMap<String, INota> repo;

    public NotaMemoryRepository() {
        this.repo = new HashMap<>();
    }

    @Override
    public boolean exists(String nombre) {
        return repo.containsKey(nombre);
    }

    @Override
    public boolean create(INota nota) {
        repo.put(nota.getNombre(), nota);
        return true;
    }

    @Override
    public INota read(String nombre) {
        return repo.get(nombre);
    }

    @Override
    public void remove(String nombre) {
        repo.remove(nombre);
    }

    @Override
    public ArrayList<INota> readAll() {
        Collection<INota> values = repo.values(); // pasar los valores de map a arraylist
        ArrayList<INota> rE=new ArrayList<>(values);
        return rE;
    }

    public void saveAll() {
        System.out.println("El MemoryRepository no tiene funcionalidad de guardar en archivo.");
    }
}
