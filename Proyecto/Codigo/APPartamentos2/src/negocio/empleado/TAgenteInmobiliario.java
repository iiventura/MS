package negocio.empleado;


public class TAgenteInmobiliario extends TEmpleado{

	private int a�osExperiencia;

	public TAgenteInmobiliario(int idEmpleado, String dni, String nombre, String domicilio,double sueldo, boolean activo, int dep,int a�osExperiencia){
		super(idEmpleado,  dni, nombre, domicilio,sueldo, activo, dep);
		this.a�osExperiencia = a�osExperiencia;
	}
	public TAgenteInmobiliario(String dni, String nombre, String domicilio, double sueldo,boolean activo, int dep, int a�osExperiencia){
		super(dni, nombre, domicilio,sueldo, activo, dep);
		this.a�osExperiencia = a�osExperiencia;
	}
	
	public int getA�osExperiencia(){
		return this.a�osExperiencia;
	}
	
	public void setA�osExperiencia(int a�osExperiencia){
		this.a�osExperiencia = a�osExperiencia;
	}
	
	public String toString() {
		String s = super.toString();
		s+= "-----------------------------------------"+ "\n";
		s += "AGENTE INMOBILIARIO" +  "\n";
		s += "A�OS EXPERIENCIA: " + this.a�osExperiencia + "\n";
		s+= "-----------------------------------------"+ "\n";
		return s;
	}
}
