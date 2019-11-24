package presentacion.vistas.vistaTipoVivienda;


import java.util.ArrayList;


import negocio.tipoVivienda.TTipoVivienda;
import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Contexto;

public class VistaTipoViviendaImp extends VistaTipoVivienda  {
	private TipoViviendaGUI vista;
	
	public VistaTipoViviendaImp(){
		vista = new TipoViviendaGUI();
	}
	@Override
	public void update(Contexto contexto) {
		int id;
		String mensaje;
		TTipoVivienda tTipoVivienda;
		switch(contexto.getEvento()) {
		case ListaComandos.VISTAMENUTIPOVIVIENDA:
			vista.setVisible(true);
			vista.setLocationRelativeTo(null);
		break;
		case ListaComandos.CERRARVISTATIPOVIVIENDA:
			vista.setVisible(false);
		break;
		case ListaComandos.MOSTRARALTATIPOVIVIENDA:
			mensaje ="";
			id = (int)contexto.getDatos();
			switch(id){
			case -1:
				mensaje += "Error: Fallo al dar de alta al tipo de vivienda";
				break;
			case -2:
				mensaje += "Error: Fallo al activar un tipo de vivienda";
				break;
			case -3:
				mensaje += "Error: El tipo de vivienda ya est� dado de alta";
				break;
			case -4:
				mensaje += "Error: El tipo de vivienda ya exist�a con otro tipo";
				break;
			default:
				mensaje += "�xito al dar de alta la vivienda con ID: " + Integer.toString(id);
				break;	
			}
			
			
			if(id >= 1)
				vista.mensaje(mensaje, "Exito");
			else
				vista.mensaje(mensaje, "Error");
			vista.setIdField( (int)contexto.getDatos());
		break;
		case ListaComandos.MOSTRARBAJATIPOVIVIENDA:
			mensaje ="";
			id = (int)contexto.getDatos();
			switch(id){
			case -1:
				mensaje += "Error: Fallo al dar de baja el tipo de vivienda";
				break;
			case -2:
				mensaje += "Error: El tipo de vivienda especificado ya estaba dado de baja";
				break;
			case -3:
				mensaje += "Error: El tipo de vivienda no existe";
				break;
			default:
				mensaje += "�xito al dar de baja el tipo de vivienda con ID: " + Integer.toString(id);
				break;	
			}
			
			if(id >= 1)
				vista.mensaje(mensaje, "Exito");
			else
				vista.mensaje(mensaje, "Error");
		break;
		case ListaComandos.MOSTRARMODIFICARTIPOVIVIENDA:
			mensaje ="";
			id = (int)contexto.getDatos();
	
			switch(id){
			case -1:
				mensaje += "Error: Fallo al modificar el tipo de vivienda";
				break;
			case -2:
				mensaje += "Error: El tipo de vivienda ya exist�a con otro tipo";
				break;
			case -3:
				mensaje += "Error: El Tipo Vivienda est� dado de baja";
				break;
			case -4:
				mensaje += "Error: El tipo Vivienda no existe";
				break;
			default:
				mensaje += "�xito al modificar el tipo de vivienda ID: " + Integer.toString(id);
				break;	
			}
			
			if(id >= 1)
				vista.mensaje(mensaje, "Exito");
			else
				vista.mensaje(mensaje, "Error");
		break;
		case ListaComandos.MOSTRARCONSULTARTIPOVIVIENDA:
			mensaje ="";
			tTipoVivienda = (TTipoVivienda)contexto.getDatos();
			
			if (tTipoVivienda == null) {
				mensaje += "Error: El tipo de vivienda no existe";
			}
			else if(!tTipoVivienda.getActivo()) {
				mensaje += "Error: El tipo de vivienda esta dado de baja";
			}
			else {
				mensaje += "�xito al mostrar el tipo de vivienda con ID: " + Integer.toString(tTipoVivienda.getId());
			}
			
			if(tTipoVivienda != null && tTipoVivienda.getActivo()) {
				vista.mensaje(mensaje, "Exito");
				vista.setTViviendatField(tTipoVivienda, "TIPOVIVIENDA: \n");
				
			} else
				vista.mensaje(mensaje, "Error");
			break;
		case ListaComandos.MOSTRARLISTARTIPOVIVIENDA:
			mensaje ="";
			
			@SuppressWarnings("unchecked")
			ArrayList<TTipoVivienda> listaVivs = (ArrayList<TTipoVivienda>)contexto.getDatos();
			
			switch(listaVivs.size()){
			case 0:
				mensaje += "Error: Base de datos vac�a";
				break;
			default:
				mensaje += "�xito al mostrar los " + listaVivs.size() + " tipos de vivienda de la base de datos";
				break;	
			}
			
			if(listaVivs.size() > 0) {
				vista.mensaje(mensaje, "Exito");
				vista.setListField(listaVivs);
			} else
				vista.mensaje(mensaje, "Error");
			break;
		case ListaComandos.MOSTRARTIPOVIVIENDAMASVENDIDO:
			mensaje ="";
			tTipoVivienda = (TTipoVivienda) contexto.getDatos();
						
			if (tTipoVivienda == null) {
				mensaje += "Error: No hay tipos de viviendas o compras en la base de datos";
			}
			else {
				mensaje += "�xito al mostrar la vivienda con m�s compras. ID: "+ Integer.toString(tTipoVivienda.getId());
			}
			
			if(tTipoVivienda != null) {
				vista.mensaje(mensaje, "Exito");
				vista.setTViviendatField(tTipoVivienda, "TIPOVIVIENDA M�S VENDIDO: \n");
			} else
				vista.mensaje(mensaje, "Error");
			
			
			break;
		}
	}
}
