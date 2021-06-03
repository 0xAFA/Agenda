package receta.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Receta implements IReceta{
    private String clasificacion;
    private String dificultad;
    private Autor autor;
    private Duracion duracion;
    private List<String> listaIngredientes;
    String nombre; //Viene de INota
    ArrayList<String> etiquetas = new ArrayList<>(); //Viene de INota
    protected long calorias;



    public Receta(long calorias) {

        this.calorias = calorias;
    }

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

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Duracion getDuracion() {
        return duracion;
    }

    public void setDuracion(Duracion duracion) {
        this.duracion = duracion;
    }

    public List<String> getListaIngredientes() {
        return listaIngredientes;
    }

    public void setListaIngredientes(List<String> listaIngredientes) {
        this.listaIngredientes = listaIngredientes;
    }

    public void setEtiquetas(ArrayList<String> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public long getCalorias() {
        return calorias;
    }

    public void setCalorias(long calorias) {
        this.calorias = calorias;
    }

    public String getPropiedades(){
        return "Dificultad: " + this.dificultad;
    }
}
