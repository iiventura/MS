package negocio.empleado;


import java.util.Collection;


public interface SAEmpleado {
	public int altaEmpleado(TEmpleado e);
	public int bajaEmpleado(int id);
	public int modificarEmpleado(TEmpleado e);
	public TEmpleado mostrarEmpleado(int id);
	public Collection<TEmpleado> listaEmpleados();
}
