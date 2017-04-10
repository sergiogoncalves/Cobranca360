package br.com.helenamax.cobranca.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the empresatb10_pessoa_responsavel database table.
 * 
 */
@Entity
@Table(name="empresatb10_pessoa_responsavel")
@NamedQuery(name="Empresatb10PessoaResponsavel.findAll", query="SELECT e FROM Empresatb10PessoaResponsavel e")
public class Empresatb10PessoaResponsavel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_pessoa_responsavel")
	private int codigoPessoaResponsavel;

	//bi-directional many-to-one association to Empresatb02Pessoa
	@ManyToOne
	@JoinColumn(name="empresatb02_pessoa_codigo")
	private Empresatb02Pessoa empresatb02Pessoa1;

	//bi-directional many-to-one association to Empresatb02Pessoa
	@ManyToOne
	@JoinColumn(name="empresatb02_pessoa_codigo_responsavel")
	private Empresatb02Pessoa empresatb02Pessoa2;

	public Empresatb10PessoaResponsavel() {
	}

	public int getCodigoPessoaResponsavel() {
		return this.codigoPessoaResponsavel;
	}

	public void setCodigoPessoaResponsavel(int codigoPessoaResponsavel) {
		this.codigoPessoaResponsavel = codigoPessoaResponsavel;
	}

	public Empresatb02Pessoa getEmpresatb02Pessoa1() {
		return this.empresatb02Pessoa1;
	}

	public void setEmpresatb02Pessoa1(Empresatb02Pessoa empresatb02Pessoa1) {
		this.empresatb02Pessoa1 = empresatb02Pessoa1;
	}

	public Empresatb02Pessoa getEmpresatb02Pessoa2() {
		return this.empresatb02Pessoa2;
	}

	public void setEmpresatb02Pessoa2(Empresatb02Pessoa empresatb02Pessoa2) {
		this.empresatb02Pessoa2 = empresatb02Pessoa2;
	}

}