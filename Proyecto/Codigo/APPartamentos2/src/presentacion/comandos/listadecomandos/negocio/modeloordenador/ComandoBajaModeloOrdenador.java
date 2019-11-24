package presentacion.comandos.listadecomandos.negocio.modeloordenador;

import negocio.factoriaSA.FactoriaSA;
import presentacion.comandos.Comando;
import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Contexto;

public class ComandoBajaModeloOrdenador implements Comando{

	@Override
	public Contexto ejecuta(Object datos) {
		int idE = 0;
		
		try {
			idE = FactoriaSA.getInstancia().generarSAModeloOrdenador().bajaModeloOrdenador((int) datos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Contexto(ListaComandos.MOSTRARBAJAMODELOORDENADOR, idE);
	}

}
