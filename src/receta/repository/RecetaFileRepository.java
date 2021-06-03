package receta.repository;

import common.FileMethods;
import nota.model.INota;
import receta.model.IReceta;
import receta.model.Receta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class RecetaFileRepository implements IRecetaRepository {

    private HashMap<String, IReceta> repo;
    private final String path = "data/receta.dat";

    public RecetaFileRepository() {
        this.repo = new HashMap<>();
    }

    @Override
    public boolean exists(String nombre) {
        return repo.containsKey(nombre);
    }

    @Override
    public boolean create(IReceta receta) {
        repo.put(receta.getNombre(), receta);
        FileMethods.writeMapToFile(repo, path);
        return true;
    }

    @Override
    public IReceta read(String nombre) {
        return repo.get(nombre);
    }

    @Override
    public void remove(String nombre) {
        repo.remove(nombre);
        FileMethods.writeMapToFile(repo, path);
    }

    @Override
    @SuppressWarnings("unchecked")
    public ArrayList<IReceta> readAll() {
        repo = FileMethods.readMapFromFile(path);
        Collection<IReceta> values = repo.values(); // pasar los valores de map a arraylist
        ArrayList<IReceta> rE = new ArrayList<>(values);
        return rE;
    }

    public void saveAll() {
        FileMethods.writeMapToFile(repo, path);
    }



}