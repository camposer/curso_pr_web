package es.indra.formacion.pr.web.servlet.carrito;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.indra.formacion.pr.web.exception.EmarketServiceException;
import es.indra.formacion.pr.web.service.IProductoService;
import es.indra.formacion.pr.web.service.ProductoServiceFactory;
import es.indra.formacion.pr.web.to.Producto;

/**
 * Servlet implementation class CarritoServlet
 */
@WebServlet("/carrito/Agregar")
public class AgregarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AgregarServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		IProductoService productoService = ProductoServiceFactory
				.createProductoService();

		HttpSession sesion = request.getSession();

		String[] scantidades = request.getParameterValues("cantidad");
		String[] sproductoIds = request.getParameterValues("productoId");

		// Validar si el producto ya existe en la sesión
		Object obj = sesion.getAttribute("productos");
		Map<Integer, Producto> productos = null;

		if (obj == null) {
			productos = new Hashtable<Integer, Producto>();
			sesion.setAttribute("productos", productos);
		} else {
			productos = (Map<Integer, Producto>) obj;
		}

		for (int i = 0; i < sproductoIds.length; i++) {
			Integer id = Integer.parseInt(sproductoIds[i]);
			Integer cantidad = Integer.parseInt(scantidades[i]);

			if (cantidad > 0) { // Están agregando un producto
				Producto prod = productos.get(id);

				if (prod == null) { // Debo agregar el producto
					try {
						Producto p = productoService.obtenerProducto(id); // Buscando el producto

						if (p == null) // SI el producto no existe ignoralo
							continue;

						// Clonando objeto
						prod = new Producto();
						prod.setId(p.getId());
						prod.setNombre(p.getNombre());
						prod.setPrecio(p.getPrecio());
						prod.setCantidad(cantidad);

						productos.put(p.getId(), prod); // Agregando al hashtable
					} catch (EmarketServiceException e) {
						e.printStackTrace();
					}
				} else { // Modifico la cantidad del producto
					prod.setCantidad(cantidad + prod.getCantidad()); // Este dato está en la sesión
				}
			}
		}
		
		//getServletContext().getRequestDispatcher("/carrito/Mostrar").forward(request, response); // Se especifica el mapping!
		response.sendRedirect("Mostrar");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

}
