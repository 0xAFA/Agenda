package receta.repository;

import common.FileMethods;
import nota.model.INota;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class NotaFileRepository implements INotaRepository {

    private HashMap<String, INota> repo;
    private final String path = "data/nota.dat";

    public NotaFileRepository() {
        this.repo = new HashMap<>();
    }

    @Override
    public boolean exists(String nombre) {
        return repo.containsKey(nombre);
    }

    @Override
    public boolean create(INota nota) {
        repo.put(nota.getNombre(), nota);
        FileMethods.writeMapToFile(repo, path);
        return true;
    }

    @Override
    public INota read(String nombre) {
        return repo.get(nombre);
    }

    @Override
    public void remove(String nombre) {
        repo.remove(nombre);
        FileMethods.writeMapToFile(repo, path);
    }

    @Override
    @SuppressWarnings("unchecked")
    public ArrayList<INota> readAll() {
        repo = FileMethods.readMapFromFile(path);
        Collection<INota> values = repo.values(); // pasar los valores de map a arraylist
        ArrayList<INota> rE = new ArrayList<>(values);
        return rE;
    }

    public void saveAll() {
        FileMethods.writeMapToFile(repo, path);
    }

}