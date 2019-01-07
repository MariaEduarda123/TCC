<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adicionar Turma</title>
</head>
<body>
	<c:import url="../menu.jsp"></c:import>

	<form action="/tcc/turmas" method="post">

		<h1>Adicionar Turma</h1>

		<div>
			<label>Nome: <input type="text" name="nome"></label>
		</div>
		<div>
			<select name="id">
				<option value="">Selecione uma disciplina</option>
				<c:forEach var="disciplina" items="${disciplinas}">
					<option value="${disciplina.id }">${disciplina.nome }</option>
				</c:forEach>
			</select>
		</div>
		<div>
			<select name="professor.id">
				<option value="">Selecione um professor</option>
				<c:forEach var="professor" items="${professores}">
					<option value="${professor.id }">${professor.nome }</option>
				</c:forEach>
			</select>
		</div>
		<div>
			<input type="submit" value="Adicionar Turma">
		</div>
	</form>
</body>
</html>