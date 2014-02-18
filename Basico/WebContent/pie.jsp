<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- BEGIN: Pie -->
	<h2>Contextos</h2>
	<%
		if (nombre != null) {
			application.setAttribute("nombre", nombre);
			session.setAttribute("nombre", nombre);
			request.setAttribute("nombre", nombre);
			pageContext.setAttribute("nombre", nombre);
		}
	%>
	
	Falta config (debemos antes ver el descriptor de despliegue)<br/>
	Nombre en contexto: <%= application.getAttribute("nombre") %><br/>
	Nombre en sesión: <%= session.getAttribute("nombre") %><br/>
	Nombre en petición: <%= request.getAttribute("nombre") %><br/>
	Nombre en página: <%= pageContext.getAttribute("nombre") %><br/>
	
	
</body>
</html>

<!-- END: Pie -->