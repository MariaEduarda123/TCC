<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Alunos</title>
<link rel="stylesheet" type="text/css" href="/tcc/resources/css/estilo.css">
</head>
<body style="background-image: url(http://luzdaserra.net/wp-content/uploads/2017/05/fundo-cinza.jpg)">
	<c:import url="../menu.jsp"></c:import>

	<h1 class="lista">Lista de Alunos</h1>

	<table style="background-color: #FFFFFF">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Matrícula</th>
				<th>Alterar</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="aluno" items="${alunos}">
				<tr>
					<td>${aluno.nome}</td>
					<td>${aluno.matricula}</td>
					<td><a href="/tcc/alunos/selecionarAluno?id=${aluno.id}">Alterar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>