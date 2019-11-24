package integracion.factoriaQuery;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


import integracion.query.Query;


public class FactoriaQueryImp extends FactoriaQuery {

	@Override
	public Query newQuery(String query) {
		FileInputStream fis;
		Properties propQueries = new Properties();
		String className; 
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Query q = null; 
		try {
			fis = new FileInputStream(new File("config/queries.properties"));
			propQueries.load(fis);
			className = propQueries.getProperty(query);
			if(className != null) {
				Class<?> c = loader.loadClass(className);
				Class.forName(className);
				q = (Query) c.newInstance();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return q;
	}

}
