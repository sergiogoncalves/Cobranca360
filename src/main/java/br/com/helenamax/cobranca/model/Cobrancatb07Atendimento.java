package br.com.helenamax.cobranca.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cobrancatb07_atendimento database table.
 * 
 */
@Entity
@Table(name="cobrancatb07_atendimento")
@NamedQuery(name="Cobrancatb07Atendimento.findAll", query="SELECT c FROM Cobrancatb07Atendimento c")
public class Cobrancatb07Atendimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_atendimento")
	private int codigoAtendimento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_atendimento")
	private Date dataAtendimento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_retorno")
	private Date dataRetorno;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_retorno_efetuado")
	private Date dataRetornoEfetuado;

	@Lob
	private String observacao;

	@Column(name="retorno_efetuado")
	private byte retornoEfetuado;

	//bi-directional many-to-one association to Cobrancatb10AtendimentoSituacao
	@ManyToOne
	@JoinColumn(name="cobrancatb10_codigo_atendimento_situacao")
	private Cobrancatb10AtendimentoSituacao cobrancatb10AtendimentoSituacao;

	//bi-directional many-to-one association to Empresatb02Pessoa
	@ManyToOne
	@JoinColumn(name="credor")
	private Empresatb02Pessoa credor;

	//bi-directional many-to-one association to Empresatb02Pessoa
	@ManyToOne
	@JoinColumn(name="devedor")
	private Empresatb02Pessoa devedor;

	//bi-directional many-to-one association to Filatb01Fila
	@ManyToOne
	@JoinColumn(name="filatb01_codigo_fila")
	private Filatb01Fila filatb01Fila;

	//bi-directional many-to-one association to Segurancatb01Usuario
	@ManyToOne
	@JoinColumn(name="segurancatb01_codigo_usuario")
	private Segurancatb01Usuario segurancatb01Usuario;

	//bi-directional many-to-one association to Cobrancatb08AtendimentoTituloParcela
	@OneToMany(mappedBy="cobrancatb07Atendimento")
	private List<Cobrancatb08AtendimentoTituloParcela> cobrancatb08AtendimentoTituloParcelas;

	//bi-directional many-to-one association to Cobrancatb09AtendimentoAndamento
	@OneToMany(mappedBy="cobrancatb07Atendimento")
	private List<Cobrancatb09AtendimentoAndamento> cobrancatb09AtendimentoAndamentos;

	//bi-directional many-to-one association to Renegociacaotb01Renegociacao
	@OneToMany(mappedBy="cobrancatb07Atendimento")
	private List<Renegociacaotb01Renegociacao> renegociacaotb01Renegociacaos;

	public Cobrancatb07Atendimento() {
	}

	public int getCodigoAtendimento() {
		return this.codigoAtendimento;
	}

	public void setCodigoAtendimento(int codigoAtendimento) {
		this.codigoAtendimento = codigoAtendimento;
	}

	public Date getDataAtendimento() {
		return this.dataAtendimento;
	}

	public void setDataAtendimento(Date dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}

	public Date getDataRetorno() {
		return this.dataRetorno;
	}

	public void setDataRetorno(Date dataRetorno) {
		this.dataRetorno = dataRetorno;
	}

	public Date getDataRetornoEfetuado() {
		return this.dataRetornoEfetuado;
	}

	public void setDataRetornoEfetuado(Date dataRetornoEfetuado) {
		this.dataRetornoEfetuado = dataRetornoEfetuado;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public byte getRetornoEfetuado() {
		return this.retornoEfetuado;
	}

	public void setRetornoEfetuado(byte retornoEfetuado) {
		this.retornoEfetuado = retornoEfetuado;
	}

	public Cobrancatb10AtendimentoSituacao getCobrancatb10AtendimentoSituacao() {
		return this.cobrancatb10AtendimentoSituacao;
	}

	public void setCobrancatb10AtendimentoSituacao(Cobrancatb10AtendimentoSituacao cobrancatb10AtendimentoSituacao) {
		this.cobrancatb10AtendimentoSituacao = cobrancatb10AtendimentoSituacao;
	}

	public Filatb01Fila getFilatb01Fila() {
		return this.filatb01Fila;
	}

	public void setFilatb01Fila(Filatb01Fila filatb01Fila) {
		this.filatb01Fila = filatb01Fila;
	}

	public Segurancatb01Usuario getSegurancatb01Usuario() {
		return this.segurancatb01Usuario;
	}

	public void setSegurancatb01Usuario(Segurancatb01Usuario segurancatb01Usuario) {
		this.segurancatb01Usuario = segurancatb01Usuario;
	}

	public List<Cobrancatb08AtendimentoTituloParcela> getCobrancatb08AtendimentoTituloParcelas() {
		return this.cobrancatb08AtendimentoTituloParcelas;
	}

	public void setCobrancatb08AtendimentoTituloParcelas(List<Cobrancatb08AtendimentoTituloParcela> cobrancatb08AtendimentoTituloParcelas) {
		this.cobrancatb08AtendimentoTituloParcelas = cobrancatb08AtendimentoTituloParcelas;
	}

	public Cobrancatb08AtendimentoTituloParcela addCobrancatb08AtendimentoTituloParcela(Cobrancatb08AtendimentoTituloParcela cobrancatb08AtendimentoTituloParcela) {
		getCobrancatb08AtendimentoTituloParcelas().add(cobrancatb08AtendimentoTituloParcela);
		cobrancatb08AtendimentoTituloParcela.setCobrancatb07Atendimento(this);

		return cobrancatb08AtendimentoTituloParcela;
	}

	public Cobrancatb08AtendimentoTituloParcela removeCobrancatb08AtendimentoTituloParcela(Cobrancatb08AtendimentoTituloParcela cobrancatb08AtendimentoTituloParcela) {
		getCobrancatb08AtendimentoTituloParcelas().remove(cobrancatb08AtendimentoTituloParcela);
		cobrancatb08AtendimentoTituloParcela.setCobrancatb07Atendimento(null);

		return cobrancatb08AtendimentoTituloParcela;
	}

	public List<Cobrancatb09AtendimentoAndamento> getCobrancatb09AtendimentoAndamentos() {
		return this.cobrancatb09AtendimentoAndamentos;
	}

	public void setCobrancatb09AtendimentoAndamentos(List<Cobrancatb09AtendimentoAndamento> cobrancatb09AtendimentoAndamentos) {
		this.cobrancatb09AtendimentoAndamentos = cobrancatb09AtendimentoAndamentos;
	}

	public Cobrancatb09AtendimentoAndamento addCobrancatb09AtendimentoAndamento(Cobrancatb09AtendimentoAndamento cobrancatb09AtendimentoAndamento) {
		getCobrancatb09AtendimentoAndamentos().add(cobrancatb09AtendimentoAndamento);
		cobrancatb09AtendimentoAndamento.setCobrancatb07Atendimento(this);

		return cobrancatb09AtendimentoAndamento;
	}

	public Cobrancatb09AtendimentoAndamento removeCobrancatb09AtendimentoAndamento(Cobrancatb09AtendimentoAndamento cobrancatb09AtendimentoAndamento) {
		getCobrancatb09AtendimentoAndamentos().remove(cobrancatb09AtendimentoAndamento);
		cobrancatb09AtendimentoAndamento.setCobrancatb07Atendimento(null);

		return cobrancatb09AtendimentoAndamento;
	}

	public List<Renegociacaotb01Renegociacao> getRenegociacaotb01Renegociacaos() {
		return this.renegociacaotb01Renegociacaos;
	}

	public void setRenegociacaotb01Renegociacaos(List<Renegociacaotb01Renegociacao> renegociacaotb01Renegociacaos) {
		this.renegociacaotb01Renegociacaos = renegociacaotb01Renegociacaos;
	}

	public Renegociacaotb01Renegociacao addRenegociacaotb01Renegociacao(Renegociacaotb01Renegociacao renegociacaotb01Renegociacao) {
		getRenegociacaotb01Renegociacaos().add(renegociacaotb01Renegociacao);
		renegociacaotb01Renegociacao.setCobrancatb07Atendimento(this);

		return renegociacaotb01Renegociacao;
	}

	public Renegociacaotb01Renegociacao removeRenegociacaotb01Renegociacao(Renegociacaotb01Renegociacao renegociacaotb01Renegociacao) {
		getRenegociacaotb01Renegociacaos().remove(renegociacaotb01Renegociacao);
		renegociacaotb01Renegociacao.setCobrancatb07Atendimento(null);

		return renegociacaotb01Renegociacao;
	}

    /**
     * @return the credor
     */
    public Empresatb02Pessoa getCredor() {
        return credor;
    }

    /**
     * @param credor the credor to set
     */
    public void setCredor(Empresatb02Pessoa credor) {
        this.credor = credor;
    }

    /**
     * @return the devedor
     */
    public Empresatb02Pessoa getDevedor() {
        return devedor;
    }

    /**
     * @param devedor the devedor to set
     */
    public void setDevedor(Empresatb02Pessoa devedor) {
        this.devedor = devedor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.codigoAtendimento;
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
        final Cobrancatb07Atendimento other = (Cobrancatb07Atendimento) obj;
        if (this.codigoAtendimento != other.codigoAtendimento) {
            return false;
        }
        return true;
    }
    
    
    

}