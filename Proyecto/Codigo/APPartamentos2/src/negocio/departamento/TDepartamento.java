package negocio.departamento;

import java.util.List;

import negocio.empleado.TEmpleado;

public class TDepartamento {
	private int idDepartamento;
	private String nombre;
	private String categoria;
	private boolean activo;
	private List<TEmpleado>listaEmpleados; 
	private double totalSueldos;
	
	public TDepartamento(String nombre, String categoria, boolean activo){
		this.categoria = categoria;
		this.nombre = nombre;
		this.activo = activo;
		this.totalSueldos = 0;
	}
	
	public TDepartamento(int idDep, String nombre, String categoria, boolean activo){
		this.idDepartamento = idDep;
		this.categoria = categoria;
		this.nombre = nombre;
		this.activo = activo;
		this.totalSueldos = 0;
	}
	
	public TDepartamento(int idDep, String nombre, String categoria, boolean activo, List<TEmpleado> lista){
		this.idDepartamento = idDep;
		this.categoria = categoria;
		this.nombre = nombre;
		this.activo = activo;
		this.listaEmpleados = lista;
		this.totalSueldos = 0;
	}
	
	
	//GETTERS
	public int getIdDepartamento(){
		return this.idDepartamento;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public String getCategoria(){
		return this.categoria;
	}
	
	public boolean getActivo(){
		return this.activo;
	}
	
	public double getTotalSueldoDepartamento(){
		return this.totalSueldos;
	}
	
	
	//SETTERS
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public void setCategoria(String categoria){
		this.categoria = categoria;
	}
	
	public void setActivo(boolean activo){
		this.activo = activo;
	}
	
	public void setTotalSueldos(double total){
		this.totalSueldos=total;
	}
	
	//ToString
	public String toString() {
		String s = "ID DEPARTAMENTO: " + this.idDepartamento + "\n" +
			"NOMBRE: " + this.nombre + "\n" +
			"CATEGORÍA: " + this.categoria + "\n" + 
			"ACTIVO: ";
			if(this.activo) {
				s += "Si\n"; 
			} else {
				s += "No\n";
			}
			s += "--------------------------------------------" + "\n" +
			"EMPLEADO(S): " + "\n\n";

		if(this.listaEmpleados.size() == 0){
			s += "Actualmente No hay empleados activos en el departamento";
		}
		else{
			for (TEmpleado elem : this.listaEmpleados) {
				s += elem.toString() +  "\n";
			}
		}
		s += "--------------------------------------------" + "\n\n";

		return s;
	}
}
