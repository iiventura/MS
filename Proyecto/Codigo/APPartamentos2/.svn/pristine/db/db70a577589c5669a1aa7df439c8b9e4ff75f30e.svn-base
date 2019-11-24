package negocio.tipoVivienda;

import java.util.ArrayList;

import integracion.factoriaDAO.FactoriaDAO;
import integracion.factoriaQuery.FactoriaQuery;
import integracion.query.Query;
import integracion.tipoVivienda.DAOTipoVivienda;
import integracion.transaccion.Transaction;
import integracion.transaccion.manager.TransactionManager;



public class SATipoViviendaImp implements SATipoVivienda {

	@Override
	public int altaTipoVivienda(TTipoVivienda tTipoVivienda) throws Exception {
		int idErr;
		TTipoVivienda tVivAux;
        Transaction transaccionActual = null; 
        DAOTipoVivienda dao = FactoriaDAO.getInstancia().generarDAOTipoVivienda();
        
        try{
	        //El TM genera una nueva transaccion asociada a nuestra hebra de ejecucion
	        TransactionManager.getInstance().newTransaction(); 
	        //Obtenemos la transaccion dada nuestra hebra
	        transaccionActual = TransactionManager.getInstance().getTransaction();
	        //Empezamos la transaccion
	        transaccionActual.start();
	        
	        // Se busca la vivienda por direccion, para comprobar que no existe ya
	        tVivAux = dao.readByDireccion(tTipoVivienda.getDireccion());
	       
			
	        if (tVivAux == null){
	            idErr = dao.create(tTipoVivienda); // anadimos la vivienda a la bd
	            
	            if (idErr == 0){ 
	                idErr = -1;// error al añadir la vivienda en la base de datos
	                transaccionActual.rollback();
	            }        
	            else{ 
	            	transaccionActual.commit(); // dado de alta correctamente
	            }
	        }    
	        
	        else if (!tVivAux.getActivo()) {
	        	tVivAux = dao.read(tVivAux.getId());//tipo del tipo de vivienda
	        	
	        	if(tVivAux instanceof TPiso && tTipoVivienda instanceof TPiso){
	        		tVivAux.setActivo(true);
	        		tVivAux.setCantidad(tTipoVivienda.getCantidad());
	        		tVivAux.setCiudad(tTipoVivienda.getCiudad());
	        		tVivAux.setDireccion(tTipoVivienda.getDireccion());
	        		tVivAux.setPrecio(tTipoVivienda.getPrecio());
	        		((TPiso)tVivAux).setPortero(((TPiso)tTipoVivienda).getPortero());
	        		((TPiso)tVivAux).setNumAscensores(((TPiso)tTipoVivienda).getNumAscensores());
	        		idErr = dao.update(tVivAux); // actualizamos los valores de la vivienda
	        		
	        		if (idErr == 0){
		            	idErr = -2; //error al poner activo la vivienda dada de baja
		            	transaccionActual.rollback();                   
		            }
		            else {
		            	idErr = tVivAux.getId();
		            	transaccionActual.commit();             
		            }    
	        	}
	        	else if (tVivAux instanceof TChalet && tTipoVivienda instanceof TChalet){
	        		tVivAux.setActivo(true);
	        		tVivAux.setCantidad(tTipoVivienda.getCantidad());
	        		tVivAux.setCiudad(tTipoVivienda.getCiudad());
	        		tVivAux.setDireccion(tTipoVivienda.getDireccion());
	        		tVivAux.setPrecio(tTipoVivienda.getPrecio());
	        		((TChalet)tVivAux).setJardin(((TChalet)tTipoVivienda).getJardin());
	        		((TChalet)tVivAux).setPlantas(((TChalet)tTipoVivienda).getPlantas());
	        		idErr = dao.update(tVivAux); // actualizamos los valores de la vivienda
	        		
	        		if (idErr == 0){
		            	idErr = -2; //error al poner activo la vivienda dada de baja
		            	transaccionActual.rollback();                   
		            }
		            else {
		            	idErr = tVivAux.getId();
		            	transaccionActual.commit();             
		            }    
	        	} 
	        	else {
	        		idErr = -4;//error se está intentando dar de alta una vivienda con un tipo diferente
	        		transaccionActual.rollback();
	        	}        
	        } 
	        
	        else{
	                idErr = -3; // ya esta dado de alta
	                transaccionActual.rollback();
	        }
        }
        finally {
            TransactionManager.getInstance().deleteTransaction();        	
        }
        return idErr;
	}

