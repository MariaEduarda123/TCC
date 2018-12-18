<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adicionar Professor</title>
</head>
<body>

	<c:import url="../menu.jsp"></c:import>
	<form action="/tcc/professores" method="post">
		<h1>Adicionar Professor</h1>

		<div>
			<label>Nome: <input type="text" name="nome"></label>
		</div>
		<div>
			<label>Matricula: <input type="text" name="matricula"></label>
		</div>

		<div>
			<label>Turma 1: <input type="text" name="turma"></label>
		</div>

		<div>
			<label>Turma 2: <input type="text" name="turma"></label>
		</div>
		<div>
			<label>Turma 3: <input type="text" name="turma"></label>
		</div>
		<div>
			<label>Turma 4: <input type="text" name="turma"></label>
		</div>
		<div>
			<label>Turma 5: <input type="text" name="turma"></label>
		</div>



		<div>
			<input type="submit" value="Adicionar Professor">
		</div>
	</form>
</body>
</html>