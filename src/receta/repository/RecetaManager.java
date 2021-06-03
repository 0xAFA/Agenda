package receta.repository;

import nota.model.INota;
import receta.model.IReceta;

import java.util.ArrayList;

public class RecetaManager implements IRecetaManager {

    private final IRecetaRepository repo;

    public RecetaManager(IRecetaRepository repo) {
       this.repo = repo;
    }

    public boolean create(IReceta receta) {
        boolean bRes=false;
        if(!repo.exists(receta.getNombre())){
            repo.create(receta);
            bRes=true;
        }
        return bRes;
    }

    public void remove(IReceta receta) {
        remove(receta.getNombre());
    }

    public void remove(String titulo) {
        if (repo.exists(titulo)) {
            repo.remove(titulo);
        }
    }

    public ArrayList<IReceta> readAll(){
        return repo.readAll();
    }

    public void saveAll() {repo.saveAll();}


}