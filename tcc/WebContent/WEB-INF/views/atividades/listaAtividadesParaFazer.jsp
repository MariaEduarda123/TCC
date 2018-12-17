<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Atividades Para Fazer</title>
</head>
<body>
	<c:import url="../menu.jsp"></c:import>

	<table>
		<thead>
			<tr>
				<th>Descrição</th>
				<th>Turma</th>
				<th>Data do emprestimo</th>
				<th>Devolução</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="atividade" items="${atividades}">


				<tr>

					<td>${atividade.descricao}</td>
					<td>${atividade.turma}</td>
					<td>${atividade.dataAplicacao.time }</td>
					<td>${atividade.dataDevolucao.tima }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>