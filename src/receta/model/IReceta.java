package receta.model;

import nota.model.INota;

import java.util.ArrayList;

//Interfaz para las implementaciones de la clase Receta (hereda de nota)

public interface IReceta extends INota {

    String getReceta();

    void setReceta(String titulo);

    long calorias();


    String getDificultad();
}
