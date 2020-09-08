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
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container border border-dark rounded">
		<h1 align="center">Gerênciamento de Atas de Registros de Preços e
			Contratos</h1>
		<br>

		<div align="center">
			<img src="images/teamwork.jpg" width="800px">
		</div>
		
		
		<br>

		<div class="form-group" col-md-auto align="left">
			<a href="DashBoard" class="btn btn-success btn-lg btn-block"
				role="button" aria-disabled="true">DashBoard</a><br> <a
				href="listaArp" class="btn btn-primary btn-lg btn-block"
				role="button" aria-disabled="true">Gestão de Atas de Registro de
				Preços</a><br> <a href="EmailServlet"
				class="btn btn-dark btn-lg btn-block" role="button"
				aria-disabled="true">Email de verificação de atas</a>
		</div>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>