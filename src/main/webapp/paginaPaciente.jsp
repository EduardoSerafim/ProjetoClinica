<%@page import="br.fiap.entidades.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Paciente</title>
<link rel="stylesheet" href="./styles/style.css">
<link rel="stylesheet" href="styles/formulario.css">
<link rel="stylesheet" href="styles/paciente.css">



</head>
<body>

	<div class="conteiner">
		<main>
			<h1>Paciente</h1>
			<form action="paciente" method="post">
				<hr>

				<p class="nm-usuario">
					Seja bem vindo(a) Sr.(a)
					<%Usuario usuario = (Usuario) request.getAttribute("usuario");%>
					<%=usuario.getNome()%>
				</p>


				
				<input type="text" name="altura" class="campo" placeholder="Altura(metros)"> 
				<input type="text"name="peso" class="campo" placeholder="Peso(quilos)"> 
				
				<div class="genero-form">
				<label for="genero" class="label-genero">Gênero</label>				
					<ul>
						<li>
							<input type="radio" name="genero" value="Feminino">
							<p>Feminino</p>
						</li>
						<li>
							<input type="radio" name="genero" value="masculino">
							<p>Masculino<p>
						</li>
					</ul>
				</div>

				<input type="hidden" value="<%=usuario.getEmail()%>" name="email">

				<input type="submit" value="Enviar dados" class="submit">



			</form>

			<form action="listar" method="post">
				<input type="hidden" value="<%=usuario.getEmail()%>" name="email">
				<input type="submit" value="Listar dados" class="submit">
			</form>

		</main>
	</div>



</body>
</html>