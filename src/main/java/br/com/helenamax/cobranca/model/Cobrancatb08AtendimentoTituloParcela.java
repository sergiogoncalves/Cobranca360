package br.com.helenamax.cobranca.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cobrancatb08_atendimento_titulo_parcela database table.
 * 
 */
@Entity
@Table(name="cobrancatb08_atendimento_titulo_parcela")
@NamedQuery(name="Cobrancatb08AtendimentoTituloParcela.findAll", query="SELECT c FROM Cobrancatb08AtendimentoTituloParcela c")
public class Cobrancatb08AtendimentoTituloParcela implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_atendimento_titulo_parcela")
	private int codigoAtendimentoTituloParcela;

	//bi-directional many-to-one association to Cobrancatb02TituloParcela
	@ManyToOne
	@JoinColumn(name="cobrancatb02_codigo_titulo_parcela")
	private Cobrancatb02TituloParcela cobrancatb02TituloParcela;

	//bi-directional many-to-one association to Cobrancatb07Atendimento
	@ManyToOne
	@JoinColumn(name="cobrancatb07_codigo_atendimento")
	private Cobrancatb07Atendimento cobrancatb07Atendimento;

	public Cobrancatb08AtendimentoTituloParcela() {
	}

	public int getCodigoAtendimentoTituloParcela() {
		return this.codigoAtendimentoTituloParcela;
	}

	public void setCodigoAtendimentoTituloParcela(int codigoAtendimentoTituloParcela) {
		this.codigoAtendimentoTituloParcela = codigoAtendimentoTituloParcela;
	}

	public Cobrancatb02TituloParcela getCobrancatb02TituloParcela() {
		return this.cobrancatb02TituloParcela;
	}

	public void setCobrancatb02TituloParcela(Cobrancatb02TituloParcela cobrancatb02TituloParcela) {
		this.cobrancatb02TituloParcela = cobrancatb02TituloParcela;
	}

	public Cobrancatb07Atendimento getCobrancatb07Atendimento() {
		return this.cobrancatb07Atendimento;
	}

	public void setCobrancatb07Atendimento(Cobrancatb07Atendimento cobrancatb07Atendimento) {
		this.cobrancatb07Atendimento = cobrancatb07Atendimento;
	}

}