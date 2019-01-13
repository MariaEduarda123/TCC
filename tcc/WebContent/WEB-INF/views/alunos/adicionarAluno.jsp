<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adicionar Aluno</title>
<link rel="stylesheet" type="text/css" href="/tcc/resources/css/estilo.css">
</head>
<body style="background-image:url(https://i.pinimg.com/originals/84/10/e7/8410e732cb6fd804dd260a2c1afacaed.jpg)">
	<c:import url="../menu.jsp"></c:import>

	<h1>Adicionar Aluno</h1>

	<form action="/tcc/alunos"  method="post">
			
		<label>Nome:</label>
		<input type="text" name="nome"> 
			
		<label>Matricula:</label>
		<input type="text" name="matricula"> 

		<input class="button" type="submit" value="Adicionar Aluno"> <br>
		
	</form>
</body>
</html>