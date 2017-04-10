package br.com.helenamax.cobranca.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the cobrancatb04_titulo_parcela_lancamento database table.
 * 
 */
@Entity
@Table(name="cobrancatb04_titulo_parcela_lancamento")
@NamedQuery(name="Cobrancatb04TituloParcelaLancamento.findAll", query="SELECT c FROM Cobrancatb04TituloParcelaLancamento c")
public class Cobrancatb04TituloParcelaLancamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_titulo_parcela_lancamento")
	private int codigoTituloParcelaLancamento;

	@Column(name="caixa_lancamento")
	private int caixaLancamento;

	@Temporal(TemporalType.DATE)
	@Column(name="data_lancamento")
	private Date dataLancamento;

	@Column(name="valor_desconto")
	private BigDecimal valorDesconto;

	@Column(name="valor_juros")
	private BigDecimal valorJuros;

	@Column(name="valor_lancamento")
	private BigDecimal valorLancamento;

	@Column(name="valor_multa")
	private BigDecimal valorMulta;

	//bi-directional many-to-one association to Cobrancatb02TituloParcela
	@ManyToOne
	@JoinColumn(name="cobrancatb02_codigo_titulo_parcela")
	private Cobrancatb02TituloParcela cobrancatb02TituloParcela;

	public Cobrancatb04TituloParcelaLancamento() {
	}

	public int getCodigoTituloParcelaLancamento() {
		return this.codigoTituloParcelaLancamento;
	}

	public void setCodigoTituloParcelaLancamento(int codigoTituloParcelaLancamento) {
		this.codigoTituloParcelaLancamento = codigoTituloParcelaLancamento;
	}

	public int getCaixaLancamento() {
		return this.caixaLancamento;
	}

	public void setCaixaLancamento(int caixaLancamento) {
		this.caixaLancamento = caixaLancamento;
	}

	public Date getDataLancamento() {
		return this.dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public BigDecimal getValorDesconto() {
		return this.valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public BigDecimal getValorJuros() {
		return this.valorJuros;
	}

	public void setValorJuros(BigDecimal valorJuros) {
		this.valorJuros = valorJuros;
	}

	public BigDecimal getValorLancamento() {
		return this.valorLancamento;
	}

	public void setValorLancamento(BigDecimal valorLancamento) {
		this.valorLancamento = valorLancamento;
	}

	public BigDecimal getValorMulta() {
		return this.valorMulta;
	}

	public void setValorMulta(BigDecimal valorMulta) {
		this.valorMulta = valorMulta;
	}

	public Cobrancatb02TituloParcela getCobrancatb02TituloParcela() {
		return this.cobrancatb02TituloParcela;
	}

	public void setCobrancatb02TituloParcela(Cobrancatb02TituloParcela cobrancatb02TituloParcela) {
		this.cobrancatb02TituloParcela = cobrancatb02TituloParcela;
	}

}