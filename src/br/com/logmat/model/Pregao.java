package br.com.logmat.model;

import java.time.LocalDate;

public class Pregao {
	
	private String numPregao;
	private String processo;
	private String douPregao;
	private LocalDate publicacaoDouPregao;
	
	
	public String getNumPregao() {
		return numPregao;
	}
	public void setNumPregao(String numPregao) {
		this.numPregao = numPregao;
	}
	public String getProcesso() {
		return processo;
	}
	public void setProcesso(String processo) {
		this.processo = processo;
	}
	public String getDouPregao() {
		return douPregao;
	}
	public void setDouPregao(String douPregao) {
		this.douPregao = douPregao;
	}
	public LocalDate getPublicacaoDouPregao() {
		return publicacaoDouPregao;
	}
	public void setPublicacaoDouPregao(LocalDate publicacaoDouPregao) {
		this.publicacaoDouPregao = publicacaoDouPregao;
	}

	
}
