package negocio.empleado;


public class TAgenteInmobiliario extends TEmpleado{

	private int añosExperiencia;

	public TAgenteInmobiliario(int idEmpleado, String dni, String nombre, String domicilio,double sueldo, boolean activo, int dep,int añosExperiencia){
		super(idEmpleado,  dni, nombre, domicilio,sueldo, activo, dep);
		this.añosExperiencia = añosExperiencia;
	}
	public TAgenteInmobiliario(String dni, String nombre, String domicilio, double sueldo,boolean activo, int dep, int añosExperiencia){
		super(dni, nombre, domicilio,sueldo, activo, dep);
		this.añosExperiencia = añosExperiencia;
	}
	
	public int getAñosExperiencia(){
		return this.añosExperiencia;
	}
	
	public void setAñosExperiencia(int añosExperiencia){
		this.añosExperiencia = añosExperiencia;
	}
	
	public String toString() {
		String s = super.toString();
		s+= "-----------------------------------------"+ "\n";
		s += "AGENTE INMOBILIARIO" +  "\n";
		s += "AÑOS EXPERIENCIA: " + this.añosExperiencia + "\n";
		s+= "-----------------------------------------"+ "\n";
		return s;
	}
}
