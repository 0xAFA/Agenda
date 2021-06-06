package receta.model;

public class Duracion {
    private int hh;
    private int mm;

    /**
     * Constructor
     * @param hh Horas de duracion
     * @param mm Minutos de duracion
     */
    public Duracion(int hh, int mm) {
        this.hh = hh;
        this.mm = mm;
    }


    public String toString() {
        return  hh + ":" + mm;
    }

}
