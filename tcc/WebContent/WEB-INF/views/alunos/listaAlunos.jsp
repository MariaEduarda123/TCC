<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Alunos</title>
</head>
<body>
	<c:import url="../menu.jsp"></c:import>

	<h1>Lista de Alunos</h1>

	<table border=1>
		<thead>
			<tr>
				<th>Nome</th>
				<th>Matrícula</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="aluno" items="${alunos}">

				
				<tr>

					<td>${aluno.nome}</td>
					<td>${aluno.matricula}</td>
				</tr>
			</c:forEach>
		</tbody>
</table>

</body>
</html>