package integracion.factoriaQuery;

import integracion.query.Query;

public abstract class FactoriaQuery {
	private static FactoriaQuery factQ;

	public synchronized static FactoriaQuery getInstancia() {
		if(FactoriaQuery.factQ == null)
			return new FactoriaQueryImp(); 
		else
			return FactoriaQuery.factQ;
	}
	
	public abstract Query newQuery(String query);
}

