package negocio.modeloOrdenador;

public class TModeloOrdenador {
	private int idModeloOrdenador;
	private String modelo;
	private int antiguedad;
	private boolean activo;
	
	public TModeloOrdenador(String modelo, int antiguedad, boolean activo) {
		this.modelo = modelo;
		this.antiguedad = antiguedad;
		this.activo = activo;
	}
	
	public TModeloOrdenador(int idModOrd, String modelo, int antiguedad, boolean activo) {
		this.idModeloOrdenador = idModOrd;
		this.modelo = modelo;
		this.antiguedad = antiguedad;
		this.activo = activo;
	}
	
	// __________GETTERS__________
	public String getModelo() {
		return this.modelo;
	}
	
	public int getId() {
		return this.idModeloOrdenador;
	}
	
	public int getAntiguedad() {
		return this.antiguedad;
	}
	
	public boolean getActivo() {
		return this.activo;
	}
	
	// __________SETTERS__________
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	// __________TOSTRING__________
	public String toString() {
		String s = "ID DEL ORDENADOR: " + this.idModeloOrdenador + "\n" +
				"MODELO DEL ORDENADOR: " + this.modelo + "\n" +
				"ANTIGUEDAD: " + this.antiguedad + "\n" +
				"ACTIVO: ";
			s += this.activo ? "Si\n" : "No\n";
			s += "--------------------------------------------\n";
		return s;
	}
}
