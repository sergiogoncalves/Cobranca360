package br.com.helenamax.cobranca.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the filatb03_fila_devedor database table.
 * 
 */
@Entity
@Table(name="filatb03_fila_devedor")
@NamedQuery(name="Filatb03FilaDevedor.findAll", query="SELECT f FROM Filatb03FilaDevedor f")
public class Filatb03FilaDevedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_fila_devedor")
	private int codigoFilaDevedor;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_fim_atendimento")
	private Date dataFimAtendimento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_inicio_atendimento")
	private Date dataInicioAtendimento;

	//bi-directional many-to-one association to Empresatb02Pessoa
	@ManyToOne
	@JoinColumn(name="empresatb02_pessoa")
	private Empresatb02Pessoa devedor;

	//bi-directional many-to-one association to Filatb01Fila
	@ManyToOne
	@JoinColumn(name="filatb01_codigo_fila")
	private Filatb01Fila filatb01Fila;

	//bi-directional many-to-one association to Filatb04FilaTituloSituacao
	@ManyToOne
	@JoinColumn(name="filatb04_codigo_fila_titulo_situacao")
	private Filatb04FilaTituloSituacao filatb04FilaTituloSituacao;

	public Filatb03FilaDevedor() {
	}

	public int getCodigoFilaDevedor() {
		return this.codigoFilaDevedor;
	}

	public void setCodigoFilaDevedor(int codigoFilaDevedor) {
		this.codigoFilaDevedor = codigoFilaDevedor;
	}

	public Date getDataFimAtendimento() {
		return this.dataFimAtendimento;
	}

	public void setDataFimAtendimento(Date dataFimAtendimento) {
		this.dataFimAtendimento = dataFimAtendimento;
	}

	public Date getDataInicioAtendimento() {
		return this.dataInicioAtendimento;
	}

	public void setDataInicioAtendimento(Date dataInicioAtendimento) {
		this.dataInicioAtendimento = dataInicioAtendimento;
	}

	public Empresatb02Pessoa getDevedor() {
		return this.devedor;
	}

	public void setDevedor(Empresatb02Pessoa empresatb02PessoaBean) {
		this.devedor = empresatb02PessoaBean;
	}

	public Filatb01Fila getFilatb01Fila() {
		return this.filatb01Fila;
	}

	public void setFilatb01Fila(Filatb01Fila filatb01Fila) {
		this.filatb01Fila = filatb01Fila;
	}

	public Filatb04FilaTituloSituacao getFilatb04FilaTituloSituacao() {
		return this.filatb04FilaTituloSituacao;
	}

	public void setFilatb04FilaTituloSituacao(Filatb04FilaTituloSituacao filatb04FilaTituloSituacao) {
		this.filatb04FilaTituloSituacao = filatb04FilaTituloSituacao;
	}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.codigoFilaDevedor;
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
        final Filatb03FilaDevedor other = (Filatb03FilaDevedor) obj;
        if (this.codigoFilaDevedor != other.codigoFilaDevedor) {
            return false;
        }
        return true;
    }
        
        

}