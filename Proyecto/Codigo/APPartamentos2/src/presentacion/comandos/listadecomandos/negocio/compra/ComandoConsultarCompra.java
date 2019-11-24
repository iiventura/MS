package presentacion.comandos.listadecomandos.negocio.compra;


import negocio.compra.TCompra;
import negocio.factoriaSA.FactoriaSA;
import presentacion.comandos.Comando;
import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Contexto;

public class ComandoConsultarCompra implements Comando{

	@Override
	public Contexto ejecuta(Object datos) {
		TCompra idE = null;
		
		try{
			//Llamamos a la factor�a del servicio de aplicaci�n
			idE= FactoriaSA.getInstancia().generarSACompras().mostrarCompra((int)datos);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return new Contexto(ListaComandos.MOSTRARCONSULTARCOMPRA, idE);
	}

}
