package receta;

import java.util.ArrayList;
import java.util.List;

public abstract class Receta implements IReceta{
    private String clasificacion;
    private String dificultad;
    private Autor autor;
    private Duracion duracion;
    public List<String> listaIngredientes;
    String nombre;
    ArrayList<String> etiquetas = new ArrayList<>();


    public abstract long calorias();

    @Override

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getEtiquetas() {
        return etiquetas;
    }

    public boolean hasEtiqueta(String etiqueta) {return etiquetas.contains(etiqueta);}

    public void addEtiqueta(String etiqueta) {
        this.etiquetas.add(etiqueta);
    }

    public void removeEtiqueta(String etiqueta) {
        this.etiquetas.remove(etiqueta);
    }

}
