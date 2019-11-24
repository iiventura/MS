package negocio.empleado;

import javax.persistence.Entity;

import negocio.departamento.Departamento;

@Entity

public class Director extends Empleado{

	private String politicaEmpresarial; 
	private double comision;
	
	public Director(){
		super();
	}
	
	public Director(TDirector director){
		super(director.getIdEmpleado(), director.getDni(), director.getNombre(), director.getDomicilio(), director.getSueldo(), director.getActivo());
		this.politicaEmpresarial = director.getPoliticaEmpresarial();
		this.comision= director.getComision();
	}
	
	public Director(TDirector director, Departamento departamento){
		super(director, departamento);
		this.politicaEmpresarial = director.getPoliticaEmpresarial();
		this.comision= director.getComision();
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

	@Override
	public double totalSueldo() {
		if(this.getActivo())
			return this.getSueldo()+this.comision;
		
		else
			return 0;
		
	}
	
	public TDirector toTransfer(){
		
		return new TDirector(this.getIdEmpleado(), this.getDni(), this.getNombre(), this.getDomicilio(), this.getSueldo(), this.getActivo(), this.getDepartamento().getIdDepartamento(), this.getPoliticaEmpresarial(), this.getComision());		
	}
}
