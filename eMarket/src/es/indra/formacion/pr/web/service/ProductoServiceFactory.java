package es.indra.formacion.pr.web.service;

public abstract class ProductoServiceFactory {
	private static IProductoService instance = null;
	
	public static IProductoService createProductoService() {
		if (instance == null)
			instance = new ProductoService();
		
		return instance;
	}
}