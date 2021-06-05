package nota.model;

import java.util.ArrayList;

/**
 * Clase que representa las notas.
 */
public class Nota implements INota {

    // Código para serialización
    private static final long serialVersionUID = 1L;

    String nombre;
    ArrayList<String> etiquetas = new ArrayList<>();

    /**
     * Constructor, con etiquetas opcionales.
     * @param nombre Nombre de la nota.
     * @param etiquetas (Opcional) Etiquetas.
     */
    public Nota (String nombre, String ... etiquetas) {
        this.nombre = nombre;
        for(String etiqueta : etiquetas) {
            this.etiquetas.add(etiqueta);
        }
    }

    // Getters y setters

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
