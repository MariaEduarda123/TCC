<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adicionar Turma</title>
<link href="/tcc/resources/css/estilo.css" rel="stylesheet">
</head>
<body style="background-image:url(https://i.pinimg.com/originals/84/10/e7/8410e732cb6fd804dd260a2c1afacaed.jpg)">
	<c:import url="../menu.jsp"></c:import>

	<div class="caixa">
	<h1>Adicionar Turma</h1>

	<form action="/tcc/turmas" method="post">

			<label>Nome:</label>
			 <input type="text" name="nome">

			<label>Disciplina:</label>
			<select name="disciplina.id">
				<option value="">Selecione uma disciplina</option>
				<c:forEach var="disciplina" items="${disciplinas}">
					<option value="${disciplina.id }">${disciplina.nome }</option>
				</c:forEach>
			</select>

			<label>Professor:</label>
			<select name="professor.id">
				<option value="">Selecione um professor</option>
				<c:forEach var="professor" items="${professores}">
					<option value="${professor.id }">${professor.nome }</option>
				</c:forEach>
			</select>

			<input class="button" type="submit" value="Adicionar Turma">

	</form>
	</div>
</body>
</html>