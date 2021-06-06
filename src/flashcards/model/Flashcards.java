package flashcards.model;

import java.util.ArrayList;

public class Flashcards implements IFlashcard{

    String nombre;// el nombre sera la pregunta de la flashcard
    ArrayList<String> etiquetas = new ArrayList<>();
    private String tema;
    private String contenido;//respuesta
    Asignatura asignatura;

    /**
     * Constructor
     * @param nombre Titulo de la flashcard
     * @param contenido Contnido de la flashcard
     * @param asignatura (opcional) Nombre de la asignatura
     */
    public Flashcards(String nombre, String contenido, Asignatura ... asignatura) {
        this.nombre = nombre;
        this.contenido=contenido;
    }

    //Getters y Setters

    public String getTema() {
        return tema;
    }

    public void setTema(String titulo) {
        this.tema = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public String getNombre() {
        return nombre;
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
