<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Gestão de atividades</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="/tcc/">Home</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Alunos <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="/tcc/alunos/adicionarAluno/">Adicionar Aluno</a></li>
						<li><a href="/tcc/alunos/">Listar Alunos</a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Professores <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="/tcc/professores/adicionarProfessor/">Adicionar
								Professor</a></li>
						<li><a href="/tcc/professores/">Listar Professores</a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Disciplinas<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="/tcc/disciplinas/adicionarDisciplina/">Adicionar
								Disciplina</a></li>
						<li><a href="/tcc/disciplinas/">Listar Disciplinas</a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Turmas<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="/tcc/turmas/adicionarTurma/">Adicionar Turma</a></li>
						<li><a href="/tcc/turmas/">Listar Turmas</a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Atividades<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="/tcc/atividades/adicionarAtividade/">Adicionar
								Atividade</a></li>
						<li><a href="/tcc/atividades/">Atividades</a></li>
						<li><a href="/tcc/atividades/listaAtividadesParaFazer">Listar
								Atividades Para Fazer</a></li>
					</ul></li>

			</ul>
		</div>
	</nav>

	

</body>
</html>
