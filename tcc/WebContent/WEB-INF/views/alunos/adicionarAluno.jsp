<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adicionar Aluno</title>
</head>
<body>
	<c:import url="../menu.jsp"></c:import>

<form action="/tcc/alunos"  method="post">

	<h1>Adicionar Aluno</h1>
	
		<div>
			<label>Nome: <input type="text" name="nome"></label>
		</div>
		
		<div>
			<label>Matricula: <input type="text" name="matricula"></label>
		</div>
		
		<div>
			 <input type="submit" value="Adicionar Aluno">
		</div>
</form>
</body>
</html>