<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
				</tr>
			</c:forEach>
		</tbody>
</table>

</body>
</html>