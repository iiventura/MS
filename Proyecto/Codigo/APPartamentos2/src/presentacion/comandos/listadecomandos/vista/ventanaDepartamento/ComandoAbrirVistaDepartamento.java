package presentacion.comandos.listadecomandos.vista.ventanaDepartamento;

import presentacion.comandos.Comando;
import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Contexto;

public class ComandoAbrirVistaDepartamento implements Comando{

	@Override
	public Contexto ejecuta(Object datos) {
		return new Contexto(ListaComandos.VISTAMENUDEPARTAMENTO,datos);
	}

}
