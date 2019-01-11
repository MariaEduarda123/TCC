<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
			<label>Data de Entrega: <input type="text" name="dataEntrega"></label>
		</div>
		
		<div>
			<select name="turma.id">
				<option value="">Selecione uma turma</option>
				<c:forEach var="turma" items="${turmas}">
					<option value="${turma.id }">${turma.nome }</option>
				</c:forEach>
			</select>
		</div>
		
		<div>
			 <input type="submit" value="Registrar Atividade">
		</div>
</form>
</body>
</html>