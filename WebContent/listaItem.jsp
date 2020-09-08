<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.time.LocalDate, br.com.logmat.model.Arp"%>
<fmt:setLocale value="pt_BR" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
	integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
	crossorigin="anonymous"></script>
<title>Lista Itens da ARP</title>
</head>
<body>
<%@ include file="header.jsp"%>
	<div class="container-fluid">

		<h1>Lista Itens da ARP</h1>
		<br>
		<table class="table table-striped">
		<thead><tr>Fornecedor:<tr></thead>
			<thead>
				<tr>
					
					<th>ID</th>
					<th>Item</th>
					<th>Nome</th>
					<th>Especificação</th>
					<th>Marca</th>
					<th>Unidade</th>
					<th>Quantidade</th>
					<th>Valor Unitário</th>
					<th>Alterar</th>
					<th>Excluir</th>
				</tr>
			</thead>
			<c:forEach items="${listaItem}" var="item">
				<tr align="left">
					
					<td>${item.idItem}</td>
					<td>${item.numItem}</td>
					<td>${item.nomeItem }</td>
					<td>${item.descricaoItem }</td>
					<td>${item.marcaItem }</td>
					<td>${item.unidadeItem }</td>
					<td><fmt:formatNumber type="number"
							value="${item.quantidadeItem }"></fmt:formatNumber></td>
					<td><fmt:formatNumber type="currency"
							value="${item.valorUnitarioItem}"></fmt:formatNumber></td>

					<td><a href="selecionaArpByIdServlet?idItem=${item.idItem}"
						type="button" class="btn btn-outline-warning btn-sm">Alterar</a></td>

					<td><a href="removerItem?idItem=${item.idItem}" type="button"
						class="btn btn-outline-danger btn-sm">Excluir</a></td>
				</tr>

			</c:forEach>
		</table>
		<div class="form-group" col-md-auto align="right">
			<a href="http://localhost:8080/LOGMAT/listaArp"
				class="btn btn-primary" role="button" aria-disabled="true">Voltar
				a Visualização de ARP</a>
		</div>
	</div>
</body>
</html>