package es.indra.formacion.pr.web.service;


public abstract class ProductoServiceFactory {
	public static IProductoService createProductoService() {
		return new ProductoService();
	}
}
