package presentacion.comandos;

public abstract class FactoriaComandos {
	
	private static FactoriaComandos factoriaComandos;
	
	public static synchronized FactoriaComandos getInstancia(){
		if(factoriaComandos == null)
			factoriaComandos = new FactoriaComandosImp();	
		return factoriaComandos;
	}
	public abstract Comando getComando(int evento);
}
