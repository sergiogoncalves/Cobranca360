package br.com.helenamax.cobranca.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the renegociacaotb02_renegociacao_parcela database table.
 * 
 */
@Entity
@Table(name="renegociacaotb02_renegociacao_parcela")
@NamedQuery(name="Renegociacaotb02RenegociacaoParcela.findAll", query="SELECT r FROM Renegociacaotb02RenegociacaoParcela r")
public class Renegociacaotb02RenegociacaoParcela implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_renegociacao_parcela")
	private int codigoRenegociacaoParcela;

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
	
    @Transient
    private int colunaAleatoria;

	public Renegociacaotb02RenegociacaoParcela() {
	}

	public int getCodigoRenegociacaoParcela() {
		return this.codigoRenegociacaoParcela;
	}

	public void setCodigoRenegociacaoParcela(int codigoRenegociacaoParcela) {
		this.codigoRenegociacaoParcela = codigoRenegociacaoParcela;
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
	        hash = 59 * hash + this.codigoRenegociacaoParcela;
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
	        final Renegociacaotb02RenegociacaoParcela other = (Renegociacaotb02RenegociacaoParcela) obj;
	        if (this.codigoRenegociacaoParcela != other.codigoRenegociacaoParcela) {
	            return false;
	        }
	        return true;
	    }
	    
	    /**
	     * @return the colunaAleatoria
	     */
	    public int getColunaAleatoria() {
	        return colunaAleatoria;
	    }

	    /**
	     * @param colunaAleatoria the colunaAleatoria to set
	     */
	    public void setColunaAleatoria(int colunaAleatoria) {
	        this.colunaAleatoria = colunaAleatoria;
	    }
	    
	        @PostLoad
	    public void setarAleatorio() {
	        setColunaAleatoria(getCodigoRenegociacaoParcela());

	    }

	

}