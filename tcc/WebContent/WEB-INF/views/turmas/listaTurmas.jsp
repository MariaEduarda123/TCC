<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Turmas</title>
<link rel="stylesheet" type="text/css" href="/tcc/resources/css/estilo.css">
</head>
<body style="background-image: url(http://luzdaserra.net/wp-content/uploads/2017/05/fundo-cinza.jpg)">

	<c:import url="../menu.jsp"></c:import>

	<h1  class="lista">Lista de Turmas</h1>

	<table style="background-color: #FFFFFF">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Disciplina</th>
				<th>Professor</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="turma" items="${turmas}">

				
				<tr>

					<td>${turma.nome}</td>
					<td>${turma.disciplina.nome}</td>
					<td>${turma.professor.nome}</td>
				</tr>
			</c:forEach>
		</tbody>
</table>


</body>
</html>