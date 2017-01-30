package br.gov.ms.defensoria.comum.generic.audit;

import java.util.Date;
import java.util.List;

import br.gov.ms.defensoria.comum.generics.IGenericEntity;
import br.gov.ms.defensoria.comum.recurso.enumeration.EnumAplicacao;
import br.gov.ms.defensoria.comum.recurso.enumeration.EnumLogicoOperacao;

public interface ILogAuditoria extends IGenericEntity {
	public Long getId();

	public void setId(Long id);

	public Date getDataAuditoria();

	public void setDataAuditoria(Date dataAuditoria);

	public EnumLogicoOperacao getOperacao();

	public void setOperacao(EnumLogicoOperacao operacao);

	public String getEntidade();

	public void setEntidade(String entidade);

	public List<? extends IGenericEntity> getListLogCampoAuditoria();

	public void setListLogCampoAuditoria(List<?> listLogCampoAuditoria);

	public String getUsuario();

	public void setUsuario(String usuario);

	public String getIpMaquinaLocal();

	public void setIpMaquinaLocal(String ipMaquinaLocal);

	public EnumAplicacao getSistema();

	public void setSistema(EnumAplicacao nomeSistema);

	public String getTelaSistema();

	public void setTelaSistema(String nomeTela);
}
