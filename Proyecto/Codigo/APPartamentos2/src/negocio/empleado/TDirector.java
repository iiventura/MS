package negocio.empleado;



public class TDirector extends TEmpleado{

	private String politicaEmpresarial;
	private double comision;
	
	public TDirector(int idEmpleado, String dni, String nombre, String domicilio,double sueldo,  boolean activo, int dep, String politicaEmpresarial, double comision){
		super(idEmpleado,  dni, nombre, domicilio,sueldo, activo, dep);
		this.politicaEmpresarial = politicaEmpresarial;
		this.comision=comision;
	}
	public TDirector(String dni, String nombre, String domicilio,double sueldo, boolean activo, int dep,String politicaEmpresarial, double comision){
		super(dni, nombre, domicilio, sueldo,activo, dep);
		this.politicaEmpresarial = politicaEmpresarial;
		this.comision=comision;
	}
	
	public String getPoliticaEmpresarial(){
		return this.politicaEmpresarial;
	}
	
	public double getComision(){
		return this.comision;
	}
	
	public void setPoliticaEmpresarial(String politicaEmpresarial){
		this.politicaEmpresarial = politicaEmpresarial;
	}
	
	public void setComision(double comision){
		this.comision=comision;
	}
	
	public String toString() {
		String s = super.toString();
		s+= "-----------------------------------------"+ "\n";
		s+= "DIRECTOR"+ "\n";
		s += "POLITICA EMPRESARIAL: " + this.politicaEmpresarial + "\n";
		s += "COMISION: "+this.comision+"\n";
		s+= "-----------------------------------------"+ "\n";
		return s;
	}
}
