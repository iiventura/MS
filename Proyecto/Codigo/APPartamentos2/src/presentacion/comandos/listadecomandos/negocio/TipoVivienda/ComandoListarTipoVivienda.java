package presentacion.comandos.listadecomandos.negocio.TipoVivienda;

import java.util.ArrayList;

import negocio.factoriaSA.FactoriaSA;
import negocio.tipoVivienda.TTipoVivienda;
import presentacion.comandos.Comando;
import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Contexto;

public class ComandoListarTipoVivienda implements Comando  {

	@Override
	public Contexto ejecuta(Object datos) {
		ArrayList<TTipoVivienda> idE = null;
		try {
			//Llamamos a la factor�a del servicio de aplicaci�n
			//El dao se encarga de distinguir si es piso o chalet.
			idE = FactoriaSA.getInstancia().generarSATipoVivienda().listaTipoVivienda();
		} catch (Exception e) {
			// TODO Bloque catch generado autom�ticamente
			e.printStackTrace();
		}
		
		return new Contexto (ListaComandos.MOSTRARLISTARTIPOVIVIENDA, idE);
	}

}
