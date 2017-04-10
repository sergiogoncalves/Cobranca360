package br.com.helenamax.cobranca.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cobrancatb09_atendimento_andamento database table.
 * 
 */
@Entity
@Table(name="cobrancatb09_atendimento_andamento")
@NamedQuery(name="Cobrancatb09AtendimentoAndamento.findAll", query="SELECT c FROM Cobrancatb09AtendimentoAndamento c")
public class Cobrancatb09AtendimentoAndamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_atendimento_andamento")
	private int codigoAtendimentoAndamento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_fim")
	private Date dataFim;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_inicio")
	private Date dataInicio;

	//bi-directional many-to-one association to Cobrancatb07Atendimento
	@ManyToOne
	@JoinColumn(name="cobrancatb07_codigo_atendimento")
	private Cobrancatb07Atendimento cobrancatb07Atendimento;

	//bi-directional many-to-one association to Cobrancatb10AtendimentoSituacao
	@ManyToOne
	@JoinColumn(name="cobrancatb10_codigo_atendimento_situacao")
	private Cobrancatb10AtendimentoSituacao cobrancatb10AtendimentoSituacao;

	public Cobrancatb09AtendimentoAndamento() {
	}

	public int getCodigoAtendimentoAndamento() {
		return this.codigoAtendimentoAndamento;
	}

	public void setCodigoAtendimentoAndamento(int codigoAtendimentoAndamento) {
		this.codigoAtendimentoAndamento = codigoAtendimentoAndamento;
	}

	public Date getDataFim() {
		return this.dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Date getDataInicio() {
		return this.dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Cobrancatb07Atendimento getCobrancatb07Atendimento() {
		return this.cobrancatb07Atendimento;
	}

	public void setCobrancatb07Atendimento(Cobrancatb07Atendimento cobrancatb07Atendimento) {
		this.cobrancatb07Atendimento = cobrancatb07Atendimento;
	}

	public Cobrancatb10AtendimentoSituacao getCobrancatb10AtendimentoSituacao() {
		return this.cobrancatb10AtendimentoSituacao;
	}

	public void setCobrancatb10AtendimentoSituacao(Cobrancatb10AtendimentoSituacao cobrancatb10AtendimentoSituacao) {
		this.cobrancatb10AtendimentoSituacao = cobrancatb10AtendimentoSituacao;
	}

}