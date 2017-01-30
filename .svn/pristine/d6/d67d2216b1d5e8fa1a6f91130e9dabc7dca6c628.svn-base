package br.gov.ms.defensoria.comum.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import br.gov.ms.defensoria.comum.generics.GenericEntityImpl;
import br.gov.ms.defensoria.comum.listener.AuditEntityListener;

@MappedSuperclass
@EntityListeners(AuditEntityListener.class)
public abstract class AuditableEntity extends GenericEntityImpl {

	private static final long serialVersionUID = -8657862703168479145L;

	@Column(name = "DataInclusao")
	private Date dataCriacao;

	@Column(name = "DataAlteracao")
	private Date dataUltimaAlteracao;

	@Column(name = "UsuarioInclusao")
	private String usuarioCriacao;

	@Column(name = "UsuarioAlteracao")
	private String usuarioUltimaAlteracao;

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataUltimaAlteracao() {
		return dataUltimaAlteracao;
	}

	public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
		this.dataUltimaAlteracao = dataUltimaAlteracao;
	}

	public String getUsuarioCriacao() {
		return usuarioCriacao;
	}

	public void setUsuarioCriacao(String usuarioCriacao) {
		this.usuarioCriacao = usuarioCriacao;
	}

	public String getUsuarioUltimaAlteracao() {
		return usuarioUltimaAlteracao;
	}

	public void setUsuarioUltimaAlteracao(String usuarioUltimaAlteracao) {
		this.usuarioUltimaAlteracao = usuarioUltimaAlteracao;
	}
}
