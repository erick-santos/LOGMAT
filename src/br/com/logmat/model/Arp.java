package br.com.logmat.model;

import java.time.Duration;
import java.time.LocalDate;

public class Arp {
	private int idArp; // 0

	private String numArp; // 1

	private LocalDate dataAssinaturaArp; // 2
	private LocalDate inicioVigenciaArp; // 3
	private LocalDate fimVigenciaArp; // 4

	private String superintendente; // 5
	private String representanteFornecedor; // 6
	private String fornecedorArp; // 7
	private String fornecedorCNPJ; // 8
	private String objetoArp; // 9

	private double valorARP; // 10

	private float prazoDisponivel; // 11
	private float prazoPorcentagem; // 12
	private String numPregaoArp; // 13

	public int getIdArp() {
		return idArp;
	}

	public void setIdArp(int idArp) {
		this.idArp = idArp;
	}

	public String getNumArp() {
		return numArp;
	}

	public void setNumArp(String numArp) {
		this.numArp = numArp;
	}

	public LocalDate getDataAssinaturaArp() {
		return dataAssinaturaArp;
	}

	public void setDataAssinaturaArp(LocalDate dataAssinaturaArp) {
		this.dataAssinaturaArp = dataAssinaturaArp;
	}

	public LocalDate getInicioVigenciaArp() {
		return inicioVigenciaArp;
	}

	public void setInicioVigenciaArp(LocalDate inicioVigenciaArp) {
		this.inicioVigenciaArp = inicioVigenciaArp;
	}

	public LocalDate getFimVigenciaArp() {
		return fimVigenciaArp;
	}

	public void setFimVigenciaArp(LocalDate fimVigenciaArp) {
		this.fimVigenciaArp = fimVigenciaArp;
	}

	public String getSuperintendente() {
		return superintendente;
	}

	public void setSuperintendente(String superintendente) {
		this.superintendente = superintendente;
	}

	public String getRepresentanteFornecedor() {
		return representanteFornecedor;
	}

	public void setRepresentanteFornecedor(String representanteFornecedor) {
		this.representanteFornecedor = representanteFornecedor;
	}

	public String getFornecedorArp() {
		return fornecedorArp;
	}

	public void setFornecedorArp(String fornecedorArp) {
		this.fornecedorArp = fornecedorArp;
	}

	public String getFornecedorCNPJ() {
		return fornecedorCNPJ;
	}

	public void setFornecedorCNPJ(String fornecedorCNPJ) {
		this.fornecedorCNPJ = fornecedorCNPJ;
	}

	public String getObjetoArp() {
		return objetoArp;
	}

	public void setObjetoArp(String objetoArp) {
		this.objetoArp = objetoArp;
	}

	public double getValorARP() {
		return valorARP;
	}

	public void setValorARP(double valorARP) {
		this.valorARP = valorARP;
	}

	public float getPrazoDisponivel() {
		return prazoDisponivel;
	}

	public void setPrazoDisponivel(float prazoDisponivel) {
		this.prazoDisponivel = prazoDisponivel;
	}

	public float getPrazoPorcentagem() {
		return prazoPorcentagem;
	}

	public void setPrazoPorcentagem(float prazoPorcentagem) {
		this.prazoPorcentagem = prazoPorcentagem;
	}

	public String getNumPregaoArp() {
		return numPregaoArp;
	}

	public void setNumPregaoArp(String numPregaoArp) {
		this.numPregaoArp = numPregaoArp;
	}

	

}
