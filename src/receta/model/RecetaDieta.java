package receta.model;

public class RecetaDieta extends Receta {
    private String titulo;

    public RecetaDieta(long calorias) {
        super(calorias);
    }


    public long calorias(){
        calorias= calorias -10;
        return calorias;
    }

    @Override
    public String getReceta() {
        return titulo;
    }

    public void setReceta(String nombre) {
        this.titulo= titulo;
    }
}
