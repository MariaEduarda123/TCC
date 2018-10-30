<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Professores</title>
</head>
<body>

	<table border=1>
		<thead>
			<tr>
				<th>Nome</th>
				<th>Matricula</th>
				<th>Turma</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="professor" items="${professores}">

				
				<tr>

					<td>${professor.nome}</td>
					<td>${professor.matricula}</td>
					<td>${professor.turma}</td>
				</tr>
			</c:forEach>
		</tbody>
</table>

</body>
</html>