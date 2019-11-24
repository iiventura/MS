package presentacion.vistas.vistaModeloOrdenador;



import presentacion.controlador.Contexto;


public abstract class VistaModeloOrdenador {
private static VistaModeloOrdenador instancia;
	
	public static VistaModeloOrdenador getInstancia(){
		
		if(instancia==null){
			instancia=new VistaModeloOrdenadorImp();
		}
		
		return instancia;
	}

	public abstract void update(Contexto contexto);

}

