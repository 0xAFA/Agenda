package receta.repository;

import nota.model.INota;
import receta.model.IReceta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class RecetaMemoryRepository implements IRecetaRepository {

    private HashMap<String, IReceta> repo;

    public RecetaMemoryRepository() {
        this.repo = new HashMap<>();
    }

    @Override
    public boolean exists(String nombre) {
        return repo.containsKey(nombre);
    }

    @Override
    public boolean create(IReceta receta) {
        repo.put(receta.getNombre(), receta);
        return true;
    }

    @Override
    public IReceta read(String nombre) {
        return repo.get(nombre);
    }

    @Override
    public void remove(String nombre) {
        repo.remove(nombre);
    }

    @Override
    public ArrayList<IReceta> readAll() {
        Collection<IReceta> values = repo.values(); // pasar los valores de map a arraylist
        ArrayList<IReceta> rE=new ArrayList<>(values);
        return rE;
    }

    public void saveAll() {
        System.out.println("El MemoryRepository no tiene funcionalidad de guardar en archivo.");
    }

}
