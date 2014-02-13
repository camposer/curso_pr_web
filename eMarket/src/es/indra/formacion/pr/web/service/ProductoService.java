package es.indra.formacion.pr.web.service;

import java.util.List;

import es.indra.formacion.pr.web.dao.IProductoDao;
import es.indra.formacion.pr.web.dao.ProductoDaoFactory;
import es.indra.formacion.pr.web.exception.EmarketDaoException;
import es.indra.formacion.pr.web.exception.EmarketServiceException;
import es.indra.formacion.pr.web.to.Producto;

class ProductoService implements IProductoService {
	private IProductoDao productoDao = ProductoDaoFactory.createProductoDao();
	
	@Override
	public void agregarProducto(Producto p) throws EmarketServiceException {
		try {
			productoDao.agregar(p);
		} catch (EmarketDaoException e) {
			throw new EmarketServiceException("Error al agregar Producto: " + p, e); 
		}
	}

	@Override
	public List<Producto> obtenerProductos() throws EmarketServiceException {
		try {
			return productoDao.obtenerTodos();
		} catch (EmarketDaoException e) {
			throw new EmarketServiceException("Error al obtener Productos", e); 
		}
	}

	@Override
	public Producto obtenerProducto(Integer id) throws EmarketServiceException {
		try {
			return productoDao.obtener(id);
		} catch (EmarketDaoException e) {
			throw new EmarketServiceException("Error al obtener el Producto con id = " + id, e); 
		}
	}

}
