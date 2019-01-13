<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Professores</title>
<link href="/tcc/resources/css/estilo.css" rel="stylesheet">
</head>
<body style="background-image: url(http://luzdaserra.net/wp-content/uploads/2017/05/fundo-cinza.jpg)">
	<c:import url="../menu.jsp"></c:import>
	
	<h1 class="lista">Lista de Professores</h1>
	
	<table style="background-color: #FFFFFF">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Matricula</th>
				<th>Alterar</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="professor" items="${professores}">


				<tr>
					<td>${professor.nome}</td>
					<td>${professor.matricula}</td>
					<td><a href="/tcc/professores/selecionar?id=${professor.id}">Alterar</a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>