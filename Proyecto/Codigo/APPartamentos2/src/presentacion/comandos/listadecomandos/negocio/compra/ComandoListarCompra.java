package presentacion.comandos.listadecomandos.negocio.compra;

import java.util.ArrayList;


import negocio.compra.TCompra;
import negocio.factoriaSA.FactoriaSA;
import presentacion.comandos.Comando;
import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Contexto;

public class ComandoListarCompra implements Comando{

	@Override
	public Contexto ejecuta(Object datos) {
		ArrayList<TCompra> idE = null;
		
		try{
			//Llamamos a la factor�a del servicio de aplicaci�n
			idE= FactoriaSA.getInstancia().generarSACompras().listaCompra();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return new Contexto(ListaComandos.MOSTRARLISTARCOMPRA, idE);
	}

}
