package calendario.model;

import java.util.ArrayList;
import java.util.List;

public class Calendario implements ICalendario{
	
	 private static final long serialVersionUID = 2L;
	
	private String texto;
	private String fecha;
	
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Calendario(String texto, String fecha) {
		this.texto = texto;
		this.fecha = fecha;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNombre(String nombre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<String> getEtiquetas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasEtiqueta(String etiqueta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addEtiqueta(String etiqueta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeEtiqueta(String etiqueta) {
		// TODO Auto-generated method stub
		
	}
}
