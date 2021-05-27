package receta;

public class RecetaDieta extends Receta {
    private String titulo;
    public RecetaDieta(long calorias) {
    }

    public long calorias(){
        return 29503;
    }

    @Override
    public String getReceta() {
        return titulo;
    }

    public void setReceta(String nombre) {
        this.titulo= titulo;
    }
}
