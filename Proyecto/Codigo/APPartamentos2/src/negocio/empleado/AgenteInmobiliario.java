package negocio.empleado;

import javax.persistence.Entity;


import negocio.departamento.Departamento;


@Entity


public class AgenteInmobiliario extends Empleado{

	private int a�osExperiencia;
	
	public AgenteInmobiliario(){
		super();
	}
	
	public AgenteInmobiliario(TAgenteInmobiliario AgenteInmobiliario){
		super(AgenteInmobiliario.getIdEmpleado(), AgenteInmobiliario.getDni(), AgenteInmobiliario.getNombre(),AgenteInmobiliario.getDomicilio(), AgenteInmobiliario.getSueldo(), AgenteInmobiliario.getActivo());
		this.a�osExperiencia = AgenteInmobiliario.getA�osExperiencia();
	}
	
	public AgenteInmobiliario(TAgenteInmobiliario AgenteInmobiliario, Departamento departamento){
		super(AgenteInmobiliario, departamento);
		this.a�osExperiencia = AgenteInmobiliario.getA�osExperiencia();
	}
	
	public int getA�osExperiencia(){
		return this.a�osExperiencia;
	}
	
	public void setA�osExperiencia(int a�osExperiencia){
		this.a�osExperiencia = a�osExperiencia;
	}

	@Override
	public double totalSueldo() {
		if(this.getActivo())
			return this.getSueldo();
		else 
			return 0;
	}
	
	public TAgenteInmobiliario toTransfer(){
		return new TAgenteInmobiliario(this.getIdEmpleado(), this.getDni(), this.getNombre(), this.getDomicilio(), this.getSueldo(), this.getActivo(), this.getDepartamento().getIdDepartamento(), this.getA�osExperiencia());		
	}
}
