package presentacion.comandos.listadecomandos.vista.ventanaModeloOrdenador;

import presentacion.comandos.Comando;
import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Contexto;

public class ComandoAbrirVistaModeloOrdenador implements Comando{

	@Override
	public Contexto ejecuta(Object datos) {

		return new Contexto(ListaComandos.VISTAMENUMODELOORDENADOR, datos);
	}

}
