<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
	// Este método es definido dentro del Servlet (fuera del método service!)
	public void saludar(String mensaje, JspWriter out) {
		try {
			out.println("Hola: " + mensaje);
		} catch(Exception e) {}
	}

	public String saludo(String mensaje) {
		return "Hola: " + mensaje;
	}
%>
<!-- BEGIN: Cabecera -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hola Mundo!</title>
</head>
<body>
	<h1>Hola Mundo</h1>
	<% String nombre = request.getParameter("nombre"); %>	
	Hola: <%= nombre %><br/>
	<% 
		saludar(nombre, out);
	%><br/>
	<%= saludo(nombre) %><br/>
<!-- END: Cabecera -->
	