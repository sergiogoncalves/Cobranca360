package br.com.helenamax.cobranca.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cobrancatb05_titulo_parcela_cheque database table.
 * 
 */
@Entity
@Table(name="cobrancatb05_titulo_parcela_cheque")
@NamedQuery(name="Cobrancatb05TituloParcelaCheque.findAll", query="SELECT c FROM Cobrancatb05TituloParcelaCheque c")
public class Cobrancatb05TituloParcelaCheque implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_titulo_parcela_cheque")
	private int codigoTituloParcelaCheque;

	private String agencia;

	private String alinea;

	private String banco;

	private String compensacao;

	private String conta;

	@Column(name="data_reimplante")
	private String dataReimplante;

	@Temporal(TemporalType.DATE)
	@Column(name="data_restauracao")
	private Date dataRestauracao;

	private String digito;

	@Column(name="numero_cheque")
	private String numeroCheque;

	private String razao;

	private String tipificacao;

	@Column(name="tipo_ocorrencia")
	private String tipoOcorrencia;

	//bi-directional many-to-one association to Cobrancatb02TituloParcela
	@ManyToOne
	@JoinColumn(name="cobrancatb02_codigo_titulo_parcela")
	private Cobrancatb02TituloParcela cobrancatb02TituloParcela;

	public Cobrancatb05TituloParcelaCheque() {
	}

	public int getCodigoTituloParcelaCheque() {
		return this.codigoTituloParcelaCheque;
	}

	public void setCodigoTituloParcelaCheque(int codigoTituloParcelaCheque) {
		this.codigoTituloParcelaCheque = codigoTituloParcelaCheque;
	}

	public String getAgencia() {
		return this.agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getAlinea() {
		return this.alinea;
	}

	public void setAlinea(String alinea) {
		this.alinea = alinea;
	}

	public String getBanco() {
		return this.banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getCompensacao() {
		return this.compensacao;
	}

	public void setCompensacao(String compensacao) {
		this.compensacao = compensacao;
	}

	public String getConta() {
		return this.conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getDataReimplante() {
		return this.dataReimplante;
	}

	public void setDataReimplante(String dataReimplante) {
		this.dataReimplante = dataReimplante;
	}

	public Date getDataRestauracao() {
		return this.dataRestauracao;
	}

	public void setDataRestauracao(Date dataRestauracao) {
		this.dataRestauracao = dataRestauracao;
	}

	public String getDigito() {
		return this.digito;
	}

	public void setDigito(String digito) {
		this.digito = digito;
	}

	public String getNumeroCheque() {
		return this.numeroCheque;
	}

	public void setNumeroCheque(String numeroCheque) {
		this.numeroCheque = numeroCheque;
	}

	public String getRazao() {
		return this.razao;
	}

	public void setRazao(String razao) {
		this.razao = razao;
	}

	public String getTipificacao() {
		return this.tipificacao;
	}

	public void setTipificacao(String tipificacao) {
		this.tipificacao = tipificacao;
	}

	public String getTipoOcorrencia() {
		return this.tipoOcorrencia;
	}

	public void setTipoOcorrencia(String tipoOcorrencia) {
		this.tipoOcorrencia = tipoOcorrencia;
	}

	public Cobrancatb02TituloParcela getCobrancatb02TituloParcela() {
		return this.cobrancatb02TituloParcela;
	}

	public void setCobrancatb02TituloParcela(Cobrancatb02TituloParcela cobrancatb02TituloParcela) {
		this.cobrancatb02TituloParcela = cobrancatb02TituloParcela;
	}

}