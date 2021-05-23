package nota.model;

import java.util.ArrayList;

public class Nota implements INota {

    private static final long serialVersionUID = 1L;

    String nombre;
    ArrayList<String> etiquetas = new ArrayList<>();

    public Nota (String nombre, String ... etiquetas) {
        this.nombre = nombre;
        for(String etiqueta : etiquetas) {
            this.etiquetas.add(etiqueta);
        }
    }

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
