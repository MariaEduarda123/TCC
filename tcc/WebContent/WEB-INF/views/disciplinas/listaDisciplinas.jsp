<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Disciplinas</title>
<link rel="stylesheet" type="text/css" href="/tcc/resources/css/estilo.css">
</head>
<body style="background-image: url(http://luzdaserra.net/wp-content/uploads/2017/05/fundo-cinza.jpg)">
	<c:import url="../menu.jsp"></c:import>

	<h1 class="lista">Lista de Disciplinas</h1>

	<table style="background-color: #FFFFFF">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Alterar</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="disciplina" items="${disciplinas}">
				<tr>
					<td>${disciplina.nome}</td>
					<td><a href="/tcc/disciplinas/selecionarDisciplina?id=${disciplina.id}">Alterar</a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>