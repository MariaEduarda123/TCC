<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Alunos</title>
</head>
<body>

	<h1>Lista de Alunos</h1>

	<table border=1>
		<thead>
			<tr>
				<th>Nome</th>
				<th>Matrícula</th>
				<th>Turma</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="aluno" items="${alunos}">

				
				<tr>

					<td>${aluno.nome}</td>
					<td>${aluno.matricula}</td>
					<td>${aluno.turma}</td>
				</tr>
			</c:forEach>
		</tbody>
</table>

</body>
</html>