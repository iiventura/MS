package negocio.empleado;



public class TEmpleado {
	private int idEmpleado;
	private String dni;
	private String nombre;
	private String domicilio;
	private double sueldo;
	private boolean activo;
	private int departamento;
	
	
	
	public TEmpleado(int idEmpleado, String dni, String nombre, String domicilio, double sueldo, boolean activo, int dep){
		this.idEmpleado = idEmpleado;
		this.dni = dni;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.sueldo =sueldo;
		this.activo = activo;
		this.departamento = dep;
	}
	//ALTA(sin id)
	
	public TEmpleado(String dni, String nombre, String domicilio, double sueldo, boolean activo, int dep){
		this.departamento = dep;
		this.dni = dni;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.sueldo = sueldo;
		this.activo = activo;
	}
	//TOTRANSFER!!(sin el departamento)
	public TEmpleado(int idEmpleado, String dni, String nombre, String domicilio,double sueldo, boolean activo){
		this.idEmpleado = idEmpleado;
		this.dni = dni;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.activo = activo;
	}
	
	//GETTERS
	public int getIdEmpleado(){
		return this.idEmpleado;
	}
	
	public String getDni(){
		return this.dni;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public String getDomicilio(){
		return this.domicilio;
	}
	
	public double getSueldo(){
		return this.sueldo;
	}
	
	public int getDepartamento(){
		return this.departamento;
	}
	
	public boolean getActivo(){
		return this.activo;
	}
	
	//SETTERS
	public void setDni(String dni){
		this.dni = dni;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public void setDomicilio(String domicilio){
		this.domicilio = domicilio;
	}
	
	public void setSueldo(double sueldo){
		this.sueldo=sueldo;
	}
	
	public void setActivo(boolean activo){
		this.activo = activo;
	}
	
	public String toString() {
		String s = "ID EMPLEADO: " + this.idEmpleado + "\n" +
				"DNI: " + this.dni + "\n" +
				"NOMBRE: " + this.nombre + "\n" +
				"DOMICILIO: " + this.domicilio + "\n" +
				"ACTIVO: " + this.activo + "\n" +
				"SUELDO: " + this.sueldo + "\n" +
				"ID DEPARTAMENTO: " + this.departamento + "\n" ;
		return s;
	}
	
}
