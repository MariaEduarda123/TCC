<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Atividades</title>
<link rel="stylesheet" type="text/css" href="/tcc/resources/css/estilo.css">
</head>
<body style="background-image: url(http://luzdaserra.net/wp-content/uploads/2017/05/fundo-cinza.jpg)">
	<c:import url="../menu.jsp"></c:import>

	<h1 class="lista">Lista  de Atividades</h1>

	<table style="background-color: #FFFFFF">
		<thead>
			<tr>
				<th>Descrição</th>
				<th>Turma</th>
				<th>Data de Entrega</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="atividade" items="${atividades}">


				<tr>

					<td>${atividade.descricao}</td>
					<td>${atividade.turma.nome}</td>
					<td>${atividade.dataEntrega.time}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>