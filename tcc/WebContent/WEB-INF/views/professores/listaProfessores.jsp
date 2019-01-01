<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Professores</title>
<link rel="stylesheet" type="text/css" href="css/css.css">
</head>
<body>

		<c:import url="../menu.jsp"></c:import>
	<table border=1>
			<thead>
				<tr>
					<th>Nome</th>
					<th>Matricula</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="professor" items="${professores}">
	
					
					<tr>
						<td>${professor.nome}</td>
						<td>${professor.matricula}</td>
					</tr>
				</c:forEach>
			</tbody>
	</table>

</body>
</html>