	@Override
	public int bajaTipoVivienda(int id) throws Exception {
		int idErr;
		TTipoVivienda tVivAux;
        Transaction transaccionActual = null; 
        DAOTipoVivienda dao = FactoriaDAO.getInstancia().generarDAOTipoVivienda();
		
		try {
			//El TM genera una nueva transaccion asociada a nuestra hebra de ejecucion
	        TransactionManager.getInstance().newTransaction(); 
	        //Obtenemos la transaccion dada nuestra hebra
	        transaccionActual = TransactionManager.getInstance().getTransaction();
	        //Empezamos la transaccion
	        transaccionActual.start();
	        
			// Comprobamos si la vivienda introducida existe
	        tVivAux = dao.read(id);
	        if(tVivAux != null) {
        		if(tVivAux.getActivo()) {
        			tVivAux.setActivo(false); // Se desactiva la vivienda
    	        	idErr = dao.update(tVivAux); // Se actualiza la base de datos
    	        	
    	  
    	        	if(idErr == 0) {
    	        		idErr = -1; // Error en la base de datos al desactivarlo
    	        		transaccionActual.rollback();
    	        	} 
    	        	else {
    	        		idErr = tVivAux.getId(); // vivienda dada de baja correctamente
    	        		transaccionActual.commit();
    	        	}
        		}
        		else {
        			idErr = -2; // la vivienda ya está desactivado
	        		transaccionActual.rollback();
        		}
	        	
	        } 
	        else {
	        	idErr = -3; // la vivienda no existe
        		transaccionActual.rollback();
	        }
		}
		finally {
			TransactionManager.getInstance().deleteTransaction(); 
		}
		
		return idErr;
	}

	@Override
	public int modificarTipoVivienda(TTipoVivienda tTipoVivienda) throws Exception {
		int idErr;
		TTipoVivienda tVivDir;
        Transaction transaccionActual = null; 
        DAOTipoVivienda dao = FactoriaDAO.getInstancia().generarDAOTipoVivienda();
		
		try {
			//El TM genera una nueva transaccion asociada a nuestra hebra de ejecucion
	        TransactionManager.getInstance().newTransaction(); 
	        //Obtenemos la transaccion dada nuestra hebra
	        transaccionActual = TransactionManager.getInstance().getTransaction();
	        //Empezamos la transaccion
	        transaccionActual.start();
	        
	        tVivDir = dao.readByDireccion(tTipoVivienda.getDireccion());
	        
	        if(tVivDir != null) {
	        	if(tVivDir.getActivo()) {
	        		tVivDir = dao.read(tVivDir.getId());//tipo del tipo de vivienda
		        	
		        	if(tVivDir instanceof TPiso && tTipoVivienda instanceof TChalet || tVivDir instanceof TChalet && tTipoVivienda instanceof TPiso){
		        		idErr = -2; // El tipo vivienda no es del tipo indicado
	            		transaccionActual.rollback();
		        	}
		        	
		        	else{
		        		tVivDir.setActivo(true);
	        			tVivDir.setCantidad(tTipoVivienda.getCantidad());
	        			tVivDir.setCiudad(tTipoVivienda.getCiudad());
	        			tVivDir.setDireccion(tTipoVivienda.getDireccion());
	        			tVivDir.setPrecio(tTipoVivienda.getPrecio());
	        			
		        		if(tVivDir instanceof TPiso && tTipoVivienda instanceof TPiso){		        			
			        		((TPiso)tVivDir).setPortero(((TPiso)tTipoVivienda).getPortero());
			        		((TPiso)tVivDir).setNumAscensores(((TPiso)tTipoVivienda).getNumAscensores());   
			        	}
			        	else if (tVivDir instanceof TChalet && tTipoVivienda instanceof TChalet){			        		
			        		((TChalet)tVivDir).setJardin(((TChalet)tTipoVivienda).getJardin());
			        		((TChalet)tVivDir).setPlantas(((TChalet)tTipoVivienda).getPlantas());
			        	} 
		    	        idErr = dao.update(tVivDir); // Se cambian los datos del cliente
		    	        	
		    	        if(idErr == 0) {
		    	        	idErr = -1; // no se ha conseguido editar los datos
		    	        	transaccionActual.rollback();
		    	        } 
		    	        else {
		    	        	idErr = tVivDir.getId();// se han modificado los datos
		    	        	transaccionActual.commit();
		    	        }
		        	}
	        	}

        		else {
        			idErr = -3; // El tipo vivienda está dada de baja
            		transaccionActual.rollback();
        		}
	        } 
	        else {
	        	idErr = -4; // el tipo vivienda no existe
        		transaccionActual.rollback();
	        }
		}
		finally {
			TransactionManager.getInstance().deleteTransaction(); 
		}
		
		return idErr;
	}

