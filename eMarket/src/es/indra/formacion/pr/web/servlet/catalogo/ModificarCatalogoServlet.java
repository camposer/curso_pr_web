package es.indra.formacion.pr.web.servlet.catalogo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.indra.formacion.pr.web.exception.EmarketServiceException;
import es.indra.formacion.pr.web.service.IProductoService;
import es.indra.formacion.pr.web.service.ProductoServiceFactory;
import es.indra.formacion.pr.web.to.Producto;

/**
 * Servlet implementation class ModificarCatalogoServlet
 */
// Ver en el descriptor de despliegue!!!
public class ModificarCatalogoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarCatalogoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IProductoService productoService = ProductoServiceFactory.createProductoService();
		
		request.setCharacterEncoding("utf-8");
		String[] sproductoIds = request.getParameterValues("productoId");
		String[] nombres = request.getParameterValues("nombre");
		String[] sprecios = request.getParameterValues("precio");
		
		for (int i = 0; i < nombres.length; i++) {
			System.out.println("nombre: " + nombres[i]);
			
			
			// TODO: Incluir validaciones!
			boolean valido = true; // El método de validación debería retornar un boolean que defina si hubo error o no
			
			if (valido) {
				Producto p = new Producto(
						nombres[i], 
						Float.parseFloat(sprecios[i])
					);
				p.setId(Integer.parseInt(sproductoIds[i]));
				
				try {
					productoService.modificarProducto(p);
				} catch (EmarketServiceException e) {
					e.printStackTrace();
				}
			}
		}
		
		response.sendRedirect("Principal");
	}

}
