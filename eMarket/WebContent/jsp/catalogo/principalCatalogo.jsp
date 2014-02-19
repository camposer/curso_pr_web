<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="es.indra.formacion.pr.web.to.Producto" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Catálogo de Productos</title>
</head>
<body>
	<h1>Catálogo de Productos</h1>

	<%
	List<String> errores = (List<String>)session.getAttribute("errores");
	if (errores != null) { 
	%>
	<div style="border: 1px solid red">
		<ul>
		<%
			for (String error : errores) {
		%>
			<li><%= error %></li>
		<%
			}
		%>
		</ul>
	</div>
	<%
		session.removeAttribute("errores"); // Sino hago esto se queda en la sesión por los siglos de los siglos (hasta que borren las cookies)
	}
	%>
	<form method="post" action="<%= getServletContext().getContextPath() %>/catalogo/AgregarCatalogo">	
		<table>
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="nombre"/></td>
			</tr>
			<tr>
				<td>Precio:</td>
				<td><input type="text" name="precio"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Agregar"/></td>
			</tr>
		</table>
	</form>
	
	<table>
		<tr>
			<th>Nombre</th>
			<th>Precio</th>
			<th>Eliminar</th>
		</tr>
		<%
		List<Producto> productos = (List<Producto>)request.getAttribute("productos");
		if (productos != null) for (Producto p : productos) {
		%>
			<tr>
				<td><%= p.getNombre() %></td>
				<td><%= p.getPrecio() %></td>
				<td><a href="Eliminar?id=<%= p.getId() %>">eliminar</a></td>
			</tr>
		<%
		}
		%>
	</table>
</body>
</html>