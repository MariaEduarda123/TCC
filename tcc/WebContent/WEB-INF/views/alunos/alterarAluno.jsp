<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/tcc/resources/css/estilo.css">
<meta charset="UTF-8">
<title>Alterar Aluno</title>
</head>
<body style="background-image:url(https://i.pinimg.com/originals/84/10/e7/8410e732cb6fd804dd260a2c1afacaed.jpg)">

	<c:import url="../menu.jsp"></c:import>
	
	<h1>Alterar Aluno</h1>
	
	<form action="/tcc/alunos/alterar" method="post">

			<label>ID:</label> </br>
			 <input readonly="readonly" type="hidden" name="id" value="${aluno.id }">

			<label>Nome:</label>
			 <input type="text" name="nome" value="${aluno.nome }">

			<label>Matricula:</label> 
			 <input type="text" name="matricula" value="${aluno.matricula }">

			 <input class="button" type="submit" value="Alterar">

	</form>

</body>
</html>