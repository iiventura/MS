package negocio.compra;

import java.util.ArrayList;
import integracion.cliente.DAOCliente;
import integracion.compra.DAOCompra;
import integracion.factoriaDAO.FactoriaDAO;
import integracion.tipoVivienda.DAOTipoVivienda;
import integracion.transaccion.Transaction;
import integracion.transaccion.manager.TransactionManager;
import negocio.cliente.TCliente;
import negocio.tipoVivienda.TTipoVivienda;


public class SACompraImp implements SACompra {

	@Override
	public int altaCompra(TCompra tCompra) throws Exception {
		int idErr = 0;
		TCliente cliAux = null;
		TTipoVivienda vivAux = null;
        Transaction transaccionActual = null; 
        DAOCompra dao = FactoriaDAO.getInstancia().generarDAOCompra();
        DAOCliente daoCli = FactoriaDAO.getInstancia().generarDAOCliente();
        DAOTipoVivienda daoTViv = FactoriaDAO.getInstancia().generarDAOTipoVivienda();

        try{
	        //El TM genera una nueva transaccion asociada a nuestra hebra de ejecucion
	        TransactionManager.getInstance().newTransaction(); 
	        //Obtenemos la transaccion dada nuestra hebra
	        transaccionActual = TransactionManager.getInstance().getTransaction();
	        //Empezamos la transaccion
	        transaccionActual.start();
	        
	        if(tCompra.getIdCompra() == -1) {
	        	// Alta de compra nueva
	        	cliAux = daoCli.read(tCompra.getIdCliente());
	        	
	        	if(cliAux == null) {
		        	idErr = -4; // No existe el cliente en la bd
		        	transaccionActual.rollback();
		        } else if (!cliAux.getActivo()) {
		        	idErr = -3; // El cliente no está activo
		        	transaccionActual.rollback();
		        } else {
		        	for(TLineaCompra lc : tCompra.getLineaCompra().values()) {
		        		vivAux = daoTViv.read(lc.getId());
		        		
		        		if(!vivAux.getActivo()) {
		        			idErr = -7; // tipovivienda dado de baja
			 	            transaccionActual.rollback();
		        		}
		        		else if(vivAux.getCantidad() < lc.getCantidadComprada()){
		        			idErr = -6; // tipovivienda no tiene suficientes viviendas
		        			transaccionActual.rollback();
		        		}
		        		else {
		        			vivAux.setCantidad(vivAux.getCantidad() - lc.getCantidadComprada());
		        			//TODO
		        			if(daoTViv.update(vivAux) == 0) {
			        			idErr = -8; // error al actualizar la cantidad de viviendas
			        			transaccionActual.rollback();
		        			}
		        		}
		        	}
		        	
		        	if(idErr == 0) {
			        	idErr = dao.create(tCompra); // añadimos la compra a la bd
			 	         
			 	        if (idErr == 0){ 
			 	            idErr = -5;// error al añadir compra en la base de datos
			 	            transaccionActual.rollback();
			 	        } 
			 	        else{
			 	        	for(TLineaCompra lc : tCompra.getLineaCompra().values()){
				        		dao.insertLineaCompra(idErr, lc);			        		
							}
				        	transaccionActual.commit();
			 	        } 
		        	}
		        }
	        } /*else {
	        	// Reactivación de compra
	        	tComAux = dao.read(tCompra.getIdCompra());
	        	
	        	if(tComAux == null) {
        			idErr = -2; // La compra no existe
        			transaccionActual.rollback();	        		
	        	} else {
	        		if(tComAux.getActivo()) {
	        			idErr = -1; // La compra ya está activa
	        			transaccionActual.rollback();
	        		} else {
	        			tComAux.setActivo(true);
	        			dao.update(tComAux);
	        			idErr = tComAux.getIdCompra();
	        			transaccionActual.commit();
	        		}
	        	}
	        }*/     
        }
        finally {
            TransactionManager.getInstance().deleteTransaction();        	
        }
        
        return idErr;
	}

	@Override
	public int bajaCompra(int id) throws Exception {
		int idErr = 0;
		TCompra tComAux;
		Transaction transaccionActual = null; 
		DAOCompra dao = FactoriaDAO.getInstancia().generarDAOCompra();
		
		try {
			//El TM genera una nueva transaccion asociada a nuestra hebra de ejecucion
	        TransactionManager.getInstance().newTransaction(); 
	        //Obtenemos la transaccion dada nuestra hebra
	        transaccionActual = TransactionManager.getInstance().getTransaction();
	        //Empezamos la transaccion
	        transaccionActual.start();
	        
			// Comprobamos si el usuario introducido existe
	        tComAux = dao.read(id);
	        if(tComAux != null) {
        		if(tComAux.getActivo()) {
        			tComAux.setActivo(false); // Se desactiva la compra
    	        	idErr = dao.update(tComAux); // Se actualiza la base de datos
    	        	
    	        	if(idErr == 0) {
    	        		idErr = -1; // Error en la base de datos al desactivarlo
    	        		transaccionActual.rollback();
    	        	} 
    	        	else {
    	        		idErr = tComAux.getIdCompra(); //Compra dada de baja correctamente
    	        		transaccionActual.commit();
    	        	}
        		}
        		else {
        			idErr = -2; // La compra ya está desactivada
	        		transaccionActual.rollback();
        		}
	        	
	        } 
	        else {
	        	idErr = -3; // La compra no existe
        		transaccionActual.rollback();
	        }
		}
		finally {
			TransactionManager.getInstance().deleteTransaction(); 
		}
		
		return idErr;
	}

