package es.indra.formacion.pr.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MostrarServlet
 */
@WebServlet("/Mostrar")
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		getServletContext().getRequestDispatcher("/Cabecera").include(request, response);
		
		pw.println("Nombre: " + request.getAttribute("nombre") + "<br>");
		pw.println("Apellido: " + request.getAttribute("apellido"));

		getServletContext().getRequestDispatcher("/Pie").include(request, response);
		
		pw.flush();
	}

}
