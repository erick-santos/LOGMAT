<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<title>Cadastro de Pregão</title>
</head>
<body>

	<div class="container">

		<br>
		<h2>Cadastro de Pregão</h2>
		<br>

		<form action="./cadastroPregao" method="Post">
			<div class="form-row">
				<div class="form-group col-md-2">
					<label>PREGÃO</label> <input type="text" class="form-control"
						name="numPregao" value="${arp.numPregao }" required>
				</div>

				<div class="form-group col-md-3">
					<label>PROCESSO</label> <input type="text" name="processo"
						class="form-control" value="${arp.processo }" required>
				</div>
				
				<div class="form-group col-md-2">
					<label>DOU</label> <input type="text" name="DouPregao"
						class="form-control" value="${arp.DouPregao }" required>
				</div>
				
				<div class="form-group col-md-4">
					<label>DATA DE PUBLICAÇÃO DO DOU</label> <input type="date"
						class="form-control" name="publicacaoDouPregao"
						value="${arp.publicacaoDouPregao }" required>
				</div>
			</div>
			
			<!-- Botões -->
			<br>
			<div class="form-group" col-md-auto align="right">
				<a href="paginaCadastroPregao.jsp" class="btn btn-outline-primary"
					role="button" aria-disabled="true">Cancelar</a>

				<button type="reset" class="btn btn-outline-primary">Limpar</button>

				<button type="submit" class="btn btn-outline-primary">Cadastrar
					Pregão</button>
			</div>

			<div class="form-group" col-md-auto align="right">
				<a href="listaPregao" class="btn btn-outline-primary" role="button" aria-disabled="true">Gestão de Pregões</a>
				<a href="listaArp" class="btn btn-outline-primary" role="button" aria-disabled="true">Gestão
					de ARP</a>
			</div>

			<!--  Fim de Botões -->
		</form>
	</div>



</body>
</html>