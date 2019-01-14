<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/tcc/resources/css/estilo.css">
<title>Entregar atividade</title>
</head>
<body style="background-image:url(https://i.pinimg.com/originals/84/10/e7/8410e732cb6fd804dd260a2c1afacaed.jpg)">

	<c:import url="../menu.jsp"></c:import>

	<h1>Entregar Atividade</h1>
	
	<form action="/tcc/entregas" method="post">

			<label>ID:</label> </br>
			 <input readonly="readonly" type="text" name="atividade.id" value="${atividade.id }">
		
			<label>Anexar arquivo:</label>
			 <input type="text" name="descricao" value="${atividade.descricao}">
		
			<label>Aluno:</label>
			 <input type="text" name="aluno.id" value="${aluno.id}">
		
			<input class="button" type="submit" value="Entregar">
		
	</form>

</body>
</html>