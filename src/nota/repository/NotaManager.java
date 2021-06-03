package nota.repository;

import nota.model.INota;

import java.util.ArrayList;

public class NotaManager implements INotaManager {

    private final INotaRepository repo;

    public NotaManager(INotaRepository repo) {
       this.repo = repo;
    }

    public boolean create(INota nota) {
        boolean bRes=false;
        if(!repo.exists(nota.getNombre())){
            repo.create(nota);
            bRes=true;
        }
        return bRes;
    }

    public void remove(INota nota) {
        remove(nota.getNombre());
    }

    public void remove(String titulo) {
        if (repo.exists(titulo)) {
            repo.remove(titulo);
        }
    }

    public ArrayList<INota> readAll(){
        return repo.readAll();
    }

    public void saveAll() {
        repo.saveAll();
    }
}