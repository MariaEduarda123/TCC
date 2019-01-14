<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Entregas</title>
<link rel="stylesheet" type="text/css" href="/tcc/resources/css/estilo.css">
</head>
<body style="background-image: url(http://luzdaserra.net/wp-content/uploads/2017/05/fundo-cinza.jpg)">
	<c:import url="../menu.jsp"></c:import>

	<h1 class="lista">Lista  de Entregas</h1>

	<table style="background-color: #FFFFFF">
		<thead>
			<tr>
				<th>Descrição</th>
				<th>Aluno</th>
				<th>Data da Entrega</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="entrega" items="${entregas}">
				<tr>
					<td>${entrega.atividade.descricao}</td>
					<td>${entrega.aluno.nome}</td>
					<td>${entrega.dataDeEntrega.time}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>