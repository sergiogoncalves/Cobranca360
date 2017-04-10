package br.com.helenamax.cobranca.model;

import br.com.helenamax.cobranca.util.HorasUtils;
import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the empresatb09_empresa_regra_renegociacao database table.
 * 
 */
@Entity
@Table(name="empresatb09_empresa_regra_renegociacao")
public class Empresatb09EmpresaRegraRenegociacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_pessoa_empresa_regra_renegociacao")
	private int codigoPessoaEmpresaRegraRenegociacao;

	private boolean ativo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_cadastro")
	private Date dataCadastro;

	private BigDecimal desconto;

	private BigDecimal honorarios;

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

	//bi-directional many-to-one association to Empresatb01Empresa
	@ManyToOne
	@JoinColumn(name="empresatb01_codigo_empresa")
	private Empresatb01Empresa empresatb01Empresa;

	public Empresatb09EmpresaRegraRenegociacao() {
	}

	public int getCodigoPessoaEmpresaRegraRenegociacao() {
		return this.codigoPessoaEmpresaRegraRenegociacao;
	}

	public void setCodigoPessoaEmpresaRegraRenegociacao(int codigoPessoaEmpresaRegraRenegociacao) {
		this.codigoPessoaEmpresaRegraRenegociacao = codigoPessoaEmpresaRegraRenegociacao;
	}

	public boolean getAtivo() {
		return this.ativo;
	}

	public void setAtivo(boolean ativo) {
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

	public BigDecimal getHonorarios() {
		return this.honorarios;
	}

	public void setHonorarios(BigDecimal honorarios) {
		this.honorarios = honorarios;
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

	public Empresatb01Empresa getEmpresatb01Empresa() {
		return this.empresatb01Empresa;
	}

	public void setEmpresatb01Empresa(Empresatb01Empresa empresatb01Empresa) {
		this.empresatb01Empresa = empresatb01Empresa;
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
        int hash = 7;
        hash = 79 * hash + this.codigoPessoaEmpresaRegraRenegociacao;
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
        final Empresatb09EmpresaRegraRenegociacao other = (Empresatb09EmpresaRegraRenegociacao) obj;
        if (this.codigoPessoaEmpresaRegraRenegociacao != other.codigoPessoaEmpresaRegraRenegociacao) {
            return false;
        }
        return true;
    }
    
    

@PrePersist
private void setarData(){
    setDataCadastro(HorasUtils.retornarHoraAtual());
}
}