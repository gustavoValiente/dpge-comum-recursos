package br.gov.ms.defensoria.comum.generic.audit;

import br.gov.ms.defensoria.comum.generics.IGenericEntity;

public interface ILogCampoAuditoria extends IGenericEntity {

	public Long getId();

	public void setId(Long id);

	public String getCampo();

	public void setCampo(String campo);

	public String getCampoAnterior();

	public void setCampoAnterior(String valorAnterior);

	public String getCampoAtual();

	public void setCampoAtual(String valorAtual);

	public Object getLogAuditoria();

	public void setLogAuditoria(Object logAuditoria);

}
