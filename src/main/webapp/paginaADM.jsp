<%@page import="br.fiap.dao.PacienteDAO"%>
<%@page import="java.util.List"%>
<%@page import="br.fiap.dao.UsuarioDAO"%>
<%@page import="br.fiap.entidades.Usuario"%>
<%@page import="br.fiap.entidades.Paciente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADM</title>
</head>
<body>
	<h1>Pagina administrativa</h1>
	<h2>
		Seja bem vindo(a) 
		<% Usuario usuario = (Usuario)request.getAttribute("usuario"); %>
		<%= usuario.getNome() %>
	</h2>
	<h2>
		Tipo de usuário: 
		<%=usuario.getTipoDeUsuario() %>
	</h2>
	
	<% 
		
		List<Usuario> listaUsuario = (List<Usuario>)request.getAttribute("listaUsuario"); 
		PacienteDAO daoPaciente = new PacienteDAO();
		List<Paciente> listaPaciente= (List<Paciente>)request.getAttribute("listaPaciente");
		
		
	%>
	
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
		
		
		<c:forEach items="${listaUsuario}" var = "item">
			<tr>
				<td><c:out value = "${item.getEmail()}"></c:out></td>				
				<td><c:out value = "${item.getNome()}"></c:out></td>	
							
				
					
				<c:forEach items="${listaPaciente}" var = "item2">
					<c:if test="${item.getEmail().equals(item2.getEmail())}">
						<td><c:out value = "${item2.getPeso()}"></c:out></td>				
						<td><c:out value = "${item2.getAltura()}"></c:out></td>
						<td><c:out value = "${item2.getGenero()}"></c:out></td>
						<td><c:out value = "${item2.imc()}"></c:out></td>
						<td><c:out value = "${item2.situacao()}"></c:out></td>
						<td><c:out value = "${item2.pesoIdeal()}"></c:out></td>
					</c:if>
					
				</c:forEach>				
			</tr>
		</c:forEach>	
		
		
	</table>
	
</body>
</html>