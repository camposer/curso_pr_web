package es.indra.formacion.pr.web.servlet.carrito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class PrincipalServlet
 */
@WebServlet(
		name = "PrincipalCarritoServlet",
		urlPatterns={"/carrito/Principal"}
)
public class PrincipalCarritoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrincipalCarritoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IProductoService productoService = ProductoServiceFactory.createProductoService();
		
		List<Producto> productos = new ArrayList<Producto>();
		try {
			productos = productoService.obtenerProductos();
		} catch (EmarketServiceException e) {
			e.printStackTrace();
		}

		request.setAttribute("productos", productos);
		
		getServletContext().getRequestDispatcher("/jsp/carrito/principal.jsp").forward(request, response);
	}

}
