package negocio.empleado;

import javax.persistence.Entity;


import negocio.departamento.Departamento;


@Entity


public class AgenteInmobiliario extends Empleado{

	private int añosExperiencia;
	
	public AgenteInmobiliario(){
		super();
	}
	
	public AgenteInmobiliario(TAgenteInmobiliario AgenteInmobiliario){
		super(AgenteInmobiliario.getIdEmpleado(), AgenteInmobiliario.getDni(), AgenteInmobiliario.getNombre(),AgenteInmobiliario.getDomicilio(), AgenteInmobiliario.getSueldo(), AgenteInmobiliario.getActivo());
		this.añosExperiencia = AgenteInmobiliario.getAñosExperiencia();
	}
	
	public AgenteInmobiliario(TAgenteInmobiliario AgenteInmobiliario, Departamento departamento){
		super(AgenteInmobiliario, departamento);
		this.añosExperiencia = AgenteInmobiliario.getAñosExperiencia();
	}
	
	public int getAñosExperiencia(){
		return this.añosExperiencia;
	}
	
	public void setAñosExperiencia(int añosExperiencia){
		this.añosExperiencia = añosExperiencia;
	}

	@Override
	public double totalSueldo() {
		if(this.getActivo())
			return this.getSueldo();
		else 
			return 0;
	}
	
	public TAgenteInmobiliario toTransfer(){
		return new TAgenteInmobiliario(this.getIdEmpleado(), this.getDni(), this.getNombre(), this.getDomicilio(), this.getSueldo(), this.getActivo(), this.getDepartamento().getIdDepartamento(), this.getAñosExperiencia());		
	}
}
