package receta;

import nota.model.INota;

import java.util.ArrayList;

public interface IReceta extends INota {

    String getReceta();

    void setReceta(String titulo);


}
