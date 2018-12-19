<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alterar Turma</title>
</head>
<body>

	<c:import url="../menu.jsp"></c:import>

	<h1>Alterar Turma</h1>
	<form action="/tcc/turmas/alterar" method="post">
	
		<div>
			<label>ID: <input readonly="readonly" type="hidden" name="id" value="${turma.id }"></label>
		</div>
	
		<div>
			<label>Nome: <input type="text" name="nome" value="${turma.nome }"></label>
		</div>
		
		<div>
			<label>Disciplina: <input type="text" name="disciplina" value="${turma.disciplina }"></label>
		</div>
		
		<div>
			<label>Professor: <input type="text" name="professor" value="${turma.professor }"></label>
		</div>
		
		<div>
			 <input type="submit" value="Alterar">
		</div>
	</form>


</body>
</html>