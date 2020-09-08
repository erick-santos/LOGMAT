<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="br.com.logmat.*, java.util.List"%>
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
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">

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

<title>Painel de Atas</title>
</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="container border border-dark rounded">
		<h1 align="center">Painel de Atas</h1>

		
		<div class="border border-secundary">
			<br>


			<div class="card-deck container">

				<c:forEach items="${listaCards}" var="card">
					<c:if test="${card.prazoDisponivel>0}">
						<div class="col-sm-3">
							<div class="card bg-warning rounded-0"
								style="height: 460px; width: 250px">
								<h5 class="card-title" align="center">
									<br> <strong>ARP ${card.numArp}</strong>
								</h5>
								<div class="card-body text-center">
									<p class="text" style="font-size: 20px">${card.objetoArp}</p>

									<p class="card-text">
										<strong>${card.fornecedorArp}</strong>
									</p>

								</div>

								<div class="card-footer" align="center">
									<a class="btn btn-primary btn-block"
										href="http://localhost:8080/LOGMAT/abrirArp?idarp=${card.idArp}">Visualizar</a>
								</div>
							</div>
							<br>
						</div>
					</c:if>
				</c:forEach>

			</div>
			<div align="right">
				<button type="button" class="btn btn-outline-primary" onclick="topFunction()">Voltar
					ao topo</button>
			</div>
			<br>
		</div>
		<br>


	</div>
	<%@ include file="footer.jsp"%>