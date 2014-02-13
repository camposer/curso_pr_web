package es.indra.formacion.pr.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CarritoServlet
 */
@WebServlet("/Carrito")
public class CarritoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarritoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("	<head>");
		pw.println("		<meta charset='utf-8'>");
		pw.println("		<title>Tienda de artículos electrónicos</title>");
		pw.println("		<link rel='stylesheet' type='text/css' href='css/estilos.css'>");
		pw.println("		<link rel='stylesheet' type='text/css' href='css/carrito.css'>");
		pw.println("	</head>");
		pw.println("	<body>");
		pw.println("		<h1>Tienda de artículos electrónicos</h1>");
		pw.println("		<form action='carrito.html' method='post'>");
		pw.println("			<table id='tablaCarrito' class='tabla'>");
		pw.println("				<tr>");
		pw.println("					<th>Artículo</th>");
		pw.println("					<th>Precio</th>");
		pw.println("					<th>Cantidad</th>");
		pw.println("					<th>Precio</th>");
		pw.println("				</tr>");
		pw.println("				<tr>");
		pw.println("					<td>Portátiles</td>");
		pw.println("					<td>599 €</td>");
		pw.println("					<td><input type='text' name='cantidad' maxlength='3'></td>");
		pw.println("					<td><input type='text' name='precio' readonly></td>");
		pw.println("				</tr>");
		pw.println("				<tr>");
		pw.println("					<td>Cámaras</td>");
		pw.println("					<td>230 €</td>");
		pw.println("					<td><input type='text' name='cantidad' maxlength='3'></td>");
		pw.println("					<td><input type='text' name='precio' readonly></td>");
		pw.println("				</tr>");
		pw.println("				<tr>");
		pw.println("					<td>DVD</td>");
		pw.println("					<td>60 €</td>");
		pw.println("					<td><input type='text' name='cantidad' maxlength='3'></td>");
		pw.println("					<td><input type='text' name='precio' readonly></td>");
		pw.println("				</tr>");
		pw.println("				<tr class='total'>");
		pw.println("					<td colspan='3'>Total</td>");
		pw.println("					<td><input type='text' name='total' readonly></td>");
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
