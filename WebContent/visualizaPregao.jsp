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
<title>Pregão Eletronico</title>
</head>
<body>
	<div class="container">

		<h1>Detalhamento de Pregão Eletrônico</h1>
		<br>
		<c:set var="pregao" value="${pregao}"></c:set>
		<table class="table table-striped">
			<tr>
				<td>Pregão</td>
				<td>${pregao.objetoArp} 10/2019</td>
			</tr>
			<tr>
				<td>DOU</td>
				<td>${pregao.objetoArp} 101 de 28/05/2019</td>
			</tr>
			<tr>
				<td>Processo</td>
				<td>${pregao.objetoArp} 35664.000071/2019-00</td>
			</tr>
			<tr>
				</table>
				
		<div class="form-group" col-md-auto align="right">
			<a
				href="http://localhost:8080/LOGMAT/listaPregao" class="btn btn-outline-primary"
				role="button" aria-disabled="true">Ver Pregões</a>
		</div>



	</div>
</body>
</html>