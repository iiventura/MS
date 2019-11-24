package presentacion.comandos.listadecomandos.negocio.empleado;

import java.util.Collection;

import negocio.empleado.TEmpleado;
import negocio.factoriaSA.FactoriaSA;
import presentacion.comandos.Comando;
import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Contexto;

public class ComandoListarEmpleado implements Comando {

	@Override
	public Contexto ejecuta(Object datos) {
		Collection<TEmpleado> idE = null;
		
		try{
			//Llamamos a la factor�a del servicio de aplicaci�n
			idE= FactoriaSA.getInstancia().generarSAEmpleado().listaEmpleados();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return new Contexto(ListaComandos.MOSTRARLISTAREMPLEADO, idE);
	}

}
