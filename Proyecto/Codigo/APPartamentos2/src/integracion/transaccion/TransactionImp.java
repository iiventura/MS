package integracion.transaccion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class TransactionImp implements Transaction{
	private Connection connection;

	@Override
	public void start() throws Exception {		
		try{

			connection = null;
			connection = DriverManager.getConnection("jdbc:mysql://localhost/apartamentos","root", "");
			connection.setAutoCommit(false);
			System.out.print("Database is connected !");
		}
		catch(SQLException e){
			throw new SQLException("Error al iniciar la transacción");
		}
		
	}

	@Override
	public void commit() throws Exception {
		try {
			this.connection.commit();
			this.connection.close();
		} catch (SQLException e) {
			throw new SQLException("Error al confirmar los cambios realizados por la transacción");
		}
	}

	@Override
	public void rollback() throws Exception {
		try {
			this.connection.rollback();
			this.connection.close();
		} catch (SQLException e) {
			throw new SQLException("Error al cancelar los cambios realizados por la transacción");
		}
	}

	@Override
	public Connection getResource() {
		return connection;
	}

}
