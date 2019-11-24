package negocio.modeloOrdenador;

import java.io.Serializable;

public class DepartamentoModeloOrdenadorId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idModeloOrdenador;
	private int idDepartamento;
	
	public DepartamentoModeloOrdenadorId(){}
	
	public DepartamentoModeloOrdenadorId(int modeloId, int depId){
		this.idModeloOrdenador = modeloId;
		this.idDepartamento = depId;
	}
	
	public boolean equals(Object o){
		if (this == o){
			return true;
		}
			
		if (o == null){
			return false;
		}
			
		if (this.getClass() != o.getClass()){
			return false;
		}
			
		DepartamentoModeloOrdenadorId otro = (DepartamentoModeloOrdenadorId) o;
		if (this.idDepartamento != otro.idDepartamento){
			return false;
		}
			
		if (this.idModeloOrdenador != otro.idModeloOrdenador){
			return false;
		}	
		return true;
	}
	
	public int hashCode(){
		int res = this.idModeloOrdenador * 100 + this.idDepartamento;
		return res;
	}
	
	public int getmodeloOrdenadorID(){
		return this.idModeloOrdenador;
	}
	
	public int getdepartamentoID(){
		return this.idDepartamento;
	}	
}
