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

	<h1>Adicionar Professor</h1>
	
		<div>
			<label>Nome: <input type="text" name="nome"></label>
		</div>
		<div>
			<label>Matricula: <input type="text" name="matricula"></label>
		</div>
		
		<div>
			 <input type="submit" value="Adicionar Professor">
		</div>
</body>
</html>