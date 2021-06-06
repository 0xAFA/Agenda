package receta.model;

public class RecetaNormal extends Receta {
    private String titulo;

    /**
     * Construcor
     * @param calorias Devuelve las calorias de la receta
     */
    public RecetaNormal(long calorias) {
        super(calorias);
    }

    /**
     * Estipula las calorias de la receta tipo normal
     * @return calorias Devuelve el valor de las calorias a modo de  receta normal
     */
    public long calorias(){
        calorias= calorias +10;
        return calorias;
    }

    // Getters y Setters

    @Override
    public String getReceta() {
        return titulo;
    }

    public void setReceta(String nombre) {
        this.titulo= titulo;
    }





}