	@Override
	public ArrayList<TTipoVivienda> listaTipoVivienda() throws Exception {
		ArrayList<TTipoVivienda> tVivAux;
        Transaction transaccionActual = null; 
        DAOTipoVivienda dao = FactoriaDAO.getInstancia().generarDAOTipoVivienda();
        
		try {
			//El TM genera una nueva transaccion asociada a nuestra hebra de ejecucion
	        TransactionManager.getInstance().newTransaction(); 
	        
	        //Obtenemos la transaccion dada nuestra hebra
	        transaccionActual = TransactionManager.getInstance().getTransaction();
	        
	        //Empezamos la transaccion
	        transaccionActual.start();
	        
			// Comprobamos si el tipoVivienda introducido existe
	        tVivAux = dao.list();
	        
	        
	        
	        // Hay tipoVivienda en la base de datos
	        if(tVivAux.size() > 0) {
        		transaccionActual.commit();
	        } 
	        // No hay usuarios en la base de datos
	        else {
        		transaccionActual.rollback();
	        }
		}
		finally {
			TransactionManager.getInstance().deleteTransaction(); 
		}
		
		return tVivAux;
	}

	@Override
	public TTipoVivienda mostrarTipoVivienda(int id) throws Exception {
		TTipoVivienda tVivAux;
        Transaction transaccionActual = null; 
        DAOTipoVivienda dao = FactoriaDAO.getInstancia().generarDAOTipoVivienda();
		
		try {
			//El TM genera una nueva transaccion asociada a nuestra hebra de ejecucion
	        TransactionManager.getInstance().newTransaction(); 
	        
	        //Obtenemos la transaccion dada nuestra hebra
	        transaccionActual = TransactionManager.getInstance().getTransaction();
	        
	        //Empezamos la transaccion
	        transaccionActual.start();
	        
			// Comprobamos si el tipoVivienda introducido existe
	        tVivAux = dao.read(id);
	        
	        // Existe el cliente en la base de datos
	        if(tVivAux != null && tVivAux.getActivo()) {
	        		transaccionActual.commit();	
	        } 
	        // No existe el cliente en la base de datos
	        else {
        		transaccionActual.rollback();
	        }
		}
		finally {
			TransactionManager.getInstance().deleteTransaction(); 
		}
		
		return tVivAux;
	}

	@Override
	public TTipoVivienda tviviendaMasVendido() throws Exception {
		Query q = null; 
		TTipoVivienda resAux=null;
		Transaction transaccionActual=null;
		
		
		try{
			//El TM genera una nueva transaccion asociada a nuestra hebra de ejecucion
			TransactionManager.getInstance().newTransaction();
			
			 //Obtenemos la transaccion dada nuestra hebra
	        transaccionActual = TransactionManager.getInstance().getTransaction();
	        
	        q = (Query) FactoriaQuery.getInstancia().newQuery("TipoViviendaMasVendido");
	        
	        if(q!=null){
	        	//Empezamos la transaccion
		        transaccionActual.start();
		        
		        resAux = (TTipoVivienda) q.execute(null);
		        
		     // Existe el cliente en la base de datos
		        if(resAux != null) {
	        		transaccionActual.commit();
		        } 
		        // No existe el cliente en la base de datos
		        else {
	        		transaccionActual.rollback();
		        }
	        	
	        }
		}
		finally {
			TransactionManager.getInstance().deleteTransaction(); 
		}
		
		return resAux;	
	}
}
