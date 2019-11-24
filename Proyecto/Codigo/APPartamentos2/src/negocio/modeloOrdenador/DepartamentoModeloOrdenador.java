package negocio.modeloOrdenador;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import negocio.departamento.Departamento;

@Entity
@NamedQueries({
		@NamedQuery(name = "buscarDepartamentoModeloOrdenadorPorId", query = "SELECT d FROM DepartamentoModeloOrdenador d WHERE d.idDepartamento = :idDepartamento AND d.idModeloOrdenador = :idModeloOrdenador"),
		@NamedQuery(name = "buscarDepartamentoModeloOrdenadorPorIdModeloOrdenador", query = "SELECT d FROM DepartamentoModeloOrdenador d WHERE d.idModeloOrdenador = :idModeloOrdenador"),
		@NamedQuery(name = "buscarDepartamentoModeloOrdenadorPorIdDepartamento", query = "SELECT d FROM DepartamentoModeloOrdenador d WHERE d.idDepartamento = :idDepartamento")})
@IdClass(DepartamentoModeloOrdenadorId.class)
public class DepartamentoModeloOrdenador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "IDMODELOORDENADOR")
	private ModeloOrdenador idModeloOrdenador;

	@Id
	@ManyToOne
	@JoinColumn(name = "IDDEPARTAMENTO")
	private Departamento idDepartamento;

	private int garantia;

	public DepartamentoModeloOrdenador() {
	}

	public DepartamentoModeloOrdenador(ModeloOrdenador modeloOrdenador, Departamento departamento, int garantia) {
		this.idModeloOrdenador = modeloOrdenador;
		this.idDepartamento = departamento;
		this.garantia = garantia;
	}

	public ModeloOrdenador getmodeloOrdenador() {
		return this.idModeloOrdenador;

	}

	public Departamento getDepartamento() {
		return this.idDepartamento;
	}

	public int getGarantia() {
		return this.garantia;

	}

	public void setModeloOrdenador(ModeloOrdenador modeloOrdenador) {
		this.idModeloOrdenador = modeloOrdenador;
	}

	public void setDepartamento(Departamento departamento) {
		this.idDepartamento = departamento;
	}

	public void setGarantia(int garantia) {
		this.garantia = garantia;
	}
}
