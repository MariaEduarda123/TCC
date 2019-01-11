<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrar Disciplinas</title>
</head>
<body>
<c:import url="../menu.jsp"></c:import>

<form action="/tcc/disciplinas"  method="post">

	<h1>Registrar Disciplina</h1>
	
		<div>
			<label>Nome: <input type="text" name="nome"></label>
		</div>
		
		<div>
			 <input type="submit" value="Registrar Disciplina">
		</div>
</form>
</body>
</html>