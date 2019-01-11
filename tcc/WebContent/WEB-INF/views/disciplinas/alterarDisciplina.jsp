<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Disciplina</title>
</head>
<body>

	<c:import url="../menu.jsp"></c:import>

	<h1>Alterar Disciplina</h1>
	<form action="/tcc/disciplinas/alterar" method="post">
	
		<div>
			<label>ID: <input readonly="readonly" type="hidden" name="id" value="${disciplina.id }"></label>
		</div>
	
		<div>
			<label>Nome: <input type="text" name="nome" value="${disciplina.nome }"></label>
		</div>
		
		<div>
			 <input type="submit" value="Alterar">
		</div>
	</form>


</body>
</html>