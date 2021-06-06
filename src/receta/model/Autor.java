package receta.model;

public class Autor {
    private String usuario;
    private String procedencia;

    /**
     * Constructor
     * @param usuario Autor de la receta
     * @param procedencia Lugar de procedencia de la receta
     */
    public Autor(String usuario, String procedencia) {
        this.usuario = usuario;
        this.procedencia = procedencia;
    }

    @Override
    public String toString() {
        return "Por " + usuario +", desde " + procedencia;
    }
}
