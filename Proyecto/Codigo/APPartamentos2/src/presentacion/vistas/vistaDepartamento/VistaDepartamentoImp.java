package presentacion.vistas.vistaDepartamento;


import java.util.List;


import negocio.departamento.TDepartamento;
import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Contexto;

public class VistaDepartamentoImp extends VistaDepartamento{
	private DepartamentoGUI vistaDepartamento;

	public VistaDepartamentoImp(){
		vistaDepartamento = new DepartamentoGUI();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void update(Contexto contexto) {
		int id;
		String mensaje, exito;
		TDepartamento tDepartamento;
		
		switch(contexto.getEvento()) {
		case ListaComandos.VISTAMENUDEPARTAMENTO:
			vistaDepartamento.setVisible(true);
			vistaDepartamento.setLocationRelativeTo(null);
		break;
		case ListaComandos.CERRARVISTADEPARTAMENTO:
			vistaDepartamento.setVisible(false);
		break;
		case ListaComandos.MOSTRARALTADEPARTAMENTO:
			mensaje = "";
			id = (int)contexto.getDatos();
			
			switch(id){
			case -1:
				mensaje += "Error: Fallo de JPA al dar de alta el departamento.";
				break;
			case -2:
				mensaje += "El departamento existe y está activo.";
				break;
			default:
				mensaje += "Éxito al dar de alta el departamento ID: " + Integer.toString(id);
				break;	
			}
		
			if(id >= 1){
				vistaDepartamento.mensaje(mensaje, "Exito");
			}
			else{
				vistaDepartamento.mensaje(mensaje, "Error");
			}
		break;
		case ListaComandos.MOSTRARBAJADEPARTAMENTO:
			mensaje = "";
			id = (int)contexto.getDatos();
			
			switch(id){
			case -1:
				mensaje += "Error: Fallo en JPA al dar de baja el departamento";
				break;
			case -2:
				mensaje += "Error: No existe el Departamento.";
				break;
			case -3:
				mensaje += "Error: El departamento ya esta dado de baja.";
				break;
			case -4:
				mensaje += "Error: Existe un empleado activo en el Departamento.";
				break;
			case -5:
				mensaje += "Error: Hay un ordenador asignado en el Departamento.";
				break;
			default:
				mensaje += "Éxito al dar de baja el departamento con ID: " + Integer.toString(id);
				break;	
			}
		
			if(id >= 1)
				vistaDepartamento.mensaje(mensaje, "Exito");
			else
				vistaDepartamento.mensaje(mensaje, "Error");
		break;
		case ListaComandos.MOSTRARMODIFICARDEPARTAMENTO: //Revisado
			mensaje ="";
			id = (int)contexto.getDatos();
			
			switch(id){
			case -1:
				mensaje += "Error: Fallo en JPA al modificar el departamento";
				exito = "Error";
				break;
			case -2:
				mensaje += "Error: El departamento especificado no existe";
				exito = "Error";
				break;
			case -3:
				mensaje += "Error: El departamento introducido está dado de baja";
				exito = "Error";
				break;
			default:
				mensaje += "Éxito al modificar el departamento ID: " + Integer.toString(id);
				exito = "Exito";
				break;	
			}
				vistaDepartamento.mensaje(mensaje, "Exito");

		break;
		case ListaComandos.MOSTRARCONSULTARDEPARTAMENTO: //Revisado
			mensaje ="";
			tDepartamento = (TDepartamento)contexto.getDatos();
			
			if (tDepartamento == null) {
				mensaje += "Error: El departamento no existe";
				exito = "Error";
			}
			else {
				mensaje += "Éxito al mostrar el departamento ID: " + Integer.toString(tDepartamento.getIdDepartamento());
				exito = "Exito";
				vistaDepartamento.pintarMostrarDepartamento(tDepartamento);
			}
				vistaDepartamento.mensaje(mensaje, exito);

		break;
		case ListaComandos.MOSTRARLISTARDEPARTAMENTO: //Revisado
			mensaje ="";
			List<TDepartamento> listaDepartamentos = (List<TDepartamento>)contexto.getDatos();
			
			if(listaDepartamentos == null || listaDepartamentos.isEmpty()){
				mensaje += "Error: No hay departamentos activos";
				exito = "Error";
			}else{
				mensaje += "Éxito al mostrar los " + listaDepartamentos.size() + " departamento(s)";
				vistaDepartamento.setDepartamentos(listaDepartamentos);
				exito = "Exito";
			}
			
			vistaDepartamento.mensaje(mensaje, exito);
			
		break;
		case ListaComandos.MOSTRARSUELDODEPARTAMENTO:
			mensaje = "";
			tDepartamento = (TDepartamento)contexto.getDatos();
			
			if(tDepartamento == null){
				mensaje += "Error: No existe un departamento activo dado el id introducido";
				exito = "Error";
			} 
			else {
				mensaje += "Éxito al mostrar el sueldo de departamento ID: "+ Integer.toString(tDepartamento.getIdDepartamento());
				exito = "Exito";
				vistaDepartamento.setDepartamentoSueldo(tDepartamento);
			}
			vistaDepartamento.mensaje(mensaje, exito);
			
		break;
		}	
	}
}
