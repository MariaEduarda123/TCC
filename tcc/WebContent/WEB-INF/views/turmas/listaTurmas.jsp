<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Turmas</title>
</head>
<body>

	<c:import url="../menu.jsp"></c:import>

	<h1>Lista de Turmas</h1>

	<table border=1>
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
					<td>${turma.disciplina}</td>
					<td>${turma.professor}</td>
				</tr>
			</c:forEach>
		</tbody>
</table>


</body>
</html>