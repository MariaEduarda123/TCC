<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Entregar atividade</title>
</head>
<body>

	<c:import url="../menu.jsp"></c:import>

	<h1>Entregar Atividade</h1>
	<form action="/tcc/atividades/entregar" method="post">

		<div>
			<label>ID: <input readonly="readonly" type="hidden" name="id"
				value="${atividade.id }"></label>
		</div>

		<div>
			<label>Descrição: <input type="text" name="descricao"
				value="${atividade.descricao}"></label>
		</div>

		<div>
			<label>Turma: <input type="text" name="turma"
				value="${atividade.turma.nome}"></label>
		</div>		
		
		<div>
			<label>Aluno: <input type="text" name="aluno"
				value="${entrega.aluno.id}"></label>
		</div>		
		

		<div>
			<input type="submit" value="Entregar">
		</div>
	</form>

</body>
</html>