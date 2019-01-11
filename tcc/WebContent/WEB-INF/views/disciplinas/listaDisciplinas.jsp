<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Disciplinas</title>
<link rel="stylesheet" type="text/css" href="css/css.css">
</head>
<body>
	<c:import url="../menu.jsp"></c:import>

	<h1>Lista de Disciplinas</h1>

	<table border=1>
		<thead>
			<tr>
				<th>Nome</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="disciplina" items="${disciplinas}">
				<tr>
					<td>${disciplina.nome}</td>
					<td><a href="/tcc/disciplinas/selecionar?id=${disciplina.id}">Alterar</a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>