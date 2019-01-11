<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alterar Professor</title>
</head>
<body>

	<c:import url="../menu.jsp"></c:import>

	<h1>Alterar Professor</h1>
	<form action="/tcc/professores/alterar" method="post">
	
		<div>
			<label>ID: <input readonly="readonly" type="hidden" name="id" value="${professor.id }"></label>
		</div>
	
		<div>
			<label>Nome: <input type="text" name="nome" value="${professor.nome }"></label>
		</div>
		
		<div>
			<label>Matricula: <input type="text" name="matricula" value="${professor.matricula }"></label>
		</div>
		
		<div>
			 <input type="submit" value="Alterar">
		</div>
	</form>


</body>
</html>