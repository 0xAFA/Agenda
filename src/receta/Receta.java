package receta;

import java.util.List;

public abstract class Receta {
    private String clasificacion;
    private String dificultad;
    private Autor autor;
    private Duracion duracion;
    public List<String> listaIngredientes;


    public abstract long calorias();


}
