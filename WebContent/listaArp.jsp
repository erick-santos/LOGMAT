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

<script>
	//Get the button
	var mybutton = document.getElementById("myBtn");

	// When the user scrolls down 20px from the top of the document, show the button
	window.onscroll = function() {
		scrollFunction()
	};

	function scrollFunction() {
		if (document.body.scrollTop > 20
				|| document.documentElement.scrollTop > 20) {
			mybutton.style.display = "block";
		} else {
			mybutton.style.display = "none";
		}
	}

	// When the user clicks on the button, scroll to the top of the document
	function topFunction() {
		document.body.scrollTop = 0;
		document.documentElement.scrollTop = 0;
	}
</script>
<title>Gestão de Atas de Registro de Preços</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container">

		<h1>Gestão de Atas de Registro de Preços</h1>
		<br>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>PREGÃO</th>
					<th>Nº ARP</th>
					<th>Início</th>
					<th>Fim</th>
					<th>Prazo</th>
					<th>Fornecedor</th>
					<th>Objeto</th>
					<th>Valor</th>
					<th></th>
					<th>Gerir</th>
					<th></th>
				</tr>
			</thead>
			<c:forEach items="${lista}" var="arp">
				<tr align="left">
					<td>${arp.numPregaoArp}</td>
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

					<c:if test="${arp.prazoDisponivel < 0}">
						<td>
							<div class="alert alert-info" align="center">
								<strong>Ata Vencida!</strong>
							</div>
						</td>
					</c:if>
					<c:if test="${arp.prazoDisponivel > 0}">
						<td><div class="progress">
								<div
									class="progress-bar bg-success progress-bar-striped progress-bar-animated"
									style="width:
								${arp.prazoDisponivel}%">Dias para
									o fim da ARP</div>
							</div> <fmt:formatNumber type="number" value="${arp.prazoDisponivel}" />
							dias</td>
					</c:if>


					<td>${arp.fornecedorArp}</td>
					<td>${arp.objetoArp}</td>

					<td><fmt:formatNumber type="currency" value="${arp.valorARP}"></fmt:formatNumber></td>

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
				aria-disabled="true"><i class="fa fa-home"></i> Ir a página principal</a> <a
				href="relatorioProduto" class="btn btn-outline-primary"
				role="button" aria-disabled="true"><i class="fa fa-file"></i> Relatório de ARP</a> <a
				href="paginaCadastroArp.jsp" class="btn btn-outline-primary"
				role="button" aria-disabled="true"><i class="fa fa-save"></i> Cadastro de ARPs</a>
		</div>

		<div align="right">
			<button type="button" class="btn btn-outline-primary"
				onclick="topFunction()"><i class="fa fa-toggle-up"></i> Voltar ao topo</button>
		</div>

	</div>
</body>
</html>