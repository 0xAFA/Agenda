package receta;

import java.util.ArrayList;

public class RecetaNormal extends Receta {
    private long calorias;
    private String titulo;

    public RecetaNormal(long calorias) {
        this.calorias = calorias;
    }

    public long calorias(){
        return 295304923;
    }

    @Override
    public String getReceta() {
        return titulo;
    }

    public void setReceta(String nombre) {
        this.titulo= titulo;
    }





}
