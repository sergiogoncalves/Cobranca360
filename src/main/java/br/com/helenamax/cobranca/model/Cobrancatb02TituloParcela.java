package br.com.helenamax.cobranca.model;

import br.com.helenamax.cobranca.util.HorasUtils;
import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;
import org.joda.time.DateTime;

/**
 * The persistent class for the cobrancatb02_titulo_parcela database table.
 *
 */
@Entity
@Table(name = "cobrancatb02_titulo_parcela")
@NamedQuery(name = "Cobrancatb02TituloParcela.findAll", query = "SELECT c FROM Cobrancatb02TituloParcela c")
public class Cobrancatb02TituloParcela implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_titulo_parcela")
    private int codigoTituloParcela;

    @Column(name = "data_criacao")
    private Timestamp dataCriacao;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_vencimento")
    private Date dataVencimento;

    @Column(name = "numero_parcela")
    private int numeroParcela;

    private int usuario;

    @Column(name = "valor_desconto")
    private BigDecimal valorDesconto;

    @Column(name = "valor_honorario")
    private BigDecimal valorHonorario;

    @Column(name = "valor_juros")
    private BigDecimal valorJuros;

    @Column(name = "valor_mora")
    private BigDecimal valorMora;

    @Column(name = "valor_multa")
    private BigDecimal valorMulta;

    @Column(name = "valor_original")
    private BigDecimal valorOriginal;

    @Column(name = "valor_parcela")
    private BigDecimal valorParcela;

    @Column(name = "valor_recebido")
    private BigDecimal valorRecebido;

    @Column(name = "valor_saldo")
    private BigDecimal valorSaldo;

    @Transient
    private int colunaAleatoria;

    @Transient
    private Cobrancatb05TituloParcelaCheque cobrancatb05TituloParcelaCheque;

    @Transient
    private int diasEmAtraso;

    //bi-directional many-to-one association to Cobrancatb01Titulo
    @ManyToOne
    @JoinColumn(name = "cobrancatb01_titulo_codigo")
    private Cobrancatb01Titulo cobrancatb01Titulo;

    //bi-directional many-to-one association to Geraltb01SituacaoFinanceira
    @ManyToOne
    @JoinColumn(name = "geraltb01_codigo_situacao")
    private Geraltb01SituacaoFinanceira geraltb01SituacaoFinanceira;

    //bi-directional many-to-one association to Cobrancatb04TituloParcelaLancamento
    @OneToMany(mappedBy = "cobrancatb02TituloParcela")
    private List<Cobrancatb04TituloParcelaLancamento> cobrancatb04TituloParcelaLancamentos;

    //bi-directional many-to-one association to Cobrancatb05TituloParcelaCheque
    @OneToMany(mappedBy = "cobrancatb02TituloParcela")
    private List<Cobrancatb05TituloParcelaCheque> cobrancatb05TituloParcelaCheques;

    //bi-directional many-to-one association to Cobrancatb06TituloObservacaoFinanceira
    @OneToMany(mappedBy = "cobrancatb02TituloParcela")
    private List<Cobrancatb06TituloObservacaoFinanceira> cobrancatb06TituloObservacaoFinanceiras;

    //bi-directional many-to-one association to Renegociacaotb03ParcelaRenegociada
    @OneToMany(mappedBy = "cobrancatb02TituloParcela")
    private List<Renegociacaotb03ParcelaRenegociada> renegociacaotb03ParcelaRenegociadas;

    public Cobrancatb02TituloParcela() {
    }

    public int getCodigoTituloParcela() {
        return this.codigoTituloParcela;
    }

    public void setCodigoTituloParcela(int codigoTituloParcela) {
        this.codigoTituloParcela = codigoTituloParcela;
    }

    public Timestamp getDataCriacao() {
        return this.dataCriacao;
    }

    public void setDataCriacao(Timestamp dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataVencimento() {
        return this.dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public int getNumeroParcela() {
        return this.numeroParcela;
    }

    public void setNumeroParcela(int numeroParcela) {
        this.numeroParcela = numeroParcela;
    }

    public int getUsuario() {
        return this.usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public BigDecimal getValorDesconto() {
        return this.valorDesconto;
    }

    public void setValorDesconto(BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public BigDecimal getValorHonorario() {
        return this.valorHonorario;
    }

    public void setValorHonorario(BigDecimal valorHonorario) {
        this.valorHonorario = valorHonorario;
    }

    public BigDecimal getValorJuros() {
        return this.valorJuros;
    }

    public void setValorJuros(BigDecimal valorJuros) {
        this.valorJuros = valorJuros;
    }

    public BigDecimal getValorMora() {
        return this.valorMora;
    }

    public void setValorMora(BigDecimal valorMora) {
        this.valorMora = valorMora;
    }

    public BigDecimal getValorMulta() {
        return this.valorMulta;
    }

    public void setValorMulta(BigDecimal valorMulta) {
        this.valorMulta = valorMulta;
    }

    public BigDecimal getValorOriginal() {
        return this.valorOriginal;
    }

    public void setValorOriginal(BigDecimal valorOriginal) {
        this.valorOriginal = valorOriginal;
    }

    public BigDecimal getValorParcela() {
        return this.valorParcela;
    }

    public void setValorParcela(BigDecimal valorParcela) {
        this.valorParcela = valorParcela;
    }

    public BigDecimal getValorRecebido() {
        return this.valorRecebido;
    }

    public void setValorRecebido(BigDecimal valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

    public BigDecimal getValorSaldo() {
        return this.valorSaldo;
    }

    public void setValorSaldo(BigDecimal valorSaldo) {
        this.valorSaldo = valorSaldo;
    }

    public Cobrancatb01Titulo getCobrancatb01Titulo() {
        return this.cobrancatb01Titulo;
    }

    public void setCobrancatb01Titulo(Cobrancatb01Titulo cobrancatb01Titulo) {
        this.cobrancatb01Titulo = cobrancatb01Titulo;
    }

    public Geraltb01SituacaoFinanceira getGeraltb01SituacaoFinanceira() {
        return this.geraltb01SituacaoFinanceira;
    }

    public void setGeraltb01SituacaoFinanceira(Geraltb01SituacaoFinanceira geraltb01SituacaoFinanceira) {
        this.geraltb01SituacaoFinanceira = geraltb01SituacaoFinanceira;
    }

    public List<Cobrancatb04TituloParcelaLancamento> getCobrancatb04TituloParcelaLancamentos() {
        return this.cobrancatb04TituloParcelaLancamentos;
    }

    public void setCobrancatb04TituloParcelaLancamentos(List<Cobrancatb04TituloParcelaLancamento> cobrancatb04TituloParcelaLancamentos) {
        this.cobrancatb04TituloParcelaLancamentos = cobrancatb04TituloParcelaLancamentos;
    }

    public Cobrancatb04TituloParcelaLancamento addCobrancatb04TituloParcelaLancamento(Cobrancatb04TituloParcelaLancamento cobrancatb04TituloParcelaLancamento) {
        getCobrancatb04TituloParcelaLancamentos().add(cobrancatb04TituloParcelaLancamento);
        cobrancatb04TituloParcelaLancamento.setCobrancatb02TituloParcela(this);

        return cobrancatb04TituloParcelaLancamento;
    }

    public Cobrancatb04TituloParcelaLancamento removeCobrancatb04TituloParcelaLancamento(Cobrancatb04TituloParcelaLancamento cobrancatb04TituloParcelaLancamento) {
        getCobrancatb04TituloParcelaLancamentos().remove(cobrancatb04TituloParcelaLancamento);
        cobrancatb04TituloParcelaLancamento.setCobrancatb02TituloParcela(null);

        return cobrancatb04TituloParcelaLancamento;
    }

    public List<Cobrancatb05TituloParcelaCheque> getCobrancatb05TituloParcelaCheques() {
        return this.cobrancatb05TituloParcelaCheques;
    }

    public void setCobrancatb05TituloParcelaCheques(List<Cobrancatb05TituloParcelaCheque> cobrancatb05TituloParcelaCheques) {
        this.cobrancatb05TituloParcelaCheques = cobrancatb05TituloParcelaCheques;
    }

    public Cobrancatb05TituloParcelaCheque addCobrancatb05TituloParcelaCheque(Cobrancatb05TituloParcelaCheque cobrancatb05TituloParcelaCheque) {
        getCobrancatb05TituloParcelaCheques().add(cobrancatb05TituloParcelaCheque);
        cobrancatb05TituloParcelaCheque.setCobrancatb02TituloParcela(this);

        return cobrancatb05TituloParcelaCheque;
    }

    public Cobrancatb05TituloParcelaCheque removeCobrancatb05TituloParcelaCheque(Cobrancatb05TituloParcelaCheque cobrancatb05TituloParcelaCheque) {
        getCobrancatb05TituloParcelaCheques().remove(cobrancatb05TituloParcelaCheque);
        cobrancatb05TituloParcelaCheque.setCobrancatb02TituloParcela(null);

        return cobrancatb05TituloParcelaCheque;
    }

    public List<Cobrancatb06TituloObservacaoFinanceira> getCobrancatb06TituloObservacaoFinanceiras() {
        return this.cobrancatb06TituloObservacaoFinanceiras;
    }

    public void setCobrancatb06TituloObservacaoFinanceiras(List<Cobrancatb06TituloObservacaoFinanceira> cobrancatb06TituloObservacaoFinanceiras) {
        this.cobrancatb06TituloObservacaoFinanceiras = cobrancatb06TituloObservacaoFinanceiras;
    }

    public Cobrancatb06TituloObservacaoFinanceira addCobrancatb06TituloObservacaoFinanceira(Cobrancatb06TituloObservacaoFinanceira cobrancatb06TituloObservacaoFinanceira) {
        getCobrancatb06TituloObservacaoFinanceiras().add(cobrancatb06TituloObservacaoFinanceira);
        cobrancatb06TituloObservacaoFinanceira.setCobrancatb02TituloParcela(this);

        return cobrancatb06TituloObservacaoFinanceira;
    }

    public Cobrancatb06TituloObservacaoFinanceira removeCobrancatb06TituloObservacaoFinanceira(Cobrancatb06TituloObservacaoFinanceira cobrancatb06TituloObservacaoFinanceira) {
        getCobrancatb06TituloObservacaoFinanceiras().remove(cobrancatb06TituloObservacaoFinanceira);
        cobrancatb06TituloObservacaoFinanceira.setCobrancatb02TituloParcela(null);

        return cobrancatb06TituloObservacaoFinanceira;
    }

    public List<Renegociacaotb03ParcelaRenegociada> getRenegociacaotb03ParcelaRenegociadas() {
        return this.renegociacaotb03ParcelaRenegociadas;
    }

    public void setRenegociacaotb03ParcelaRenegociadas(List<Renegociacaotb03ParcelaRenegociada> renegociacaotb03ParcelaRenegociadas) {
        this.renegociacaotb03ParcelaRenegociadas = renegociacaotb03ParcelaRenegociadas;
    }

    public Renegociacaotb03ParcelaRenegociada addRenegociacaotb03ParcelaRenegociada(Renegociacaotb03ParcelaRenegociada renegociacaotb03ParcelaRenegociada) {
        getRenegociacaotb03ParcelaRenegociadas().add(renegociacaotb03ParcelaRenegociada);
        renegociacaotb03ParcelaRenegociada.setCobrancatb02TituloParcela(this);

        return renegociacaotb03ParcelaRenegociada;
    }

    public Renegociacaotb03ParcelaRenegociada removeRenegociacaotb03ParcelaRenegociada(Renegociacaotb03ParcelaRenegociada renegociacaotb03ParcelaRenegociada) {
        getRenegociacaotb03ParcelaRenegociadas().remove(renegociacaotb03ParcelaRenegociada);
        renegociacaotb03ParcelaRenegociada.setCobrancatb02TituloParcela(null);

        return renegociacaotb03ParcelaRenegociada;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.codigoTituloParcela;
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
        final Cobrancatb02TituloParcela other = (Cobrancatb02TituloParcela) obj;
        if (this.codigoTituloParcela != other.codigoTituloParcela) {
            return false;
        }
        return true;
    }

    @PostLoad
    public void setarAleatorio() {
        setColunaAleatoria(getCodigoTituloParcela());
        //new Date(HorasUtils.retornarHoraAtual().getTime())
        
        DateTime inicio = new DateTime(getDataVencimento());
        DateTime fim = new DateTime(HorasUtils.retornarHoraAtual());
        
        setDiasEmAtraso(HorasUtils.retornarDiferencaEntreDatas(inicio, fim));
    }

    /**
     * @return the cobrancatb05TituloParcelaCheque
     */
    public Cobrancatb05TituloParcelaCheque getCobrancatb05TituloParcelaCheque() {
        return cobrancatb05TituloParcelaCheque;
    }

    /**
     * @param cobrancatb05TituloParcelaCheque the
     * cobrancatb05TituloParcelaCheque to set
     */
    public void setCobrancatb05TituloParcelaCheque(Cobrancatb05TituloParcelaCheque cobrancatb05TituloParcelaCheque) {
        this.cobrancatb05TituloParcelaCheque = cobrancatb05TituloParcelaCheque;
    }

    /**
     * @return the diasEmAtraso
     */
    public int getDiasEmAtraso() {
        return diasEmAtraso;
    }

    /**
     * @param diasEmAtraso the diasEmAtraso to set
     */
    public void setDiasEmAtraso(int diasEmAtraso) {
        this.diasEmAtraso = diasEmAtraso;
    }

}
