package es.indra.formacion.pr.web.servlet.carrito;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.indra.formacion.pr.web.to.Producto;

/**
 * Servlet implementation class CarritoServlet
 */
@WebServlet("/carrito/Mostrar")
public class MostrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		
		Map<Integer, Producto> productos = (Map<Integer, Producto>) sesion.getAttribute("productos");
		
		if (productos == null) {
			response.sendRedirect("Principal"); // Esta es una URL relativa, si fuese absoluta tendría que ser: /eMarket/carrito/Principal		
			return;
		}

		// TODO: Incluir validaciones!
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("	<head>");
		pw.println("		<meta charset='utf-8'>");
		pw.println("		<title>Tienda de artículos electrónicos</title>");
		pw.println("		<link rel='stylesheet' type='text/css' href='../css/estilos.css'>");
		pw.println("		<link rel='stylesheet' type='text/css' href='../css/carrito.css'>");
		pw.println("	</head>");
		pw.println("	<body>");
		pw.println("		<h1>Tienda de artículos electrónicos</h1>");
		pw.println("		<form>");
		pw.println("			<table id='tablaCarrito' class='tabla'>");
		pw.println("				<tr>");
		pw.println("					<th>Artículo</th>");
		pw.println("					<th>Precio</th>");
		pw.println("					<th>Cantidad</th>");
		pw.println("					<th>Precio</th>");
		pw.println("				</tr>");

		float totalTotal = 0;
		for (Integer key : productos.keySet()) {
			Producto p = productos.get(key);
			
			pw.println("				<tr>");
			pw.println("					<td>" + p.getNombre() + "</td>");
			pw.println("					<td>" + p.getPrecio() + " €</td>");
			pw.println("					<td><input type='text' name='cantidad' maxlength='3'  value='" + p.getCantidad() + "' ></td>");
			pw.println("					<td><input type='text' name='precio' value='" + p.getTotal() + "' readonly></td>");
			pw.println("				</tr>");
			
			totalTotal += p.getTotal();
		}
		
		pw.println("				<tr class='total'>");
		pw.println("					<td colspan='3'>Total</td>");
		pw.println("					<td><input type='text' name='total' value='" + totalTotal + "'readonly></td>");
		pw.println("				</tr>");
		pw.println("				<tr>");
		
		pw.println("					<td colspan='4'>");
		pw.println("						<input type='button' value='Atrás' onclick='javascript:window.history.back()'>");
		pw.println("						<input type='button' value='Comprar'>");
		pw.println("					</td>");
		pw.println("				</tr>");
		pw.println("			</table>");
		pw.println("		</form>");
		pw.println("	</body>");
		pw.println("</html>");

		pw.flush();

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
}
