package br.gov.ms.defensoria.comum.recurso.enumeration;

public enum EnumTipoSexo {
	MASCULINO("Masculino"),
	FEMININO("Feminino");

	private String descricao;

	private EnumTipoSexo(String descricao) {
		this.setDescricao(descricao);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
