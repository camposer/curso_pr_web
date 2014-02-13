package es.indra.formacion.pr.web.servlet;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.indra.formacion.pr.web.exception.EmarketServiceException;
import es.indra.formacion.pr.web.service.IProductoService;
import es.indra.formacion.pr.web.service.ProductoService;
import es.indra.formacion.pr.web.to.Producto;

/**
 * Servlet implementation class PrincipalServlet
 */
@WebServlet("/Principal")
public class PrincipalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrincipalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IProductoService productoService = new ProductoService();
		
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("	<head>");
		pw.println("		<meta charset='utf-8'>");
		pw.println("		<title>Tienda de artículos electrónicos</title>");
		pw.println("		<link rel='stylesheet' type='text/css' href='css/estilos.css'>");
		pw.println("		<link rel='stylesheet' type='text/css' href='css/principal.css'>");
		pw.println("	</head>");
		pw.println("	<body>");
		pw.println("		<h1>Tienda de artículos electrónicos</h1>");
		pw.println("		<form action='Carrito' method='post'>");
		pw.println("			<table id='tablaArticulo' class='tabla'>");
		pw.println("				<tr>");
		pw.println("					<th>Artículo</th>");
		pw.println("					<th>Precio</th>");
		pw.println("					<th>Cantidad</th>");
		pw.println("				</tr>");
		
		List<Producto> productos = new ArrayList<Producto>();
		try {
			productos = productoService.obtenerProductos();
		} catch (EmarketServiceException e) {
			e.printStackTrace();
		}
		
		for (Producto p : productos) {
			pw.println("				<tr>");
			pw.println("					<td>" + p.getNombre() + "</td>");
			pw.println("					<td>" + p.getPrecio() + " €</td>");
			pw.println("					<td><input type='text' name='cantidad' maxlength='3' value='0'>"
					+ "<input type='hidden' name='productoId' value='" +  p.getId() + "'>"
					+ "</td>");
			pw.println("				</tr>");
		}
		
		pw.println("				<tr>");
		pw.println("					<td colspan='3'>");
		pw.println("						<input type='reset' value='Borrar'>");
		pw.println("						<input type='submit' value='Agregar al carrito'>");
		pw.println("						<input type='button' value='Ver carrito' onclick='javascript:window.location.href=\"Carrito\";'>");
		pw.println("					</td>");
		pw.println("				</tr>");
		pw.println("			</table>");
		pw.println("		</form>");
		pw.println("	</body>");
		pw.println("</html>");
		
		pw.flush();
	}

}
