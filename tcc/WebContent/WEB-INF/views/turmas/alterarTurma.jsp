<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/tcc/resources/css/estilo.css" rel="stylesheet">
<title>Alterar Professor</title>
</head>
<body>

	<c:import url="../menu.jsp"></c:import>

	<h1>Alterar Turma</h1>
	
	<form action="/tcc/professores/alterar" method="post">

			<label>ID:</label> </br>
			 <input readonly="readonly" type="hidden" name="id" value="${professor.id }">

			<label>Nome:</label>
			 <input type="text" name="nome" value="${turma.nome }">

			<label>Disciplina:</label>
			<select name="disciplina.id">
				<option value="${turma.disciplina.nome }"></option>
				<c:forEach var="disciplina" items="${disciplinas}">
					<option value="${turma.disciplina.id }">${turma.disciplina.nome }</option>
				</c:forEach>
			</select>

			<label>Professor</label>
			<select name="professor.id">
				<option value="${turma.professor.nome }"></option>
				<c:forEach var="professor" items="${professores}">
					<option value="${professor.id }">${professor.nome }</option>
				</c:forEach>
			</select>

			<input class="button" type="submit" value="Alterar">

	</form>


</body>
</html>