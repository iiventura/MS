package presentacion.vistas.vistaEmpleado;



import java.util.List;

import negocio.empleado.TEmpleado;
import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Contexto;

public class VistaEmpleadoImp extends VistaEmpleado {
	
private EmpleadoGUI02 vista;
	
	public VistaEmpleadoImp(){
		vista = new EmpleadoGUI02();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Contexto contexto) {
	int res;
	String msg = "", exito;
	
		switch(contexto.getEvento()) {
		case ListaComandos.VISTAMENUEMPLEADO:
			vista.setVisible(true);
			vista.setLocationRelativeTo(null);
		break;
		case ListaComandos.CERRARVISTAEMPLEADO:
			vista.setVisible(false);
		break;
		case ListaComandos.MOSTRARALTAEMPLEADO:
			res = (int) contexto.getDatos();
			msg = "";
			if(res == -1){
				exito = "Error";
				msg = "El departamento introducido no existe.";
			}else if(res == -2){
				exito = "Error";
				msg = "El empleado ya está dado de alta.";
			}
			else if(res == -3){
				exito = "Error";
				msg = "El empleado especificado es un Agente Inmobiliario. No se puede cambiar de tipo de empleado.";
			}
			else if(res == -4){
				exito = "Error";
				msg = "El empleado especificado es un Director. No se puede cambiar de tipo de empleado.";
			}
			else if(res == -5){
				exito = "Error";
				msg = "El departamento introducido esta dado de baja";
			}
			else{
				exito = "Exito";
				msg = "Empleado dado de alta con ID: " + res + ".";
			}
			
			vista.mensaje(msg, exito);
		break;
		case ListaComandos.MOSTRARBAJAEMPLEADO:
			res = (int) contexto.getDatos();
			msg = "";
			if(res == -2){
				exito = "Error";
				msg = "El empleado ya esta dado de baja.";
			}else if(res == -1){
				exito = "Error";
				msg = "No existe el empleado.";
			}else{
				exito = "Exito";
				msg = "Empleado dado de baja con ID: " + res + ".";
			}
			
			vista.mensaje(msg, exito);
		break;
		case ListaComandos.MOSTRARMODIFICAREMPLEADO:
			res = (int) contexto.getDatos();
			msg = "";
			if(res == -1){
				exito = "Error";
				msg = "El empleado introducido no existe.";
			}else if(res == -2){
				exito = "Error";
				msg = "El empleado está dado de baja.";
			}
			else if(res == -3){
				exito = "Warning";
				msg = "No se puede modificar el DNI. El resto de campos sí han sido modificados";
			}
			else if(res == -4){
				exito = "Error";
				msg = "El departamento introducido no existe.";
			}
			else if(res == -5){
				exito = "Error";
				msg = "El departamento está dado de baja.";
			}
			else if(res == -6){
				exito = "Error";
				msg = "El empleado especificado es un Agente Inmobiliario. No se puede cambiar de tipo de empleado";
			}
			else if(res == -7){
				exito = "Error";
				msg = "El empleado especificado es un Director. No se puede cambiar de tipo de empleado";
			}
			else{
				exito = "Exito";
				msg = "Empleado dado de alta con ID: " + res + ".";
			}
			
			vista.mensaje(msg, exito);
		break;
		case ListaComandos.MOSTRARCONSULTAREMPLEADO:
			TEmpleado emp = (TEmpleado) contexto.getDatos();
			msg = "";
			if(emp == null){
				msg = "El empleado no existe.";
			}else{
				msg = "Exito al consultar el empleado con ID: " + emp.getIdEmpleado() + ".";
			}
			
			vista.mostrarEmpleado(msg, emp);
		break;
		
		case ListaComandos.MOSTRARLISTAREMPLEADO:

			List<TEmpleado> listaEmpleados = (List<TEmpleado>)contexto.getDatos();
			
			if(listaEmpleados.size() == 0){
				msg += "Error: No hay empleados activos";
				exito = "Error";
			}
			else{
				msg += "Éxito al mostrar los " + listaEmpleados.size() + " empleado(s)";
				exito = "Exito";
				vista.setListField(listaEmpleados);
			}	
			
			vista.mensaje(msg, exito);
			
		break;
			
		}
		
	
		
		
	}

}
