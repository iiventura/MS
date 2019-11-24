package negocio.empleado;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Version;


import negocio.departamento.Departamento;

@Inheritance(strategy = InheritanceType.JOINED)

@Entity
@NamedQueries({
		// Buscar empleado por dni
		@NamedQuery(name = "buscarEmpleadoPorDni", query = "SELECT e FROM Empleado e  WHERE e.dni = :dni"),

		//Listar empleados
		@NamedQuery(name = "listarEmpleados", query = "SELECT e FROM Empleado e WHERE e.activo = true") })

public abstract class Empleado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEmpleado;
	
	@Version
	protected int version;
	
	
	private String dni;
	private String nombre;
	private String domicilio;
	private double sueldo;
	private boolean activo;

	@ManyToOne
	@JoinColumn(name = "idDepartamento")
	private Departamento departamento;

	public Empleado() {
		departamento= new Departamento();
		activo=true;
	}

	public Empleado(int id) {
		this.idEmpleado = id;
	}
	//*******FALTA EL DEPARTAMENTO, CUANDO CONECTEMOS LA BBDD LO TOCAMOS
	public Empleado(int idEmpleado, String dni, String nombre, String domicilio,double sueldo, boolean activo) {
		this.idEmpleado = idEmpleado;
		this.dni = dni;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.sueldo= sueldo;
		this.activo = activo;
	}

	public Empleado(TEmpleado empleado, Departamento dep) {
		this.idEmpleado = empleado.getIdEmpleado();
		this.dni = empleado.getDni();
		this.nombre = empleado.getNombre();
		this.domicilio = empleado.getDomicilio();
		this.sueldo= empleado.getSueldo();
		this.activo = empleado.getActivo();
		this.departamento = dep;
	}

	
	public Departamento getDepartamento() {
		return departamento;
	}
	// GETTERS

	// puede que no haga falta
	public int getIdEmpleado() {
		return this.idEmpleado;
	}

	public String getDni() {
		return this.dni;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getDomicilio() {
		return this.domicilio;
	}

	public double getSueldo() {
		return this.sueldo;
	}
	
	public boolean getActivo() {
		return this.activo;
	}

	// SETTERS
	public void setDepartamento(Departamento dep) {
		this.departamento = dep;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	
	public TEmpleado toTransfer() {
		return new TEmpleado(this.idEmpleado, this.dni, this.nombre, this.domicilio,this.sueldo, this.activo, this.departamento.getIdDepartamento());
	}
	
	public abstract double totalSueldo();

}
