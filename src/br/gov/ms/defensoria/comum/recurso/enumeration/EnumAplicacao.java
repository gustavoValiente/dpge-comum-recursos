package br.gov.ms.defensoria.comum.recurso.enumeration;

public enum EnumAplicacao {
	SAP("Sistema de Atendimento ao Público - Defensoria Publica MS"),
	DIARIAS("Diárias - Defensoria Publica MS"),
	COMUM("Sistema Comum - Defensoria Publica MS"),
	CONCURSO("Concurso - Defensoria pública MS"),
	FOLHA("Sistema Folha de Pgto");
	private String descricao;

	private EnumAplicacao(String descricao) {
		this.setDescricao(descricao);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
