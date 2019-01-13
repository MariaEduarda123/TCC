<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Disciplina</title>
<link rel="stylesheet" type="text/css" href="/tcc/resources/css/estilo.css">
</head>
<body style="background-image:url(https://i.pinimg.com/originals/84/10/e7/8410e732cb6fd804dd260a2c1afacaed.jpg)">

	<c:import url="../menu.jsp"></c:import>

	<h1>Alterar Disciplina</h1>
	
	<form action="/tcc/disciplinas/alterar" method="post">
	
			<label>ID:</label> </br>
			 <input readonly="readonly" type="hidden" name="id" value="${disciplina.id }">

			<label>Nome:</label>
			 <input type="text" name="nome" value="${disciplina.nome }">

			 <input class="button" type="submit" value="Alterar">

	</form>


</body>
</html>