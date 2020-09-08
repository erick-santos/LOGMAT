package br.com.logmat.model;

public class Item {
	private int idItem;
	private int idArp;
	
	private String numItem;
	private String nomeItem;
	private String descricaoItem;
	private String marcaItem;
	private String unidadeItem;
	
	private double quantidadeItem;
	private double valorUnitarioItem;

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public int getIdArp() {
		return idArp;
	}

	public void setIdArp(int idArp) {
		this.idArp = idArp;
	}

	public String getNumItem() {
		return numItem;
	}

	public void setNumItem(String numItem) {
		this.numItem = numItem;
	}

	public String getNomeItem() {
		return nomeItem;
	}

	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}

	public String getDescricaoItem() {
		return descricaoItem;
	}

	public void setDescricaoItem(String descricaoItem) {
		this.descricaoItem = descricaoItem;
	}

	public String getMarcaItem() {
		return marcaItem;
	}

	public void setMarcaItem(String marcaItem) {
		this.marcaItem = marcaItem;
	}

	public String getUnidadeItem() {
		return unidadeItem;
	}

	public void setUnidadeItem(String unidadeItem) {
		this.unidadeItem = unidadeItem;
	}

	public double getQuantidadeItem() {
		return quantidadeItem;
	}

	public void setQuantidadeItem(double quantidadeItem) {
		this.quantidadeItem = quantidadeItem;
	}

	public double getValorUnitarioItem() {
		return valorUnitarioItem;
	}

	public void setValorUnitarioItem(double valorUnitarioItem) {
		this.valorUnitarioItem = valorUnitarioItem;
	}

}
