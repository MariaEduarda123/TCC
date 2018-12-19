<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alterar Aluno</title>
</head>
<body>

	<c:import url="../menu.jsp"></c:import>

	<h1>Alterar Aluno</h1>
	<form action="/tcc/alunos/alterar" method="post">
	
		<div>
			<label>ID: <input readonly="readonly" type="hidden" name="id" value="${aluno.id }"></label>
		</div>
	
		<div>
			<label>Nome: <input type="text" name="nome" value="${aluno.nome }"></label>
		</div>
		
		<div>
			<label>Matricula: <input type="text" name="matricula" value="${aluno.matricula }"></label>
		</div>
		
		<div>
			 <input type="submit" value="Alterar">
		</div>
	</form>

</body>
</html>