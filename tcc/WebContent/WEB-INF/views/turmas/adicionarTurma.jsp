<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adicionar Turma</title>
</head>
<body>
		<c:import url="../menu.jsp"></c:import>

<form action="/tcc/turmas"  method="post">

	<h1>Adicionar Turma</h1>
	
		<div>
			<label>Nome: <input type="text" name="nome"></label>
		</div>
		
		<div>
			<label>Disciplina: <input type="text" name="disciplina.id"></label>
		</div>
		<div>
			<label>Professor: <input type="text" name="professor.id"></label>
		</div>
		<div>
			 <input type="submit" value="Adicionar Turma">
		</div>
</form>
</body>
</html>