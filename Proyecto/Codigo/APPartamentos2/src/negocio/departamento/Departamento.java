package negocio.departamento;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import negocio.empleado.Empleado;
import negocio.empleado.TEmpleado;
import negocio.modeloOrdenador.DepartamentoModeloOrdenador;

@Entity
@NamedQueries({
	@NamedQuery(name = "buscarDepartamentoPorId", query = "SELECT d FROM Departamento d WHERE d.idDepartamento = :id"),
	@NamedQuery(name = "buscarDepartamentoPorNombre", query = "SELECT d FROM Departamento d WHERE upper(d.nombre) = upper(:nombre)"),	
	@NamedQuery(name = "listarDepartamentos", query = "SELECT d FROM Departamento d") 
})

public class Departamento {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDepartamento;
	@Version
	private int version;//version de la tabla
	
	private String nombre;
	private String categoria;
	private boolean activo;
	
	
	//relaccionde 1-n con empleados
	@OneToMany(mappedBy="departamento")
	private List<Empleado> empleados;
	
	//relaccion n-n con modelo ordenador(garantíad). 
	@OneToMany(mappedBy="idDepartamento")
	private Collection<DepartamentoModeloOrdenador> ordenadores;
	
	
	
	//CONSTRUCTORES Y MÉTODOS
	public Departamento(){
		empleados = new ArrayList<Empleado>();
		ordenadores = new ArrayList<DepartamentoModeloOrdenador>();
		activo = true;
	}
	 
	public Departamento(TDepartamento dpto) {
		this.empleados = new ArrayList<Empleado>();
		this.ordenadores = new ArrayList<DepartamentoModeloOrdenador>();
		this.nombre = dpto.getNombre();
		this.categoria = dpto.getCategoria();
		this.activo = true;
	}
	
	 public Departamento(int idDepartamento, String nombre, String categoria, boolean activo){
		 empleados = new ArrayList<Empleado>();
		 ordenadores = new ArrayList<DepartamentoModeloOrdenador>();
		 this.idDepartamento = idDepartamento;
		 this.nombre = nombre;
		 this.categoria = categoria;
		 this.activo = activo;
	 }
	 
	 public Departamento(String nombre) {
			empleados = new ArrayList<Empleado>();
			ordenadores = new ArrayList<DepartamentoModeloOrdenador>();
			this.nombre = nombre;
			this.activo = true;
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
	
	public boolean isActivo() {
		return activo;
	}
	
	//SETTTERS
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	//EMPLEADOS	
	public void anadirEmpleados(Empleado e){
		this.empleados.add(e);
	}
	
	public void eliminaEmpleado(Empleado e) {
		this.empleados.remove(e);
	}
	
	public Collection<Empleado> getEmpleados() {
		return empleados;
	}
	
	
	//DEPARTAMENTOMODELOORDENADOR
	public void anadirDepartamentoModeloOrdenador(DepartamentoModeloOrdenador cmo) {
		ordenadores.add(cmo);
	}
	
	public void eliminaModeloOrdenadorDepartamento(DepartamentoModeloOrdenador cmo) {
		ordenadores.remove(cmo);
	}
	
	public Collection<DepartamentoModeloOrdenador> getDepartamentoModeloOrdenador() {
		return ordenadores;
	}
	
	// ToTransfer
	public TDepartamento ToTransfer(){
		List<TEmpleado> listaAux = new ArrayList<TEmpleado>();
		
		for (Empleado elem : this.empleados) {
			if(elem.getActivo()){
				listaAux.add(elem.toTransfer());
			}
		}
		
		return new TDepartamento(this.idDepartamento, this.nombre,  this.categoria, this.activo, listaAux);
	}
	
	
}
