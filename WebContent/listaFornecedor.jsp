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
<title>Gestão de Fornecedores</title>
</head>
<body>
	<div class="container-fluid">

		<h1>Gestão de Fornecedores</h1>
		<br>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nº ARP</th>
					<th>Início</th>
					<th>Fim</th>
					<th>Prazo</th>
					<th>Fornecedor</th>
					<th>Objeto</th>
					<th>Valor</th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<c:forEach items="${lista}" var="arp">
				<tr align="left">
					<td>${arp.idArp}</td>
					<td>${arp.numArp}</td>

					<fmt:parseDate var="dataDoBancoIN_VIG"
						value="${arp.inicioVigenciaArp}" pattern="yyyy-MM-dd" />
					<fmt:formatDate var="dataFormatadainicioVigencia"
						value="${dataDoBancoIN_VIG}" pattern="dd/MM/yyyy" type="date" />
					<td>${dataFormatadainicioVigencia}</td>

					<fmt:parseDate var="dataDoBancofimVigencia"
						value="${arp.fimVigenciaArp}" pattern="yyyy-MM-dd" />
					<fmt:formatDate var="dataFormatadafimVigencia"
						value="${dataDoBancofimVigencia}" pattern="dd/MM/yyyy" type="date" />
					<td>${dataFormatadafimVigencia}</td>

					<td><div class="progress">
							<div
								class="progress-bar bg-success progress-bar-striped progress-bar-animated"
								style="width:
								${arp.prazoDisponivel}%">Dias para o fim da ARP</div>
						</div><fmt:formatNumber type="number" value="${arp.prazoDisponivel}"/> dias</td>

					<td>${arp.fornecedorArp}</td>
					<td>${arp.objetoArp}</td>

					<td> <fmt:formatNumber type="currency" value="${arp.valorARP}"></fmt:formatNumber></td>

					<td><a href="abrirArp?idarp=${arp.idArp}" type="button"
						class="btn btn-outline-info btn-sm">Abrir</a></td>

					<td><a href="selecionaArpByIdServlet?idarp=${arp.idArp}"
						type="button" class="btn btn-outline-warning btn-sm">Alterar</a></td>

					<td><a href="remover?idarp=${arp.idArp}" type="button"
						class="btn btn-outline-danger btn-sm">Excluir</a></td>
				</tr>

			</c:forEach>
		</table>
		
		<div class="form-group" col-md-auto align="right">
			<a href="Index.jsp" class="btn btn-outline-primary" role="button"
				aria-disabled="true">Voltar</a>
				
			<a href="relatorioProduto" class="btn btn-outline-primary" role="button"
				aria-disabled="true">Relatório de ARP</a> 
				
			<a href="paginaCadastroArp.jsp" class="btn btn-outline-primary" role="button"
				aria-disabled="true">Cadastro de ARPs</a>
		</div>
		


	</div>
</body>
</html>