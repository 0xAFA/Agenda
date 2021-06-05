package nota.repository;

import nota.model.INota;

import java.util.ArrayList;

public class NotaManager implements INotaManager {

    private final INotaRepository repo;

    /**
     * Constructor.
     * @param repo
     */
    public NotaManager(INotaRepository repo) {
       this.repo = repo;
    }

    /**
     * Añade una nota al Manager.
     * @param nota Nota.
     * @return true si la nota se ha añadido correctamente.
     */
    public boolean create(INota nota) {
        boolean bRes=false;
        if(!repo.exists(nota.getNombre())){
            repo.create(nota);
            bRes=true;
        }
        return bRes;
    }

    /**
     * Borra una nota del Manager.
     * @param nota Nota.
     */
    public void remove(INota nota) {
        remove(nota.getNombre());
    }

    /**
     * Borra una nota del Manager dado su título.
     * @param titulo Título de la nota.
     */
    public void remove(String titulo) {
        if (repo.exists(titulo)) {
            repo.remove(titulo);
        }
    }

    /**
     * Carga en memoria todas las notas, y las devuelve en un ArrayList.
     * @return ArrayList con las notas.
     */
    public ArrayList<INota> readAll(){
        return repo.readAll();
    }

    /**
     * Guarda todas las notas en el repositorio en un archivo. Sólo funcionará con un NotaFileMana
     */
    public void saveAll() {
        repo.saveAll();
    }
}