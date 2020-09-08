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
<title>Visualização de Ata de Registro de Preços</title>
</head>
<body>
<%@ include file="header.jsp"%>
	<div class="container border border-dark rounded">

		<c:set var="arp" value="${arpModal}"></c:set>
		<div class="container border border-light">
			<BR>
			<h4>Detalhamento de Ata de Registro de Preços: ${arp.numArp}</h4>
			<br>
			<table class="table table-striped">
				<tr>
					<td><strong>Objeto</strong></td>
					<td><strong>${arp.objetoArp}</strong></td>
				</tr>
				<tr>
					<td>Fornecedor</td>
					<td><a href="listaPregao=idPregao?">${arp.fornecedorArp}</a> - CNPJ: ${arp.fornecedorCNPJ}</td>
				</tr>
				<tr>
					<td>Valor total</td>
					<td><fmt:formatNumber type="currency" value="${arp.valorARP}"></fmt:formatNumber></td>
				</tr>



				<tr>
					<td>Data da assinatura</td>
					<fmt:parseDate var="dataDoBancoASS"
						value="${arp.dataAssinaturaArp}" pattern="yyyy-MM-dd" />
					<fmt:formatDate var="dataFormatadaAssinaturaArp"
						value="${dataDoBancoASS}" pattern="dd/MM/yyyy" type="date" />
					<td>${dataFormatadaAssinaturaArp}</td>
				</tr>

				<fmt:parseDate var="dataDoBancoIN_VIG"
					value="${arp.inicioVigenciaArp}" pattern="yyyy-MM-dd" />
				<fmt:formatDate var="dataFormatadainicioVigencia"
					value="${dataDoBancoIN_VIG}" pattern="dd/MM/yyyy" type="date" />


				<fmt:parseDate var="dataDoBancofimVigencia"
					value="${arp.fimVigenciaArp}" pattern="yyyy-MM-dd" />
				<fmt:formatDate var="dataFormatadafimVigencia"
					value="${dataDoBancofimVigencia}" pattern="dd/MM/yyyy" type="date" />

				<tr>
					<td>Vigência</td>
					<td>${dataFormatadainicioVigencia} a
						${dataFormatadafimVigencia}</td>
				</tr>
				<tr>
					<td>Prazo para o fim da ARP</td>
					<td>
						<div class="progress">
							<div
								class="progress-bar bg-success progress-bar-striped progress-bar-animated"
								style="width: ${arp.prazoDisponivel}%">
								<strong><fmt:formatNumber type="number"
										value="${arp.prazoDisponivel}" /> dias.</strong>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<td>Percentual de prazo decorrido</td>
					<td>
						<div class="progress">
							<div
								class="progress-bar bg-success progress-bar-striped progress-bar-animated"
								style="width: ${arp.prazoPorcentagem}%">
								<strong><fmt:formatNumber type="number"
										value="${arp.prazoPorcentagem}" pattern="##" /> %</strong>
							</div>
						</div>
					</td>
				</tr>

				<tr>
					<td>Pregão eletrônico:</td>
					<td><a href="listaPregao?numPregaoArp=${arp.numPregaoArp}">${arp.numPregaoArp}</td>
					
				</tr>
				<tr>
					<td>Processo</td>
					<td>não implementado</td>
				</tr>


				<tr>
					<td>Assina em nome da Superintendência</td>
					<td>${arp.superintendente}</td>
				</tr>
				<tr>
					<td>Assina em nome do Fornecedor</td>
					<td><a
						href="listaPregao=idPregao?${arp.representanteFornecedor}">${arp.representanteFornecedor}</a></td>
				</tr>
			</table>
		</div>

		<div class="form-group" col-md-auto align="right">

			<a href="listaItem?idArp=${arp.idArp}"
				class="btn btn-outline-primary" role="button" aria-disabled="true">Ver
				Itens</a>

			<!-- Button to Open the Modal -->
			<button type="button" class="btn btn-outline-primary"
				data-toggle="modal" data-target="#myModal">Adicionar Item</button>

			<a href="http://localhost:8080/LOGMAT/listaArp"
				class="btn btn-outline-primary" role="button" aria-disabled="true">Voltar
				à Gestão de ARPs</a>

			<a href="http://localhost:8080/LOGMAT/DashBoard"
				class="btn btn-outline-primary" role="button" aria-disabled="true">Ir ao DashBoard</a>

		</div>

	</div>
	<br>

	<div class="container">

		<!-- The Modal -->
		<div class="modal fade" id="myModal">
			<div class="modal-dialog modal-xl">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title">Cadastrar Item na ARP</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

					<!-- Modal body -->
					<div class="modal-body">
						<div class="container border border-secundary">

							<br>
							<form action="./cadastroItem" method="Post">
								<input type="hidden" value="${arp.idArp}" name="idArp">

								<div class="form-row">
									<div class="form-group col-md-1">
										<label>ID:</label> <input type="text" class="form-control"
											name="idItem" value="">
									</div>

									<div class="form-group col-md-1">
										<label>Número:</label> <input type="text" class="form-control"
											name="numItem" value="" required>
									</div>

									<div class="form-group col-md-10">
										<label>Nome:</label> <input type="text" class="form-control"
											name="nomeItem" required>
									</div>
								</div>

								<div class="form-row">
									<div class="form-group col-md-12">
										<label for="comment">Descrição/Especificação:</label>
										<textarea class="form-control" rows="4" name="descricaoItem"
											required></textarea>
									</div>
								</div>

								<div class="form-row">
									<div class="form-group col-md-3">
										<label>Marca:</label> <input type="text" class="form-control"
											name="marcaItem" required>
									</div>

									<div class="form-group col-md-3">
										<label>Quantidade:</label> <input type="text"
											class="form-control" name="quantidadeItem" required>
									</div>

									<div class="form-group col-md-3">
										<label>Unidade:</label> <input type="text"
											class="form-control" name="unidadeItem" required>
									</div>

									<div class="form-group col-md-3">
										<label>Valor Unitário:</label> <input type="text"
											class="form-control" name="valorUnitarioItem" required>
									</div>
								</div>
								<div class="form-group" col-md-auto align="right">
									<button type="submit" class="btn btn-primary">Cadastrar
										Item</button>
								</div>
							</form>
						</div>

					</div>


				</div>
			</div>
		</div>
</body>
</html>