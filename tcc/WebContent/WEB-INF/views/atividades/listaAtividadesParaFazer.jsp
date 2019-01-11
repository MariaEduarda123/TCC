<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Atividades Para Fazer</title>
</head>
<body>
	<c:import url="../menu.jsp"></c:import>

	<table>
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
					<td>${atividade.dataEntrega.time }</td>
					<td><a href="/tcc/atividades/selecionarAtividade?id=${atividade.id}">Entregar atividade</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>