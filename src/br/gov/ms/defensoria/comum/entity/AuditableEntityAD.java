package br.gov.ms.defensoria.comum.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AuditableEntityAD extends AuditableEntity {

	private static final long serialVersionUID = -8657862703168479145L;

	private String commonNameAD; // Nome
	private String loginAD;// Nome de identificação ou login
	private String raizEntradaAD;

	public String getCommonNameAD() {
		return commonNameAD;
	}

	public void setCommonNameAD(String commonNameAD) {
		this.commonNameAD = commonNameAD;
	}

	public String getLoginAD() {
		return loginAD;
	}

	public void setLoginAD(String loginAD) {
		this.loginAD = loginAD;
	}

	public String getRaizEntradaAD() {
		return raizEntradaAD;
	}

	public void setRaizEntradaAD(String raizEntradaAD) {
		this.raizEntradaAD = raizEntradaAD;
	}

}
