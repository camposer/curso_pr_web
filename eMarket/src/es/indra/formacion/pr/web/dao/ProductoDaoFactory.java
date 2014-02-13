package es.indra.formacion.pr.web.dao;

public abstract class ProductoDaoFactory {
	public static IProductoDao createProductoDao() {
		return new ProductoDaoMockup();
	}
}
