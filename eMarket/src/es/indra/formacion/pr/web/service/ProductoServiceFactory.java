package es.indra.formacion.pr.web.service;


public abstract class ProductoServiceFactory {
	private static IProductoService INSTANCE = null;
	
	public static IProductoService createProductoService() {
		if (INSTANCE == null)
			INSTANCE = new ProductoService();
		
		return INSTANCE;
	}
}
