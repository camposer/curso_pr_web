<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hola Mundo!</title>
</head>
<body>
	<h1>Hola Mundo</h1>
	Hola: <%= request.getParameter("nombre") %><br/>
	
	<% Date fecha = new Date(); %>
	
	La fecha de hoy es: <%= fecha %><br/>
	La fecha de hoy es: <% out.println(fecha); %><br/>
	<%= "La fecha de hoy es: " + fecha + "<br/>" %>

	<br/>
	
	<table border="1">
		<% 
			String[] nombres = new String[] { "uno", "dos", "tres" };  
			for (String n : nombres) {
				if (n.equals("uno")) {
		%>
			<tr><td><font color="red"><%= n %></font></td></tr>
		<%
				} else {
		%>
			<tr><td><%= n %></td></tr>
		<%
				}
			} // Cierra el for
		%>
	</table>
	
	<h2>Contextos</h2>
	<%
		String nombre = request.getParameter("nombre");
					
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