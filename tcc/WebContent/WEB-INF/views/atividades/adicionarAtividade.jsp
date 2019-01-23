<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/tcc/resources/css/estilo.css">
<title>Registrar atividade</title>
</head>
<body style="background-image:url(https://i.pinimg.com/originals/84/10/e7/8410e732cb6fd804dd260a2c1afacaed.jpg)">
<c:import url="../menu.jsp"></c:import>
	<h1>Registrar Atividades</h1>
	<form action="/tcc/atividades"  method="post">
	
			<label>Descrição:</label>
			<input type="text" name="descricao">
			<label>Data de Entrega:</label>
			<input type="text" name="dataEntrega">
			<label>Turma:</label>
			<select name="turma.id">
				<option value="">Selecione uma turma</option>
				<c:forEach var="turma" items="${turmas}">
					<option value="${turma.id }">${turma.nome }</option>
				</c:forEach>
			</select>
			 <input class="button" type="submit" value="Registrar Atividade">

</form>
</body>
</html>