package negocio.modeloOrdenador;

public interface SAModeloOrdenador {
	public int altaModeloOrdenador(TModeloOrdenador datos);
	public int bajaModeloOrdenador(int id);
	public int asignarDepartamentoModeloOrdenador(TDepartamentoModeloOrdenador datos);
	public int removerDepartamentoModeloOrdenador(TDepartamentoModeloOrdenador datos);
}
