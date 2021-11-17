<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Dados listados</title>
</head>
<body>

	<% List<String> lista = (List<String>)request.getAttribute("lista"); %>
	<table>
		<tr>
			<th>email</th>
			<th>Nome</th>
			<th>Peso</th>
			<th>Altura</th>
			<th>Gênero</th>
			<th>IMC</th>
			<th>Situação</th>
			<th>Peso ideal</th>
		</tr>
		<tr>
		<c:forEach items="${lista}" var = "item">
				<td><c:out value = "${(item)}"></c:out></td>
		</c:forEach>	
		<tr>
		
	</table>
</body>
</html>