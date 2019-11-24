package presentacion.vistas.vistaModeloOrdenador;

import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Contexto;


public class VistaModeloOrdenadorImp  extends VistaModeloOrdenador{
	private ModeloOrdenadorGUI vista;
	
	public VistaModeloOrdenadorImp(){
		vista = new ModeloOrdenadorGUI();
	}


	@Override
	public void update(Contexto contexto) {
		int res;
		String msg = "";
		
			switch(contexto.getEvento()) {
			case ListaComandos.VISTAMENUMODELOORDENADOR:
				vista.setVisible(true);
				vista.setLocationRelativeTo(null);
			break;
			case ListaComandos.CERRARVISTAMODELOORDENADOR:
				vista.setVisible(false);
			break;
			case ListaComandos.MOSTRARALTAMODELOORDENADOR:
				res = (int) contexto.getDatos();
				if(res > 0){
					msg = "Exito al dar de alta el modelo Ordenador con ID: " + res;
					vista.mensaje(msg, "Exito");
				}
				else if(res == -2){
					msg = "El modelo del ordenador ya está dado de alta";
					vista.mensaje(msg, "Error");
				}
			break;
			case ListaComandos.MOSTRARBAJAMODELOORDENADOR:
				res = (int) contexto.getDatos();
				if(res > 0){
					msg = "Exito al dar de baja el modelo Ordenador con ID: " + res;
					vista.mensaje(msg, "Exito");
				}
				else if(res == -1) {
					msg = "Error, el modelo del ordenador no existe";
					vista.mensaje(msg, "Error");
				}
				else if(res == -2){
					msg = "Error, el modelo del ordenador ya está dado de baja";
					vista.mensaje(msg, "Error");
				}
				else if(res == -3){
					msg = "Error, el modelo del ordenador tiene departamentos asignados";
					vista.mensaje(msg, "Error");
				}
			break;
			case ListaComandos.MOSTRARASIGNARMODEPARTAMENTO:
				res = (int) contexto.getDatos();
				if(res >= 0){
					msg = "Exito al asignar el modeloOrdenador al departamento con garantía: " + res;
					vista.mensaje(msg, "Exito");
				}
				else if(res == -1) {
					msg = "Error, el departamento y/o el modeloOrdenador están dados de baja";
					vista.mensaje(msg, "Error");
				}
				else if(res == -2){
					msg = "Error, el departamento y/o el modeloOrdenador no existen";
					vista.mensaje(msg, "Error");
				}
				else if(res == -3){
					msg = "Error, el modelo del ordenador ya está asignado a ese departamento";
					vista.mensaje(msg, "Error");
				}
				
				break;
			case ListaComandos.MOSTRARRETIRARMODEPARTAMENTO:
				res = (int) contexto.getDatos();
				if(res == 1){
					msg = "Exito al retirar el modeloOrdenador del departamento";
					vista.mensaje(msg, "Exito");
				}
				else if(res == -1) {
					msg = "Error, el modelo del ordenador o el departamento están dados de baja";
					vista.mensaje(msg, "Error");
				}
				else if(res == -2){
					msg = "Error, el modelo del ordenador o el departamento no existe";
					vista.mensaje(msg, "Error");
				}
				else if(res == -3){
					msg = "Error, el modelo del ordenador no está asignado a ese departamento";
					vista.mensaje(msg, "Error");
				}
				break;
			}
	}

}
