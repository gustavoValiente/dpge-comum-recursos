package br.gov.ms.defensoria.comum.wrapper;

import javax.persistence.Embeddable;

/**
 * Classe com informações do controlador de domínio
 * 
 * @author Rafael Gouveia da Silva
 * @since JDK8 U45
 * @version 1.0
 * 
 **/
@Embeddable
public class UserActiveDirectory {
	private static final long serialVersionUID = 1L;

	private String cn; // Nome Comum

	private String samaccountname;// Nome de identificação ou login

	private String objetos;// Raiz de entrada no AD, nome, grupo, unidade
							// organizacional, *

	public UserActiveDirectory() {

	}

	public String getCn() {
		return cn;
	}

	public void setCn(String cn) {
		this.cn = cn;
	}

	public String getSamaccountname() {
		return samaccountname;
	}

	public void setSamaccountname(String samaccountname) {
		this.samaccountname = samaccountname;
	}

	public String getObjetos() {
		return objetos;
	}

	public void setObjetos(String objetos) {
		this.objetos = objetos;
	}

	@Override
	public String toString() {
		return "ActiveDirectoryWrapper [cn=" + cn + ", samaccountname=" + samaccountname + ", objetos=" + objetos + "]";
	}

}
