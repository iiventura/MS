package negocio.modeloOrdenador;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
@NamedQueries({
	@NamedQuery(name = "buscarModeloOrdenadorPorModelo", query = "SELECT m FROM ModeloOrdenador m WHERE m.modelo = :mod")
})
public class ModeloOrdenador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idModeloOrdenador;
	
	@Version
	private int version;//version de la tabla
	
	
	private String modelo;
	private int antiguedad;
	private boolean activo;
	
	@OneToMany(mappedBy="idModeloOrdenador")
	private Collection<DepartamentoModeloOrdenador> departamentos;
	
	public ModeloOrdenador() {
		departamentos = new ArrayList<DepartamentoModeloOrdenador>();
	}
	
	public ModeloOrdenador(TModeloOrdenador mord) {
		this.departamentos = new ArrayList<DepartamentoModeloOrdenador>();
		this.modelo = mord.getModelo();
		this.antiguedad = mord.getAntiguedad();
		this.activo = mord.getActivo();
	}
	
	public String getModelo(){
		return this.modelo;
	}
	
	public int getAntiguedad(){
		return this.antiguedad;
	}
	
	public boolean getActivo(){
		return this.activo;
	}
	
	public int getModeloOrdenadorId(){
		return this.idModeloOrdenador;
	}

	public void setModelo(String modelo){
		this.modelo = modelo;
	}
	
	public void setAntiguedad(int antiguedad){
		this.antiguedad = antiguedad;
	}
	
	public void setActivo(boolean activo){
		this.activo = activo;
	}
	
	public void añadeDepartamentoModeloOrdenador(DepartamentoModeloOrdenador dmo) {
		this.departamentos.add(dmo);
	}
	
	public void eliminaDepartamentoModeloOrdenador(DepartamentoModeloOrdenador dmo) {
		this.departamentos.remove(dmo);
	}
}
