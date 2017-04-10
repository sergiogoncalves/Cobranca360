package br.com.helenamax.cobranca.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the renegociacaotb03_parcela_renegociada database table.
 * 
 */
@Entity
@Table(name="renegociacaotb03_parcela_renegociada")
@NamedQuery(name="Renegociacaotb03ParcelaRenegociada.findAll", query="SELECT r FROM Renegociacaotb03ParcelaRenegociada r")
public class Renegociacaotb03ParcelaRenegociada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_parcela_renegociada")
	private int codigoParcelaRenegociada;

	//bi-directional many-to-one association to Cobrancatb02TituloParcela
	@ManyToOne
	@JoinColumn(name="cobrancatb02_codigo_titulo_parcela")
	private Cobrancatb02TituloParcela cobrancatb02TituloParcela;

	//bi-directional many-to-one association to Geraltb01SituacaoFinanceira
	@ManyToOne
	@JoinColumn(name="geraltb01_codigo_situacao")
	private Geraltb01SituacaoFinanceira geraltb01SituacaoFinanceira;

	//bi-directional many-to-one association to Renegociacaotb01Renegociacao
	@ManyToOne
	@JoinColumn(name="renegociacaotb01_codigo_renegociacao")
	private Renegociacaotb01Renegociacao renegociacaotb01Renegociacao;

	public Renegociacaotb03ParcelaRenegociada() {
	}

	public int getCodigoParcelaRenegociada() {
		return this.codigoParcelaRenegociada;
	}

	public void setCodigoParcelaRenegociada(int codigoParcelaRenegociada) {
		this.codigoParcelaRenegociada = codigoParcelaRenegociada;
	}

	public Cobrancatb02TituloParcela getCobrancatb02TituloParcela() {
		return this.cobrancatb02TituloParcela;
	}

	public void setCobrancatb02TituloParcela(Cobrancatb02TituloParcela cobrancatb02TituloParcela) {
		this.cobrancatb02TituloParcela = cobrancatb02TituloParcela;
	}

	public Geraltb01SituacaoFinanceira getGeraltb01SituacaoFinanceira() {
		return this.geraltb01SituacaoFinanceira;
	}

	public void setGeraltb01SituacaoFinanceira(Geraltb01SituacaoFinanceira geraltb01SituacaoFinanceira) {
		this.geraltb01SituacaoFinanceira = geraltb01SituacaoFinanceira;
	}

	public Renegociacaotb01Renegociacao getRenegociacaotb01Renegociacao() {
		return this.renegociacaotb01Renegociacao;
	}

	public void setRenegociacaotb01Renegociacao(Renegociacaotb01Renegociacao renegociacaotb01Renegociacao) {
		this.renegociacaotb01Renegociacao = renegociacaotb01Renegociacao;
	}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.codigoParcelaRenegociada;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Renegociacaotb03ParcelaRenegociada other = (Renegociacaotb03ParcelaRenegociada) obj;
        if (this.codigoParcelaRenegociada != other.codigoParcelaRenegociada) {
            return false;
        }
        return true;
    }

}