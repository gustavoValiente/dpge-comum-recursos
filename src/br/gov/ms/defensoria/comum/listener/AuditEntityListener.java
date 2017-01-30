package br.gov.ms.defensoria.comum.listener;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import br.gov.ms.defensoria.comum.entity.AuditableEntity;
import br.gov.ms.defensoria.comum.generics.UsuarioPadrao;
import br.gov.ms.defensoria.comum.util.FacesUtilRecurso;

public class AuditEntityListener {

	@PreUpdate
	public void auditUpdate(AuditableEntity entity) {

		entity.setUsuarioUltimaAlteracao(UsuarioLogado());
		entity.setDataUltimaAlteracao(new Date());
	}

	@PrePersist
	public void auditPersist(AuditableEntity entity) {
		entity.setUsuarioCriacao(UsuarioLogado());
		entity.setDataCriacao(new Date());
		entity.setUsuarioUltimaAlteracao(UsuarioLogado());
		entity.setDataUltimaAlteracao(new Date());
	}

	private static String UsuarioLogado() {
		if (FacesUtilRecurso.getSessionScope().getAttribute("usuarioLogado") == null) {
			return null;
		}
		return ((UsuarioPadrao) FacesUtilRecurso.getSessionScope().getAttribute("usuarioLogado")).usuarioLogado();
	}
}
