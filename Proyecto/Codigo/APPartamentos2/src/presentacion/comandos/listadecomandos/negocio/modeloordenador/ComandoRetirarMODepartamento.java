package presentacion.comandos.listadecomandos.negocio.modeloordenador;

import negocio.factoriaSA.FactoriaSA;
import negocio.modeloOrdenador.TDepartamentoModeloOrdenador;
import negocio.modeloOrdenador.TModeloOrdenador;
import presentacion.comandos.Comando;
import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Contexto;

public class ComandoRetirarMODepartamento implements Comando{

	@Override
	public Contexto ejecuta(Object datos) {
		// TODO Auto-generated method stub
		int idE = 0;
		try {
			idE = FactoriaSA.getInstancia().generarSAModeloOrdenador().removerDepartamentoModeloOrdenador((TDepartamentoModeloOrdenador) datos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Contexto(ListaComandos.MOSTRARRETIRARMODEPARTAMENTO, idE);
	}

}
