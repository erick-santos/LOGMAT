package br.com.logmat.model;

import java.time.LocalDate;

public class Relatorio {
	private String tipoAlteracao;
	private String codUser;
	private LocalDate dataHoraAcao;
	private String tipoProduto;
	private String codigoProduto;
	private String nomeProduto;
	private String descricao;
	private String marca;
	private double precoUnitario;
	private LocalDate dataCadastramento;
	
	public String getTipoAlteracao() {
		return tipoAlteracao;
	}
	public void setTipoAlteracao(String tipoAlteracao) {
		this.tipoAlteracao = tipoAlteracao;
	}
	public String getCodUser() {
		return codUser;
	}
	public void setCodUser(String codUser) {
		this.codUser = codUser;
	}
	public LocalDate getDataHoraAcao() {
		return dataHoraAcao;
	}
	public void setDataHoraAcao(LocalDate dataHoraAcao) {
		this.dataHoraAcao = dataHoraAcao;
	}
	public String getTipoProduto() {
		return tipoProduto;
	}
	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}
	public String getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public double getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	public LocalDate getDataCadastramento() {
		return dataCadastramento;
	}
	public void setDataCadastramento(LocalDate dataCadastramento) {
		this.dataCadastramento = dataCadastramento;
	}
	
}
