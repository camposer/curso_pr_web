package es.indra.formacion.pr.web.dao;

import java.util.List;

import es.indra.formacion.pr.web.exception.EmarketDaoException;
import es.indra.formacion.pr.web.to.Producto;

public interface IProductoDao {
	public List<Producto> obtenerTodos() throws EmarketDaoException;
	public void agregar(Producto p) throws EmarketDaoException;
	public Producto obtener(Integer id) throws EmarketDaoException;
}
