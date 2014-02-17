package es.indra.formacion.pr.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProcesarContextosServlet
 */
@WebServlet(
		urlPatterns = { "/ProcesarContextos" }, 
		initParams = { 
			@WebInitParam(name = "PARAM1", value = "Bien"), 
			@WebInitParam(name = "PARAM2", value = "Muy bien"),
			@WebInitParam(name = "PARAM3", value = "Otro valor")
		}
)
public class ProcesarContextosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcesarContextosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig config = getServletConfig();
		ServletContext context = getServletContext();
		HttpSession session = request.getSession();

		String nombre = request.getParameter("paramnombre");
		
		if (nombre != null && !nombre.trim().equals("")) {
			context.setAttribute("nombre1", nombre);
			session.setAttribute("nombre2", nombre);
			request.setAttribute("nombre3", nombre);
		}
		
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<head></head>");
		pw.println("<body>");
		pw.println("Parámetro del config (PARAM1): " + config.getInitParameter("PARAM1") + "<br>");
		pw.println("Parámetro del config (PARAM2): " + config.getInitParameter("PARAM2") + "<br>");
		pw.println("Parámetro del contexto (nombre1): " + context.getAttribute("nombre1") + "<br>");
		pw.println("Parámetro de la sesión (nombre2): " + session.getAttribute("nombre2") + "<br>");
		pw.println("Parámetro de la petición (nombre3): " + request.getAttribute("nombre3") + "<br>");
		pw.println("</body>");
		pw.println("</html>");
		pw.flush();


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
