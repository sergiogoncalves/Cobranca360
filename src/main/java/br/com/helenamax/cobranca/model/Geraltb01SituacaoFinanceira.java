package br.com.helenamax.cobranca.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the geraltb01_situacao_financeira database table.
 * 
 */
@Entity
@Table(name="geraltb01_situacao_financeira")
@NamedQuery(name="Geraltb01SituacaoFinanceira.findAll", query="SELECT g FROM Geraltb01SituacaoFinanceira g")
public class Geraltb01SituacaoFinanceira implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_situacao")
	private int codigoSituacao;

	private String descricao;

	private String sigla;

	//bi-directional many-to-one association to Cobrancatb01Titulo
	@OneToMany(mappedBy="geraltb01SituacaoFinanceira")
	private List<Cobrancatb01Titulo> cobrancatb01Titulos;

	//bi-directional many-to-one association to Cobrancatb02TituloParcela
	@OneToMany(mappedBy="geraltb01SituacaoFinanceira")
	private List<Cobrancatb02TituloParcela> cobrancatb02TituloParcelas;

	//bi-directional many-to-one association to Renegociacaotb02RenegociacaoParcela
	@OneToMany(mappedBy="geraltb01SituacaoFinanceira")
	private List<Renegociacaotb02RenegociacaoParcela> renegociacaotb02RenegociacaoParcelas;

	//bi-directional many-to-one association to Renegociacaotb03ParcelaRenegociada
	@OneToMany(mappedBy="geraltb01SituacaoFinanceira")
	private List<Renegociacaotb03ParcelaRenegociada> renegociacaotb03ParcelaRenegociadas;

	public Geraltb01SituacaoFinanceira() {
	}

	public int getCodigoSituacao() {
		return this.codigoSituacao;
	}

	public void setCodigoSituacao(int codigoSituacao) {
		this.codigoSituacao = codigoSituacao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<Cobrancatb01Titulo> getCobrancatb01Titulos() {
		return this.cobrancatb01Titulos;
	}

	public void setCobrancatb01Titulos(List<Cobrancatb01Titulo> cobrancatb01Titulos) {
		this.cobrancatb01Titulos = cobrancatb01Titulos;
	}

	public Cobrancatb01Titulo addCobrancatb01Titulo(Cobrancatb01Titulo cobrancatb01Titulo) {
		getCobrancatb01Titulos().add(cobrancatb01Titulo);
		cobrancatb01Titulo.setGeraltb01SituacaoFinanceira(this);

		return cobrancatb01Titulo;
	}

	public Cobrancatb01Titulo removeCobrancatb01Titulo(Cobrancatb01Titulo cobrancatb01Titulo) {
		getCobrancatb01Titulos().remove(cobrancatb01Titulo);
		cobrancatb01Titulo.setGeraltb01SituacaoFinanceira(null);

		return cobrancatb01Titulo;
	}

	public List<Cobrancatb02TituloParcela> getCobrancatb02TituloParcelas() {
		return this.cobrancatb02TituloParcelas;
	}

	public void setCobrancatb02TituloParcelas(List<Cobrancatb02TituloParcela> cobrancatb02TituloParcelas) {
		this.cobrancatb02TituloParcelas = cobrancatb02TituloParcelas;
	}

	public Cobrancatb02TituloParcela addCobrancatb02TituloParcela(Cobrancatb02TituloParcela cobrancatb02TituloParcela) {
		getCobrancatb02TituloParcelas().add(cobrancatb02TituloParcela);
		cobrancatb02TituloParcela.setGeraltb01SituacaoFinanceira(this);

		return cobrancatb02TituloParcela;
	}

	public Cobrancatb02TituloParcela removeCobrancatb02TituloParcela(Cobrancatb02TituloParcela cobrancatb02TituloParcela) {
		getCobrancatb02TituloParcelas().remove(cobrancatb02TituloParcela);
		cobrancatb02TituloParcela.setGeraltb01SituacaoFinanceira(null);

		return cobrancatb02TituloParcela;
	}

	public List<Renegociacaotb02RenegociacaoParcela> getRenegociacaotb02RenegociacaoParcelas() {
		return this.renegociacaotb02RenegociacaoParcelas;
	}

	public void setRenegociacaotb02RenegociacaoParcelas(List<Renegociacaotb02RenegociacaoParcela> renegociacaotb02RenegociacaoParcelas) {
		this.renegociacaotb02RenegociacaoParcelas = renegociacaotb02RenegociacaoParcelas;
	}

	public Renegociacaotb02RenegociacaoParcela addRenegociacaotb02RenegociacaoParcela(Renegociacaotb02RenegociacaoParcela renegociacaotb02RenegociacaoParcela) {
		getRenegociacaotb02RenegociacaoParcelas().add(renegociacaotb02RenegociacaoParcela);
		renegociacaotb02RenegociacaoParcela.setGeraltb01SituacaoFinanceira(this);

		return renegociacaotb02RenegociacaoParcela;
	}

	public Renegociacaotb02RenegociacaoParcela removeRenegociacaotb02RenegociacaoParcela(Renegociacaotb02RenegociacaoParcela renegociacaotb02RenegociacaoParcela) {
		getRenegociacaotb02RenegociacaoParcelas().remove(renegociacaotb02RenegociacaoParcela);
		renegociacaotb02RenegociacaoParcela.setGeraltb01SituacaoFinanceira(null);

		return renegociacaotb02RenegociacaoParcela;
	}

	public List<Renegociacaotb03ParcelaRenegociada> getRenegociacaotb03ParcelaRenegociadas() {
		return this.renegociacaotb03ParcelaRenegociadas;
	}

	public void setRenegociacaotb03ParcelaRenegociadas(List<Renegociacaotb03ParcelaRenegociada> renegociacaotb03ParcelaRenegociadas) {
		this.renegociacaotb03ParcelaRenegociadas = renegociacaotb03ParcelaRenegociadas;
	}

	public Renegociacaotb03ParcelaRenegociada addRenegociacaotb03ParcelaRenegociada(Renegociacaotb03ParcelaRenegociada renegociacaotb03ParcelaRenegociada) {
		getRenegociacaotb03ParcelaRenegociadas().add(renegociacaotb03ParcelaRenegociada);
		renegociacaotb03ParcelaRenegociada.setGeraltb01SituacaoFinanceira(this);

		return renegociacaotb03ParcelaRenegociada;
	}

	public Renegociacaotb03ParcelaRenegociada removeRenegociacaotb03ParcelaRenegociada(Renegociacaotb03ParcelaRenegociada renegociacaotb03ParcelaRenegociada) {
		getRenegociacaotb03ParcelaRenegociadas().remove(renegociacaotb03ParcelaRenegociada);
		renegociacaotb03ParcelaRenegociada.setGeraltb01SituacaoFinanceira(null);

		return renegociacaotb03ParcelaRenegociada;
	}

}