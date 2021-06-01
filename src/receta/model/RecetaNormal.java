package receta.model;

public class RecetaNormal extends Receta {
    private String titulo;

    public RecetaNormal(long calorias) {
        super(calorias);
    }

    public long calorias(){
        calorias= calorias +10;
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
