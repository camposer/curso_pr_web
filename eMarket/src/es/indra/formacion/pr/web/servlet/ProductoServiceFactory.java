package es.indra.formacion.pr.web.servlet;

import es.indra.formacion.pr.web.service.IProductoService;
import es.indra.formacion.pr.web.service.ProductoService;

public abstract class ProductoServiceFactory {
	public static IProductoService createProductoService() {
		return new ProductoService();
	}
}
