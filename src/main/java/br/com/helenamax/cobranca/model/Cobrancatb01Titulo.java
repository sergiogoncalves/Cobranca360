package br.com.helenamax.cobranca.model;

import br.com.helenamax.cobranca.util.HorasUtils;
import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the cobrancatb01_titulo database table.
 *
 */
@Entity
@Table(name = "cobrancatb01_titulo")
@NamedQuery(name = "Cobrancatb01Titulo.findAll", query = "SELECT c FROM Cobrancatb01Titulo c")
public class Cobrancatb01Titulo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_titulo")
    private int codigoTitulo;

    private String contrato;

    @Column(name = "data_criacao")
    private Timestamp dataCriacao;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_emissao")
    private Date dataEmissao;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_vencimento")
    private Date dataVencimento;

    private String identificacao;

    @Column(name = "usuario_credor")
    private int usuarioCredor;

    @Column(name = "valor_titulo")
    private BigDecimal valorTitulo;

    @Column(name = "numero_parcelas")
    private int numeroParcelas;

    //bi-directional many-to-one association to Cobrancatb03TituloTipo
    @ManyToOne
    @JoinColumn(name = "cobranca03_codigo_titulo_tipo")
    private Cobrancatb03TituloTipo cobrancatb03TituloTipo;

    //bi-directional many-to-one association to Empresatb02Pessoa
    @ManyToOne
    @JoinColumn(name = "credor")
    private Empresatb02Pessoa empresatb02PessoaCredor;

    //bi-directional many-to-one association to Empresatb02Pessoa
    @ManyToOne
    @JoinColumn(name = "devedor")
    private Empresatb02Pessoa empresatb02PessoaDevedor;

    //bi-directional many-to-one association to Geraltb01SituacaoFinanceira
    @ManyToOne
    @JoinColumn(name = "geraltb01_codigo_situacao")
    private Geraltb01SituacaoFinanceira geraltb01SituacaoFinanceira;

    //bi-directional many-to-one association to Cobrancatb02TituloParcela
    @OneToMany(mappedBy = "cobrancatb01Titulo")
    private List<Cobrancatb02TituloParcela> cobrancatb02TituloParcelas;


    public Cobrancatb01Titulo() {
    }

    public int getCodigoTitulo() {
        return this.codigoTitulo;
    }

    public void setCodigoTitulo(int codigoTitulo) {
        this.codigoTitulo = codigoTitulo;
    }

    public String getContrato() {
        return this.contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public Timestamp getDataCriacao() {
        return this.dataCriacao;
    }

    public void setDataCriacao(Timestamp dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataEmissao() {
        return this.dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Date getDataVencimento() {
        return this.dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getIdentificacao() {
        return this.identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public int getUsuarioCredor() {
        return this.usuarioCredor;
    }

    public void setUsuarioCredor(int usuarioCredor) {
        this.usuarioCredor = usuarioCredor;
    }

    public BigDecimal getValorTitulo() {
        return this.valorTitulo;
    }

    public void setValorTitulo(BigDecimal valorTitulo) {
        this.valorTitulo = valorTitulo;
    }

    public Cobrancatb03TituloTipo getCobrancatb03TituloTipo() {
        return this.cobrancatb03TituloTipo;
    }

    public void setCobrancatb03TituloTipo(Cobrancatb03TituloTipo cobrancatb03TituloTipo) {
        this.cobrancatb03TituloTipo = cobrancatb03TituloTipo;
    }

    public Geraltb01SituacaoFinanceira getGeraltb01SituacaoFinanceira() {
        return this.geraltb01SituacaoFinanceira;
    }

    public void setGeraltb01SituacaoFinanceira(Geraltb01SituacaoFinanceira geraltb01SituacaoFinanceira) {
        this.geraltb01SituacaoFinanceira = geraltb01SituacaoFinanceira;
    }

    public List<Cobrancatb02TituloParcela> getCobrancatb02TituloParcelas() {
        return this.cobrancatb02TituloParcelas;
    }

    public void setCobrancatb02TituloParcelas(List<Cobrancatb02TituloParcela> cobrancatb02TituloParcelas) {
        this.cobrancatb02TituloParcelas = cobrancatb02TituloParcelas;
    }

    public Cobrancatb02TituloParcela addCobrancatb02TituloParcela(Cobrancatb02TituloParcela cobrancatb02TituloParcela) {
        getCobrancatb02TituloParcelas().add(cobrancatb02TituloParcela);
        cobrancatb02TituloParcela.setCobrancatb01Titulo(this);

        return cobrancatb02TituloParcela;
    }

    public Cobrancatb02TituloParcela removeCobrancatb02TituloParcela(Cobrancatb02TituloParcela cobrancatb02TituloParcela) {
        getCobrancatb02TituloParcelas().remove(cobrancatb02TituloParcela);
        cobrancatb02TituloParcela.setCobrancatb01Titulo(null);

        return cobrancatb02TituloParcela;
    }

  

    /**
     * @return the numeroParcelas
     */
    public int getNumeroParcelas() {
        return numeroParcelas;
    }

    /**
     * @param numeroParcelas the numeroParcelas to set
     */
    public void setNumeroParcelas(int numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    /**
     * @return the empresatb02PessoaCredor
     */
    public Empresatb02Pessoa getEmpresatb02PessoaCredor() {
        return empresatb02PessoaCredor;
    }

    /**
     * @param empresatb02PessoaCredor the empresatb02PessoaCredor to set
     */
    public void setEmpresatb02PessoaCredor(Empresatb02Pessoa empresatb02PessoaCredor) {
        this.empresatb02PessoaCredor = empresatb02PessoaCredor;
    }

    /**
     * @return the empresatb02PessoaDevedor
     */
    public Empresatb02Pessoa getEmpresatb02PessoaDevedor() {
        return empresatb02PessoaDevedor;
    }

    /**
     * @param empresatb02PessoaDevedor the empresatb02PessoaDevedor to set
     */
    public void setEmpresatb02PessoaDevedor(Empresatb02Pessoa empresatb02PessoaDevedor) {
        this.empresatb02PessoaDevedor = empresatb02PessoaDevedor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.codigoTitulo;
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
        final Cobrancatb01Titulo other = (Cobrancatb01Titulo) obj;
        if (this.codigoTitulo != other.codigoTitulo) {
            return false;
        }
        return true;
    }
    
    @PrePersist
    public void atualizaHoras(){
        setDataCriacao(HorasUtils.retornarHoraAtual());    
    }
    
    

}
