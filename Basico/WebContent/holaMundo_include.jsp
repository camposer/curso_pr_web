<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>

<%@ include file="cabecera.jsp" %>

<!-- BEGIN: Cuerpo -->

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

<!-- END: Cuerpo -->

<%@ include file="pie.jsp" %>