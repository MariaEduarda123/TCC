<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alterar Professor</title>
</head>
<body>

	<c:import url="../menu.jsp"></c:import>

	<h1>Alterar Turma</h1>
	<form action="/tcc/professores/alterar" method="post">

		<div>
			<label>ID: <input readonly="readonly" type="hidden" name="id"
				value="${professor.id }"></label>
		</div>

		<div>
			<label>Nome: <input type="text" name="nome"
				value="${turma.nome }"></label>
		</div>
		<div>
			<select name="disciplina.id">
				<option value="${turma.disciplina.nome }"></option>
				<c:forEach var="disciplina" items="${disciplinas}">
					<option value="${turma.disciplina.id }">${turma.disciplina.nome }</option>
				</c:forEach>
			</select>
		</div>
		<div>
			<select name="professor.id">
				<option value="${turma.professor.nome }"></option>
				<c:forEach var="professor" items="${professores}">
					<option value="${professor.id }">${professor.nome }</option>
				</c:forEach>
			</select>
		</div>

		<div>
			<input type="submit" value="Alterar">
		</div>
	</form>


</body>
</html>