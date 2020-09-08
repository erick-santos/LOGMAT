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
<title>Pregões e ARPs correspondentes</title>
</head>
<body>

	<div class="container border border-dark rounded">

		<h1>Pregões e ARPs correspondentes</h1>
		<br>
		<table class="table table-striped table-bordered ">
			<thead>
				<tr>
					<th>Pregão</th>
					<th>ARP</th>
					<th>Objeto</th>
					<th>Inicio da vigência</th>
				</tr>
			</thead>

			<c:forEach items="${listaPregao}" var="arp">
				<tr>
					<td>${arp.numPregaoArp}</td>
					<td>${arp.numArp }</td>
					<fmt:parseDate var="dataDoBancoDouPregao"
						value="${arp.inicioVigenciaArp}" pattern="yyyy-MM-dd" />
					<fmt:formatDate var="dataFormatadainicioVigencia"
						value="${dataDoBancoDouPregao}" pattern="dd/MM/yyyy" type="date" />
					<td>${arp.objetoArp }</td>
					<td>${dataFormatadainicioVigencia}</td>
				</tr>
			</c:forEach>
		</table>

		<div class="form-group" col-md-auto align="right">
			<a href="http://localhost:8080/LOGMAT/listaArp"
				class="btn btn-outline-primary" role="button" aria-disabled="true">Voltar</a>
			<input type="button" class="btn btn-outline-primary" value="Imprimir" onclick="printPage()" />
		</div>



	</div>
	
	<script>
		function printPage() {
			window.print();
		}
	</script>
</body>
</html>