package receta;

import java.util.ArrayList;
import java.util.List;

public abstract class Receta implements IReceta{
    private String clasificacion;
    private String dificultad;
    private Autor autor;
    private Duracion duracion;
    public List<String> listaIngredientes;


    public abstract long calorias();

    @Override
    public String getNombre() {
        return null;
    }

    @Override
    public void setNombre(String nombre) {

    }

    @Override
    public ArrayList<String> getEtiquetas() {
        return null;
    }

    @Override
    public boolean hasEtiqueta(String etiqueta) {
        return false;
    }

    @Override
    public void addEtiqueta(String etiqueta) {

    }

    @Override
    public void removeEtiqueta(String etiqueta) {

    }
}
