package presentacion.comandos.listadecomandos.negocio.departamento;

import java.util.Collection;

import negocio.departamento.TDepartamento;
import negocio.factoriaSA.FactoriaSA;
import presentacion.comandos.Comando;
import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Contexto;

public class ComandoListarDepartamento implements Comando{

	@Override
	public Contexto ejecuta(Object datos) {
		Collection<TDepartamento> idE = null;
		
		try{
			//Llamamos a la factor�a del servicio de aplicaci�n
			idE= FactoriaSA.getInstancia().generarSADepartamento().listaDepartamento();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return new Contexto(ListaComandos.MOSTRARLISTARDEPARTAMENTO, idE);
	}

}
