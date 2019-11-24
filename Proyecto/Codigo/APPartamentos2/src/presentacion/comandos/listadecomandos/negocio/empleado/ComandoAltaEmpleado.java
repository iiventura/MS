package presentacion.comandos.listadecomandos.negocio.empleado;


import negocio.empleado.TEmpleado;
import negocio.factoriaSA.FactoriaSA;
import presentacion.comandos.Comando;
import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Contexto;

public class ComandoAltaEmpleado implements Comando{

	@Override
	public Contexto ejecuta(Object datos) {
		// TODO Auto-generated method stub
		int idE = 0;
		try {
			//Llamamos a la factor�a del servicio de aplicaci�n
			idE = FactoriaSA.getInstancia().generarSAEmpleado().altaEmpleado((TEmpleado) datos);
		} catch (Exception e) {
			// TODO Bloque catch generado autom�ticamente
			e.printStackTrace();
		}
		
		return new Contexto (ListaComandos.MOSTRARALTAEMPLEADO, idE);
	}

}
