package receta;

public class Autor {
    private String usuario;
    private String procedencia;

    public Autor(String usuario, String procedencia) {
        this.usuario = usuario;
        this.procedencia = procedencia;
    }

    @Override
    public String toString() {
        return "Por " + usuario +", desde " + procedencia;
    }
}
