package br.gov.ms.defensoria.comum.mb;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.security.auth.login.LoginException;

import br.gov.ms.defensoria.comum.generics.UsuarioPadrao;
import br.gov.ms.defensoria.comum.util.FacesUtilRecurso;

@SessionScoped
@Named
public class UsuarioMBeanUtility implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Realiza Logout.
	 * 
	 * @throws LoginException
	 */
	public String getUsuarioLogado() {
		if (FacesUtilRecurso.getSessionScope().getAttribute("usuarioLogado") == null) {
			return "";
		}
		return ((UsuarioPadrao) FacesUtilRecurso.getSessionScope().getAttribute("usuarioLogado")).usuarioLogado();
	}

}
