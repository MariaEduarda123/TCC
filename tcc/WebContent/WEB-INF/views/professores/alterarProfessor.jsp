<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="/tcc/resources/css/estilo.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Alterar Professor</title>
</head>
<body style="background-image:url(https://i.pinimg.com/originals/84/10/e7/8410e732cb6fd804dd260a2c1afacaed.jpg)">

	<c:import url="../menu.jsp"></c:import>

	<h1>Alterar Professor</h1>
	
	<form action="/tcc/professores/alterar" method="post">
	
			<label>ID:</label></br>
			 <input readonly="readonly" type="hidden" name="id" value="${professor.id }">
		
			<label>Nome:</label>
			 <input type="text" name="nome" value="${professor.nome }">
		
			<label>Matricula:</label>
			 <input type="text" name="matricula" value="${professor.matricula }">
		
			 <input class="button" type="submit" value="Alterar">
		
	</form>


</body>
</html>