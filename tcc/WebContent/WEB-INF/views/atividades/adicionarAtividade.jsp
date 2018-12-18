<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registrar atividade</title>
</head>
<body>
<c:import url="../menu.jsp"></c:import>

<form action="/tcc/atividades"  method="post">

	<h1>Registrar Atividades</h1>
	
		<div>
			<label>Descrição: <input type="text" name="descricao"></label>
		</div>
		
		<div>
			<label>Data de Entrega: <input type="text" name="dataTexto"></label>
		</div>
		
		<div>
			 <input type="submit" value="Registrar Atividade">
		</div>
</form>
</body>
</html>