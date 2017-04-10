package br.com.helenamax.cobranca.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the cobrancatb06_titulo_observacao_financeira database table.
 * 
 */
@Entity
@Table(name="cobrancatb06_titulo_observacao_financeira")
@NamedQuery(name="Cobrancatb06TituloObservacaoFinanceira.findAll", query="SELECT c FROM Cobrancatb06TituloObservacaoFinanceira c")
public class Cobrancatb06TituloObservacaoFinanceira implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_titulo_observacao_financeira")
	private int codigoTituloObservacaoFinanceira;

	@Temporal(TemporalType.DATE)
	@Column(name="data_reagendamento")
	private Date dataReagendamento;

	@Column(name="data_registro")
	private Timestamp dataRegistro;

	@Column(name="fila_devedores")
	private int filaDevedores;

	@Lob
	private String observacao;

	@Column(name="resultado_cobranca")
	private int resultadoCobranca;

	private int usuario;

	//bi-directional many-to-one association to Cobrancatb02TituloParcela
	@ManyToOne
	@JoinColumn(name="cobrancatb01_codigo_titulo")
	private Cobrancatb02TituloParcela cobrancatb02TituloParcela;

	public Cobrancatb06TituloObservacaoFinanceira() {
	}

	public int getCodigoTituloObservacaoFinanceira() {
		return this.codigoTituloObservacaoFinanceira;
	}

	public void setCodigoTituloObservacaoFinanceira(int codigoTituloObservacaoFinanceira) {
		this.codigoTituloObservacaoFinanceira = codigoTituloObservacaoFinanceira;
	}

	public Date getDataReagendamento() {
		return this.dataReagendamento;
	}

	public void setDataReagendamento(Date dataReagendamento) {
		this.dataReagendamento = dataReagendamento;
	}

	public Timestamp getDataRegistro() {
		return this.dataRegistro;
	}

	public void setDataRegistro(Timestamp dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public int getFilaDevedores() {
		return this.filaDevedores;
	}

	public void setFilaDevedores(int filaDevedores) {
		this.filaDevedores = filaDevedores;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public int getResultadoCobranca() {
		return this.resultadoCobranca;
	}

	public void setResultadoCobranca(int resultadoCobranca) {
		this.resultadoCobranca = resultadoCobranca;
	}

	public int getUsuario() {
		return this.usuario;
	}

	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}

	public Cobrancatb02TituloParcela getCobrancatb02TituloParcela() {
		return this.cobrancatb02TituloParcela;
	}

	public void setCobrancatb02TituloParcela(Cobrancatb02TituloParcela cobrancatb02TituloParcela) {
		this.cobrancatb02TituloParcela = cobrancatb02TituloParcela;
	}

}