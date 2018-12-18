<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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