package br.gov.ms.defensoria.comum.wrapper;

import java.util.Date;

import javax.persistence.Embedded;

import br.gov.ms.defensoria.comum.embeded.Endereco;
import br.gov.ms.defensoria.comum.generics.GenericEntityImpl;
import br.gov.ms.defensoria.comum.util.SimpleValidate;

public class FuncionarioWrapper extends GenericEntityImpl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String nome;

	private String matricula;

	private String email;

	private String cpf;

	private String sexo;

	private Date DataAdmissao;

	private String nomeCargo;

	private String classenivel;

	private String cargonivel;

	private String tipoServidor;

	private Date dataCriacao;

	private Date dataNascimento;

	private String cor;

	private String estadoCivil;

	private String grupoSanguineo;

	private String fatorRH;

	private String escolaridade;

	@Embedded
	private Endereco endereco;

	private String tipoFolha;

	private String codBanco;

	private String agencia;

	private String contaBancaria;

	private String dvAgencia;

	private String dvContaBancaria;

	private String ctps;

	private String pisPasep;

	private String tpConta;

	private String funcionarioCBO;

	private String nomeConjuge;

	private Date dataNascConjuge;

	private String docOrgao;

	private String rg;

	private String tituloNum;

	private String tituloZona;

	private String tituloSecao;

	private String pai;

	private String mae;

	private String idNacionalidade;

	private String idNaturalidade;

	private String idEstadoCivil;

	private String nomeLotacao;

	private String tipoAdmissao;

	private Date dataDemissao;

	private String tipodemissao;

	private Date dataEmissaoRg;

	private String certidaoMilitar;

	private String tipoVinculo;
	
	private String categoriaFolha;

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDataAdmissao() {
		return DataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		DataAdmissao = dataAdmissao;
	}

	public String getTipoServidor() {
		return tipoServidor;
	}

	public void setTipoServidor(String tipoServidor) {
		this.tipoServidor = tipoServidor;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Endereco getEndereco() {
		if (endereco == null) {
			endereco = new Endereco();
		}
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getNomeCargo() {
		return nomeCargo;
	}

	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}

	public String getClassenivel() {
		return classenivel;
	}

	public void setClassenivel(String classenivel) {
		this.classenivel = classenivel;
	}

	public String getCargonivel() {
		return cargonivel;
	}

	public void setCargonivel(String cargonivel) {
		this.cargonivel = cargonivel;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getGrupoSanguineo() {
		return grupoSanguineo;
	}

	public void setGrupoSanguineo(String grupoSanguineo) {
		this.grupoSanguineo = grupoSanguineo;
	}

	public String getFatorRH() {
		return fatorRH;
	}

	public void setFatorRH(String fatorRH) {
		this.fatorRH = fatorRH;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public String getTipoFolha() {
		return tipoFolha;
	}

	public void setTipoFolha(String tipoFolha) {
		this.tipoFolha = tipoFolha;
	}

	@Override
	public Long getId() {
		return Long.valueOf(id.toString());
	}

	public String getCodBanco() {
		return codBanco;
	}

	public void setCodBanco(String codBanco) {
		this.codBanco = codBanco;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getContaBancaria() {
		return contaBancaria;
	}

	public void setContaBancaria(String contaBancaria) {
		this.contaBancaria = contaBancaria;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCtps() {
		return ctps;
	}

	public void setCtps(String ctps) {
		this.ctps = ctps;
	}

	public String getPisPasep() {
		return pisPasep;
	}

	public void setPisPasep(String pisPasep) {
		this.pisPasep = pisPasep;
	}

	public String getTpConta() {
		return tpConta;
	}

	public void setTpConta(String tpConta) {
		this.tpConta = tpConta;
	}

	public String getFuncionarioCBO() {
		return funcionarioCBO;
	}

	public void setFuncionarioCBO(String funcionarioCBO) {
		this.funcionarioCBO = funcionarioCBO;
	}

	public String getNomeConjuge() {
		return nomeConjuge;
	}

	public void setNomeConjuge(String nomeConjuge) {
		this.nomeConjuge = nomeConjuge;
	}

	public Date getDataNascConjuge() {
		return dataNascConjuge;
	}

	public void setDataNascConjuge(Date dataNascConjuge) {
		this.dataNascConjuge = dataNascConjuge;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getDocOrgao() {
		return docOrgao;
	}

	public void setDocOrgao(String docOrgao) {
		this.docOrgao = docOrgao;
	}

	public String getTituloNum() {
		return tituloNum;
	}

	public void setTituloNum(String tituloNum) {
		this.tituloNum = tituloNum;
	}

	public String getTituloZona() {
		return tituloZona;
	}

	public void setTituloZona(String tituloZona) {
		this.tituloZona = tituloZona;
	}

	public String getTituloSecao() {
		return tituloSecao;
	}

	public void setTituloSecao(String tituloSecao) {
		this.tituloSecao = tituloSecao;
	}

	public String getPai() {
		return pai;
	}

	public void setPai(String pai) {
		this.pai = pai;
	}

	public String getMae() {
		return mae;
	}

	public void setMae(String mae) {
		this.mae = mae;
	}

	public String getIdNacionalidade() {
		return idNacionalidade;
	}

	public void setIdNacionalidade(String idNacionalidade) {
		this.idNacionalidade = idNacionalidade;
	}

	public String getIdEstadoCivil() {
		return idEstadoCivil;
	}

	public void setIdEstadoCivil(String idEstadoCivil) {
		this.idEstadoCivil = idEstadoCivil;
	}

	public String getIdNaturalidade() {
		return idNaturalidade;
	}

	public void setIdNaturalidade(String idNaturalidade) {
		this.idNaturalidade = idNaturalidade;
	}

	@Override
	public String toString() {

		if (SimpleValidate.isNullOrBlank(classenivel)) {
			return "Mat. " + matricula + " - " + nome + " - Cargo - " + nomeCargo;
		}
		return "Mat. " + matricula + " - " + nome + " - Classe - " + classenivel + " - Cargo - " + nomeCargo;

	}

	public String getNomeLotacao() {
		return nomeLotacao;
	}

	public void setNomeLotacao(String nomeLotacao) {
		this.nomeLotacao = nomeLotacao;
	}

	public String getDvAgencia() {
		return dvAgencia;
	}

	public void setDvAgencia(String dvAgencia) {
		this.dvAgencia = dvAgencia;
	}

	public String getDvContaBancaria() {
		return dvContaBancaria;
	}

	public void setDvContaBancaria(String dvContaBancaria) {
		this.dvContaBancaria = dvContaBancaria;
	}

	public String getTipoAdmissao() {
		return tipoAdmissao;
	}

	public void setTipoAdmissao(String tipoAdmissao) {
		this.tipoAdmissao = tipoAdmissao;
	}

	public Date getDataDemissao() {
		return dataDemissao;
	}

	public void setDataDemissao(Date dataDemissao) {
		this.dataDemissao = dataDemissao;
	}

	public String getTipodemissao() {
		return tipodemissao;
	}

	public void setTipodemissao(String tipodemissao) {
		this.tipodemissao = tipodemissao;
	}

	public Date getDataEmissaoRg() {
		return dataEmissaoRg;
	}

	public void setDataEmissaoRg(Date dataEmissaoRg) {
		this.dataEmissaoRg = dataEmissaoRg;
	}

	public String getCertidaoMilitar() {
		return certidaoMilitar;
	}

	public void setCertidaoMilitar(String certidaoMilitar) {
		this.certidaoMilitar = certidaoMilitar;
	}

	public String getTipoVinculo() {
		return tipoVinculo;
	}

	public void setTipoVinculo(String tipoVinculo) {
		this.tipoVinculo = tipoVinculo;
	}

	public String getCategoriaFolha() {
		return categoriaFolha;
	}

	public void setCategoriaFolha(String categoriaFolha) {
		this.categoriaFolha = categoriaFolha;
	}

}
