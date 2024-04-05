<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Pessoas</title>
</head>
<body>
	<div class="container mt-5">
		<h1>Pessoas</h1>
		
		<c:if test="${sucesso != null && !sucesso.isEmpty() }">
			<div class="alert alert-success" role="alert">
				${sucesso}
			</div>
		</c:if>
		<c:if test="${erro != null && !erro.isEmpty() }">
			<div class="alert alert-danger" role="alert">
				${erro}
			</div>
		</c:if>
		
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>CPF</th>
					<th class="col-sm-2" align="center"><a href="/pessoas/novo"
						class="btn btn-xs btn-success">+</a></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pessoas}" var="pessoa">
					<tr>
						<td>${pessoa.id}</td>
						<td>${pessoa.nome}</td>
						<td>${pessoa.cpf}</td>
						<td><a href="/pessoas/${pessoa.id}"
							class="btn btn-xs btn-primary">Editar</a>
							<form action="/pessoas/${pessoa.id}" method="post"
								class="d-inline">
								<input type="hidden" name="_method" value="DELETE">
								<button type="submit" class="btn btn-xs btn-danger">Excluir</button>
							</form></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
