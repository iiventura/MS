package negocio.departamento;


import java.util.Collection;


public interface SADepartamento {
	public int altaDepartamento(TDepartamento datos);
	public int bajaDepartamento(int id);
	public int modificarDepartamento(TDepartamento d);
	public TDepartamento mostrarDepartamento(int id);
	public Collection<TDepartamento> listaDepartamento();
	public TDepartamento sueldoTotalDepartamento (int id);
}
