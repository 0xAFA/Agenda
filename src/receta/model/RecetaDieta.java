package receta.model;

public class RecetaDieta extends Receta {
    private String titulo;

    /**
     * Constructor
     * @param calorias de la receta
     */
    public RecetaDieta(long calorias) {
        super(calorias);
    }

    /**
     * Estipula las calorias de la receta tipo dieta
     * @return calorias Devuelve el valor de las calorias a modo de dieta
     */
    public long calorias(){
        calorias= calorias -10;
        return calorias;
    }

    //Getters y Setters

    @Override
    public String getReceta() {
        return titulo;
    }

    public void setReceta(String nombre) {
        this.titulo= titulo;
    }
}
