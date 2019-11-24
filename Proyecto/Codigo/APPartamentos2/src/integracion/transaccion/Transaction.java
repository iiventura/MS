package integracion.transaccion;

public interface Transaction {

	public abstract void start() throws Exception;
	public abstract void commit() throws Exception;
	public abstract void rollback() throws Exception;
	public abstract Object getResource();
}
