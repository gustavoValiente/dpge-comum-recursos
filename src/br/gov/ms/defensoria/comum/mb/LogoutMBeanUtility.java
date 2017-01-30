package br.gov.ms.defensoria.comum.mb;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;

import br.gov.ms.defensoria.comum.util.FacesUtilRecurso;

@SessionScoped
@Named
public class LogoutMBeanUtility implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Realiza Logout.
	 * 
	 * @throws LoginException
	 */
	public void logout() {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		req.getSession().invalidate();
		FacesContext facesContext = FacesUtilRecurso.getFacesContext();
		UIViewRoot root = facesContext.getApplication().getViewHandler().createView(facesContext, "/login.xhtml");
		facesContext.setViewRoot(root);
		facesContext.renderResponse();
	}

}
