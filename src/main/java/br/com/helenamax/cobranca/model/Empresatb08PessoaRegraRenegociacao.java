package br.com.helenamax.cobranca.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the empresatb08_pessoa_regra_renegociacao database table.
 * 
 */
@Entity
@Table(name="empresatb08_pessoa_regra_renegociacao")
@NamedQuery(name="Empresatb08PessoaRegraRenegociacao.findAll", query="SELECT e FROM Empresatb08PessoaRegraRenegociacao e")
public class Empresatb08PessoaRegraRenegociacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_pessoa_regra_renegociacao")
	private int codigoPessoaRegraRenegociacao;

	private String ativo;

	@Temporal(TemporalType.DATE)
	@Column(name="data_cadastro")
	private Date dataCadastro;

	private BigDecimal desconto;

	private BigDecimal honorario;

	@Column(name="isencao_juros")
	private BigDecimal isencaoJuros;

	@Column(name="isencao_multa")
	private BigDecimal isencaoMulta;

	private BigDecimal juro;

	@Column(name="maior_dia")
	private int maiorDia;

	@Column(name="maximo_parcelas")
	private int maximoParcelas;

	@Column(name="menor_dia")
	private int menorDia;

	@Column(name="minimo_parcelas")
	private int minimoParcelas;

	private BigDecimal mora;

	private BigDecimal multa;

	@Column(name="percentual_entrada")
	private BigDecimal percentualEntrada;

	@Column(name="tipo_juros")
	private String tipoJuros;

	@Column(name="valor_minimo_parcela")
	private BigDecimal valorMinimoParcela;
        
        private String descricao;

	//bi-directional many-to-one association to Empresatb02Pessoa
	@ManyToOne
	@JoinColumn(name="EMPRESATB02_CODIGO_PESSOA")
	private Empresatb02Pessoa empresatb02Pessoa;

	public Empresatb08PessoaRegraRenegociacao() {
	}

	public int getCodigoPessoaRegraRenegociacao() {
		return this.codigoPessoaRegraRenegociacao;
	}

	public void setCodigoPessoaRegraRenegociacao(int codigoPessoaRegraRenegociacao) {
		this.codigoPessoaRegraRenegociacao = codigoPessoaRegraRenegociacao;
	}

	public String getAtivo() {
		return this.ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public Date getDataCadastro() {
		return this.dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public BigDecimal getDesconto() {
		return this.desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public BigDecimal getHonorario() {
		return this.honorario;
	}

	public void setHonorario(BigDecimal honorario) {
		this.honorario = honorario;
	}

	public BigDecimal getIsencaoJuros() {
		return this.isencaoJuros;
	}

	public void setIsencaoJuros(BigDecimal isencaoJuros) {
		this.isencaoJuros = isencaoJuros;
	}

	public BigDecimal getIsencaoMulta() {
		return this.isencaoMulta;
	}

	public void setIsencaoMulta(BigDecimal isencaoMulta) {
		this.isencaoMulta = isencaoMulta;
	}

	public BigDecimal getJuro() {
		return this.juro;
	}

	public void setJuro(BigDecimal juro) {
		this.juro = juro;
	}

	public int getMaiorDia() {
		return this.maiorDia;
	}

	public void setMaiorDia(int maiorDia) {
		this.maiorDia = maiorDia;
	}

	public int getMaximoParcelas() {
		return this.maximoParcelas;
	}

	public void setMaximoParcelas(int maximoParcelas) {
		this.maximoParcelas = maximoParcelas;
	}

	public int getMenorDia() {
		return this.menorDia;
	}

	public void setMenorDia(int menorDia) {
		this.menorDia = menorDia;
	}

	public int getMinimoParcelas() {
		return this.minimoParcelas;
	}

	public void setMinimoParcelas(int minimoParcelas) {
		this.minimoParcelas = minimoParcelas;
	}

	public BigDecimal getMora() {
		return this.mora;
	}

	public void setMora(BigDecimal mora) {
		this.mora = mora;
	}

	public BigDecimal getMulta() {
		return this.multa;
	}

	public void setMulta(BigDecimal multa) {
		this.multa = multa;
	}

	public BigDecimal getPercentualEntrada() {
		return this.percentualEntrada;
	}

	public void setPercentualEntrada(BigDecimal percentualEntrada) {
		this.percentualEntrada = percentualEntrada;
	}

	public String getTipoJuros() {
		return this.tipoJuros;
	}

	public void setTipoJuros(String tipoJuros) {
		this.tipoJuros = tipoJuros;
	}

	public BigDecimal getValorMinimoParcela() {
		return this.valorMinimoParcela;
	}

	public void setValorMinimoParcela(BigDecimal valorMinimoParcela) {
		this.valorMinimoParcela = valorMinimoParcela;
	}

	public Empresatb02Pessoa getEmpresatb02Pessoa() {
		return this.empresatb02Pessoa;
	}

	public void setEmpresatb02Pessoa(Empresatb02Pessoa empresatb02Pessoa) {
		this.empresatb02Pessoa = empresatb02Pessoa;
	}

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.codigoPessoaRegraRenegociacao;
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
        final Empresatb08PessoaRegraRenegociacao other = (Empresatb08PessoaRegraRenegociacao) obj;
        if (this.codigoPessoaRegraRenegociacao != other.codigoPessoaRegraRenegociacao) {
            return false;
        }
        return true;
    }
    
    

}