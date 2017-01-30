package br.gov.ms.defensoria.comum.recurso.enumeration;

public enum EnumTipoServidor {
	DEFENSOR("DEFENSOR"),
	DEFENSOR_APOSENTADO("DEFENSOR APOSENTADO"),
	SERVIDOR_EFETIVO("SERVIDOR EFETIVO"),
	SERVIDOR_EFETIVO_APOSENTADO("SERVIDOR EFETIVO APOSENTADO"),
	SERVIDOR_COMISSIONADO("SERVIDOR COMISSIONADO"),
	CEDIDO_TERCEIRO("CEDIDO"),
	CEDIDO_OUTROS_PODERES("CEDIDO OUTROS PODERES"),
	PENSIONISTA("PENSIONISTA"),
	PENSIONISTA_JUDICIAL("PENSIONISTA JUDICIAL"),
	ESTAGIARIO("ESTÁGIARIO"),
	BOLSISTA("BOLSISTA"),
	VOLUNTARIO("VOLUNTÁRIO"),
	EXONERADO("EXONERADO"),
	EXONERADO_COMISSIONADO("COMISSIONADO EXONERADO "),
	EXONERADO_EFETIVO("EFETIVO EXONERADO "),
	EXONERADO_CEDIDO("CEDIDO EXONERADO "),
	EXONERADO_CEDIDO_OUTROS_PODERES("CEDIDO EXONERADO "),
	EXONERADO_DEFENSOR("DEFENSOR EXONERADO ");

	private String descricao;

	private EnumTipoServidor(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}