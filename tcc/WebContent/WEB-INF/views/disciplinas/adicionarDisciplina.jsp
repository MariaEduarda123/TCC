<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrar Disciplinas</title>
<link rel="stylesheet" type="text/css" href="/tcc/resources/css/estilo.css">
</head>
<body style="background-image:url(https://i.pinimg.com/originals/84/10/e7/8410e732cb6fd804dd260a2c1afacaed.jpg)">
	<c:import url="../menu.jsp"></c:import>
	
	<h1>Registrar Disciplina</h1>
	
	<form action="/tcc/disciplinas"  method="post">

			<label>Nome:</label>
			 <input type="text" name="nome">
			
			 <input class="button" type="submit" value="Registrar Disciplina">

</form>
</body>
</html>