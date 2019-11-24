package negocio.modeloOrdenador;

public class TDepartamentoModeloOrdenador {
	private int modeloOrdenadorID;
	private int departamentoID;
	private int garantia;
	
	public TDepartamentoModeloOrdenador(int modeloOrdenadorID, int departamentoID, int garantia) {
		this.modeloOrdenadorID = modeloOrdenadorID;
		this.departamentoID = departamentoID;
		this.garantia = garantia;
	}
	
	public int getModeloOrdenadorID() {
		return this.modeloOrdenadorID;
	}
	
	public int getDepartamentoID(){
		return this.departamentoID;
	}
	
	public int getGarantia(){
		return this.garantia;
		
	}
	
	public void setGarantia(int garantia){
		this.garantia = garantia;
	}	
}
