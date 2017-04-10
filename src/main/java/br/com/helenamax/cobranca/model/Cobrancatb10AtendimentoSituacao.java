package br.com.helenamax.cobranca.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cobrancatb10_atendimento_situacao database table.
 * 
 */
@Entity
@Table(name="cobrancatb10_atendimento_situacao")
@NamedQuery(name="Cobrancatb10AtendimentoSituacao.findAll", query="SELECT c FROM Cobrancatb10AtendimentoSituacao c")
public class Cobrancatb10AtendimentoSituacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_atendimento_situacao")
	private int codigoAtendimentoSituacao;

	private String descricao;

	private String sigla;

	//bi-directional many-to-one association to Cobrancatb07Atendimento
	@OneToMany(mappedBy="cobrancatb10AtendimentoSituacao")
	private List<Cobrancatb07Atendimento> cobrancatb07Atendimentos;

	//bi-directional many-to-one association to Cobrancatb09AtendimentoAndamento
	@OneToMany(mappedBy="cobrancatb10AtendimentoSituacao")
	private List<Cobrancatb09AtendimentoAndamento> cobrancatb09AtendimentoAndamentos;

	public Cobrancatb10AtendimentoSituacao() {
	}

	public int getCodigoAtendimentoSituacao() {
		return this.codigoAtendimentoSituacao;
	}

	public void setCodigoAtendimentoSituacao(int codigoAtendimentoSituacao) {
		this.codigoAtendimentoSituacao = codigoAtendimentoSituacao;
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

	public List<Cobrancatb07Atendimento> getCobrancatb07Atendimentos() {
		return this.cobrancatb07Atendimentos;
	}

	public void setCobrancatb07Atendimentos(List<Cobrancatb07Atendimento> cobrancatb07Atendimentos) {
		this.cobrancatb07Atendimentos = cobrancatb07Atendimentos;
	}

	public Cobrancatb07Atendimento addCobrancatb07Atendimento(Cobrancatb07Atendimento cobrancatb07Atendimento) {
		getCobrancatb07Atendimentos().add(cobrancatb07Atendimento);
		cobrancatb07Atendimento.setCobrancatb10AtendimentoSituacao(this);

		return cobrancatb07Atendimento;
	}

	public Cobrancatb07Atendimento removeCobrancatb07Atendimento(Cobrancatb07Atendimento cobrancatb07Atendimento) {
		getCobrancatb07Atendimentos().remove(cobrancatb07Atendimento);
		cobrancatb07Atendimento.setCobrancatb10AtendimentoSituacao(null);

		return cobrancatb07Atendimento;
	}

	public List<Cobrancatb09AtendimentoAndamento> getCobrancatb09AtendimentoAndamentos() {
		return this.cobrancatb09AtendimentoAndamentos;
	}

	public void setCobrancatb09AtendimentoAndamentos(List<Cobrancatb09AtendimentoAndamento> cobrancatb09AtendimentoAndamentos) {
		this.cobrancatb09AtendimentoAndamentos = cobrancatb09AtendimentoAndamentos;
	}

	public Cobrancatb09AtendimentoAndamento addCobrancatb09AtendimentoAndamento(Cobrancatb09AtendimentoAndamento cobrancatb09AtendimentoAndamento) {
		getCobrancatb09AtendimentoAndamentos().add(cobrancatb09AtendimentoAndamento);
		cobrancatb09AtendimentoAndamento.setCobrancatb10AtendimentoSituacao(this);

		return cobrancatb09AtendimentoAndamento;
	}

	public Cobrancatb09AtendimentoAndamento removeCobrancatb09AtendimentoAndamento(Cobrancatb09AtendimentoAndamento cobrancatb09AtendimentoAndamento) {
		getCobrancatb09AtendimentoAndamentos().remove(cobrancatb09AtendimentoAndamento);
		cobrancatb09AtendimentoAndamento.setCobrancatb10AtendimentoSituacao(null);

		return cobrancatb09AtendimentoAndamento;
	}

}