package presentacion.comandos.listadecomandos.negocio.compra;

import negocio.compra.TCompra;
import negocio.factoriaSA.FactoriaSA;
import presentacion.comandos.Comando;
import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Contexto;

public class ComandoAnadirViviendasACompraCerrada implements Comando {

	@Override
	public Contexto ejecuta(Object datos) {
		// TODO Auto-generated method stub
		int idE = 0;
		
		try{
			idE=FactoriaSA.getInstancia().generarSACompras().anadirViviendasACompraCerrada((TCompra) datos);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return new Contexto(ListaComandos.MOSTRARANADIRVIVIENDASACOMPRACERRADA,idE);
	}

}
