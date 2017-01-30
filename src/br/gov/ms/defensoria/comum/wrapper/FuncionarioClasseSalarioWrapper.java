package br.gov.ms.defensoria.comum.wrapper;

public class FuncionarioClasseSalarioWrapper {

	private String Classe;

	private Double SalarioBase;

	private Integer ano;

	public String getClasse() {
		return Classe;
	}

	public void setClasse(String classe) {
		Classe = classe;
	}

	public Double getSalarioBase() {
		return SalarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		SalarioBase = salarioBase;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	@Override
	public String toString() {
		return Classe + "/" + ano + " - R$ " + SalarioBase;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Classe == null) ? 0 : Classe.hashCode());
		result = prime * result + ((SalarioBase == null) ? 0 : SalarioBase.hashCode());
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FuncionarioClasseSalarioWrapper other = (FuncionarioClasseSalarioWrapper) obj;
		if (Classe == null) {
			if (other.Classe != null)
				return false;
		} else if (!Classe.equals(other.Classe))
			return false;
		if (SalarioBase == null) {
			if (other.SalarioBase != null)
				return false;
		} else if (!SalarioBase.equals(other.SalarioBase))
			return false;
		if (ano == null) {
			if (other.ano != null)
				return false;
		} else if (!ano.equals(other.ano))
			return false;
		return true;
	}

}
