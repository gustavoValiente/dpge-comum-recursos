package br.gov.ms.defensoria.comum.recurso.enumeration;

public enum EnumTipoRaca {
	BRANCA("Branca"),
	PRETA("Preta/Negra"),
	PARDA("Parda"),
	AMARELA("Amarela"),
	INDIGENA("Indígena"),
	NAO_INFORMADO("Não Informado");

	private String descricao;

	private EnumTipoRaca(String descricao) {
		this.setDescricao(descricao);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
