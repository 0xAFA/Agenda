package calendario.repository;


import java.util.ArrayList;

import calendario.model.Calendario;
import calendario.model.ICalendario;


public class CalendarioManager implements ICalendarioManager {

    private final ICalendarioRepository repo;

    /**
     * Constructor
     * @param repo
     */
    public CalendarioManager(ICalendarioRepository repo) {
       this.repo = repo;
    }
    /**
     * Añade un evento al Manager.
     * @param evento Evento.
     * @return true si el evento se ha añadido correctamente.
     */
    public boolean create(Calendario evento) {
        boolean bRes=false;
        if(!repo.exists(evento.getNombre())){
            repo.create(evento);
            bRes=true;
        }
        return bRes;
    }
    /**
     * Borra un evento del Manager.
     * @param evento Evento.
     */
    public void remove(ICalendario evento) {
        remove(evento.getNombre());
    }
    /**
     * Borra un evento del Manager dado su título.
     * @param titulo Título del evento
     */
    public void remove(String titulo) {
        if (repo.exists(titulo)) {
            repo.remove(titulo);
        }
    }
    /**
     * Carga en memoria todos los eventos, y los devuelve en un ArrayList.
     * @return ArrayList con los eventos.
     */
    public ArrayList<Calendario> readAll(){
        return repo.readAll();
    }
    /**
     * Guarda todas los eventos en el repositorio en un archivo. Sólo funcionará con un NotaFileMana
     */
    public void saveAll() {repo.saveAll();}
	@Override
	public void remove(Calendario cale) {
		// TODO Auto-generated method stub
		
	}


}