	@Override
	public int anadirViviendasACompraCerrada(TCompra tCompra) throws Exception {
		int idErr = 0;
		TCompra tComAux;
		TCliente cliAux = null;
		TTipoVivienda vivAux = null;
		TLineaCompra lineaCompra = null;
		Transaction transaccionActual = null; 
		DAOCompra dao = FactoriaDAO.getInstancia().generarDAOCompra();
		DAOCliente daoCli = FactoriaDAO.getInstancia().generarDAOCliente();
		DAOTipoVivienda daoViv = FactoriaDAO.getInstancia().generarDAOTipoVivienda();
		
		try {
			//El TM genera una nueva transaccion asociada a nuestra hebra de ejecucion
	        TransactionManager.getInstance().newTransaction(); 
	        //Obtenemos la transaccion dada nuestra hebra
	        transaccionActual = TransactionManager.getInstance().getTransaction();
	        //Empezamos la transaccion
	        transaccionActual.start();
	        
			tComAux = dao.read(tCompra.getIdCompra());

			if (tComAux != null) {
				if (tComAux.getActivo()) {
					cliAux = daoCli.read(tComAux.getIdCliente());
					
					if(!cliAux.getActivo()){
			        	idErr = -3; //  El cliente está dado de baja
			        	transaccionActual.rollback();
			        }
					else{
						boolean falloActivo = false;
						boolean falloCantidad = false;
						for(TLineaCompra lc : tCompra.getLineaCompra().values()){
							vivAux = daoViv.read(lc.getId());
							if(!vivAux.getActivo()){
								falloActivo = true;
							}
							
							else if(vivAux.getCantidad() < lc.getCantidadComprada()){
			        			falloCantidad = true;
			        		}
						}
						
						if(falloActivo){
							idErr = -8; //  Error la vivienda está dada de baja
				        	transaccionActual.rollback();	
				        	
						}
						else if(falloCantidad){
							idErr = -9; //  Error no hay cantidad suficiente
				        	transaccionActual.rollback();	
						}
						else{
				        	for(TLineaCompra lc : tCompra.getLineaCompra().values()){
				        		lineaCompra = dao.readByIdLineaCompra(tCompra.getIdCompra(), lc.getId());
				        		
				        		if(lineaCompra == null){
				        			//No existe, la añadimos a esa compra
				        			dao.insertLineaCompra(tCompra.getIdCompra(), lc);

				        		}
				        		else{
				        			//Ya existe, la actualizamos
				        			vivAux = daoViv.read(lc.getId());		        			
				        			int err = dao.updateLineaCompra(tCompra.getIdCompra(), vivAux.getPrecio(), lc);
				        			
				        			if(err == 0){
				        				idErr = -10; //  Error al actualizar
							        	transaccionActual.rollback();
				        			}
				        		}
				        		
				        		vivAux = daoViv.read(lc.getId());
				        		vivAux.setCantidad(vivAux.getCantidad() - lc.getCantidadComprada());
				        		daoViv.update(vivAux);
				        		
				        		idErr = tCompra.getIdCompra();
				        		
				        		transaccionActual.commit();
							}
						}
					}
				} else {
					idErr = -2; // La compra estaba desactivado
					transaccionActual.rollback();
				}
			} else {
				idErr = -4; // la compra no existe
				transaccionActual.rollback();
			}
		}
		finally {
			TransactionManager.getInstance().deleteTransaction(); 
		}
		
		return idErr;
	}

	@Override
	public ArrayList<TCompra> listaCompra() throws Exception {
		ArrayList<TCompra> tComAux;
		Transaction transaccionActual = null; 
		DAOCompra dao = FactoriaDAO.getInstancia().generarDAOCompra();
		//**
		
		
		try {
			//El TM genera una nueva transaccion asociada a nuestra hebra de ejecucion
	        TransactionManager.getInstance().newTransaction(); 
	        
	        //Obtenemos la transaccion dada nuestra hebra
	        transaccionActual = TransactionManager.getInstance().getTransaction();
	        
	        //Empezamos la transaccion
	        transaccionActual.start();
	        
			// Comprobamos si la compra introducido existe
	        tComAux = dao.list();	        	        
	        
	        // Hay compra en la base de datos
	        if(tComAux.size() > 0) {
        		transaccionActual.commit();
	        } 
	        // No hay compra en la base de datos
	        else {
        		transaccionActual.rollback();
	        }
		}
		finally {
			TransactionManager.getInstance().deleteTransaction(); 
		}
		
		return tComAux;
	}

	@Override
	public TCompra mostrarCompra(int id) throws Exception {
		TCompra tComAux;
		Transaction transaccionActual = null; 
		DAOCompra dao = FactoriaDAO.getInstancia().generarDAOCompra();
		
		try {
			//El TM genera una nueva transaccion asociada a nuestra hebra de ejecucion
	        TransactionManager.getInstance().newTransaction(); 
	        
	        //Obtenemos la transaccion dada nuestra hebra
	        transaccionActual = TransactionManager.getInstance().getTransaction();
	        
	        //Empezamos la transaccion
	        transaccionActual.start();
	        
			// Comprobamos si el usuario introducido existe
	        tComAux = dao.read(id);
	        
	        // Existe la compra en la base de datos
	        if(tComAux != null) {
        		transaccionActual.commit();
	        } 
	        // No existe la compra en la base de datos
	        else {
        		transaccionActual.rollback();
	        }
		}
		finally {
			TransactionManager.getInstance().deleteTransaction(); 
		}
		
		return tComAux;
	}

	
}
