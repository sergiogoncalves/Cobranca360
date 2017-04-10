package br.com.helenamax.cobranca.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the empresatb04_pessoa_juridica database table.
 * 
 */
@Entity
@Table(name="empresatb04_pessoa_juridica")
@NamedQuery(name="Empresatb04PessoaJuridica.findAll", query="SELECT e FROM Empresatb04PessoaJuridica e")
public class Empresatb04PessoaJuridica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_pessoa_juridica")
	private int codigoPessoaJuridica;

	private String cnpj;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_cadastro")
	private Date dataCadastro;

	@Column(name="flg_tipo")
	private String flgTipo;

	@Column(name="inscricao_estadual")
	private String inscricaoEstadual;

	@Column(name="inscricao_municipal")
	private String inscricaoMunicipal;

	@Column(name="nome_fantasia")
	private String nomeFantasia;

	@Column(name="ramo_atividade")
	private int ramoAtividade;

	//bi-directional many-to-one association to Empresatb02Pessoa
	@ManyToOne
	@JoinColumn(name="empresatb02_codigo_pessoa")
	private Empresatb02Pessoa empresatb02Pessoa;

	public Empresatb04PessoaJuridica() {
	}

	public int getCodigoPessoaJuridica() {
		return this.codigoPessoaJuridica;
	}

	public void setCodigoPessoaJuridica(int codigoPessoaJuridica) {
		this.codigoPessoaJuridica = codigoPessoaJuridica;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Date getDataCadastro() {
		return this.dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getFlgTipo() {
		return this.flgTipo;
	}

	public void setFlgTipo(String flgTipo) {
		this.flgTipo = flgTipo;
	}

	public String getInscricaoEstadual() {
		return this.inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getInscricaoMunicipal() {
		return this.inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public String getNomeFantasia() {
		return this.nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public int getRamoAtividade() {
		return this.ramoAtividade;
	}

	public void setRamoAtividade(int ramoAtividade) {
		this.ramoAtividade = ramoAtividade;
	}

	public Empresatb02Pessoa getEmpresatb02Pessoa() {
		return this.empresatb02Pessoa;
	}

	public void setEmpresatb02Pessoa(Empresatb02Pessoa empresatb02Pessoa) {
		this.empresatb02Pessoa = empresatb02Pessoa;
	}

}