package integracion.compra;

import java.util.ArrayList;

import negocio.compra.TCompra;
import negocio.compra.TLineaCompra;

public interface DAOCompra {
	public int create(TCompra t) throws Exception;
	public int update(TCompra t) throws Exception;
	public TCompra read(int id) throws Exception;
	public TLineaCompra readByIdLineaCompra(int idCompra, int idTipoVivienda) throws Exception;
	public ArrayList<TCompra> list() throws Exception;
	public boolean insertLineaCompra(int idCompra, TLineaCompra tLineaCompra) throws Exception;
	public int updateLineaCompra(int idCompra, double precioVivienda, TLineaCompra tLineaCompra) throws Exception;
}
