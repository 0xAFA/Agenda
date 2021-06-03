package calendario.repository;


import java.util.ArrayList;
import calendario.model.ICalendario;


public class CalendarioManager implements ICalendarioManager {

    private final ICalendarioRepository repo;

    public CalendarioManager(ICalendarioRepository repo) {
       this.repo = repo;
    }

    public boolean create(ICalendario receta) {
        boolean bRes=false;
        if(!repo.exists(receta.getNombre())){
            repo.create(receta);
            bRes=true;
        }
        return bRes;
    }

    public void remove(ICalendario receta) {
        remove(receta.getNombre());
    }

    public void remove(String titulo) {
        if (repo.exists(titulo)) {
            repo.remove(titulo);
        }
    }

    public ArrayList<ICalendario> readAll(){
        return repo.readAll();
    }

    public void saveAll() {repo.saveAll();}


}