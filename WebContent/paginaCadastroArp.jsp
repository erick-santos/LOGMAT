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
<title>Cadastro de Atas de Registro de Preços</title>
</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="container">



		<br>
		<h2>Cadastro de Atas de Registro de Preços</h2>
		<br>

		<form action="./cadastroArp" method="Post">
			<input type="hidden" value="${arp.idArp }" name="idArp">

			<div class="form-row">

				<div class="form-group col-md-1">
					<label>ID</label> <input type="text" class="form-control"
						name="idArp" value="${arp.idArp }">
				</div>

				<div class="form-group col-md-2">
					<label>PREGÃO</label> <input type="text" class="form-control"
						name="numPregaoArp" value="${arp.numPregaoArp }" required>
				</div>

				<div class="form-group col-md-2">
					<label>NÚMERO DE ARP</label> <input type="text"
						class="form-control" name="numArp" value="${arp.numArp }" required>
				</div>

				<div class="form-group col-md-7">

					<label>VALOR DE ARP</label> <input type="text" name="valorARP"
						placeholder="R$ 0,00" class="form-control"
						value="${arp.valorARP }" required>
				</div>
			</div>




			<!--  Data de Assinatura e Vigência da ARP -->
			<div class="form-row">
				<div class="form-group col-md-4">
					<label>DATA DA ASSINATURA DA ARP</label> <input type="date"
						class="form-control" name="dataAssinaturaArp"
						value="${arp.dataAssinaturaArp }" required>
				</div>

				<div class="form-group col-md-4">
					<label>DATA DE INÍCIO DA ARP</label> <input type="date"
						class="form-control" name="inicioVigenciaArp"
						value="${arp.inicioVigenciaArp }" required>
				</div>

				<div class="form-group col-md-4">
					<label>DATA FIM DA ARP</label> <input type="date"
						class="form-control" name="fimVigenciaArp"
						value="${arp.fimVigenciaArp }" required>
				</div>

			</div>
			<!--  FIM: Data de Assinatura e Vigência da ARP -->


			<!--  Superintendente e Representante do Fornecedor -->
			<!--
			<div class="form-group">
				<label>SUPERINTENDENTE</label> <input type="text"
					class="form-control" name="superintendente"
					value="${arp.superintendente }"></input>
			</div>
			-->
			<div class="form-group">
				<label>SUPERINTENDENTE</label> <select class="form-control"
					name="superintendente" value="${arp.superintendente }">
					<option>JOSÉ CARLOS OLIVEIRA</option>
					<option>EDSON AIKO em substituição</option>
				</select>
			</div>

			<div class="form-group">
				<label>FORNECEDOR</label> <input type="text" class="form-control"
					name="fornecedorArp" value="${arp.fornecedorArp}" required></input>
			</div>

			<div class="form-group">
				<label>CNPJ</label> <input type="text" class="form-control"
					name="fornecedorCNPJ" value="${arp.fornecedorCNPJ}" required></input>
			</div>

			<div class="form-group">
				<label>REPRESENTANTE DO FORNECEDOR</label> <input type="text"
					class="form-control" name="representanteFornecedor"
					value="${arp.representanteFornecedor}"></input>
			</div>
			<!--  FIM: Superintendente e Representante do Fornecedor -->

			<!--  Objeto -->
			<div class="form-group">
				<label>OBJETO DA ATA DE REGISTRO DE PREÇOS:</label> <input
					type="text" class="form-control" rows="5" name="objetoArp"
					value="${arp.objetoArp }"></input>
			</div>
			<!-- FIM:Objeto -->


			<!-- Botões -->
			<br>
			<div class="form-group" col-md-auto align="right">
				<a href="paginaCadastroArp.jsp" class="btn btn-outline-primary"
					role="button" aria-disabled="true">Cancelar</a>

				<button type="reset" class="btn btn-outline-primary">Limpar</button>

				<button type="submit" class="btn btn-outline-primary">Cadastrar
					ARP</button>
			</div>

			<div class="form-group" col-md-auto align="right">
				<a href="http://localhost:8080/LOGMAT/listaArp"
					class="btn btn-outline-primary" role="button" aria-disabled="true">Gestão
					de ARPs</a>
			</div>

			<!--  Fim de Botões -->
		</form>
	</div>



</body>
</html>