package br.com.helenamax.cobranca.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the renegociacaotb01_renegociacao database table.
 *
 */
@Entity
@Table(name = "renegociacaotb01_renegociacao")
@NamedQuery(name = "Renegociacaotb01Renegociacao.findAll", query = "SELECT r FROM Renegociacaotb01Renegociacao r")
public class Renegociacaotb01Renegociacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_renegociacao")
    private int codigoRenegociacao;

    @Column(name = "data_renegociacao")
    private Timestamp dataRenegociacao;

    @Column(name = "fila_devedores")
    private int filaDevedores;

    @Column(name = "numero_parcelas")
    private int numeroParcelas;

    @Lob
    private String observacao;

    @Column(name = "valor_acordado")
    private BigDecimal valorAcordado;

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

    @Column(name = "valor_renegociado")
    private BigDecimal valorRenegociado;

    //bi-directional many-to-one association to Cobrancatb07Atendimento
    @ManyToOne
    @JoinColumn(name = "cobrancatb07_codigo_atendimento")
    private Cobrancatb07Atendimento cobrancatb07Atendimento;

    //bi-directional many-to-one association to Empresatb02Pessoa
    @ManyToOne
    @JoinColumn(name = "credor")
    private Empresatb02Pessoa credor;

    //bi-directional many-to-one association to Empresatb02Pessoa
    @ManyToOne
    @JoinColumn(name = "devedor")
    private Empresatb02Pessoa devedor;

    //bi-directional many-to-one association to Segurancatb01Usuario
    @ManyToOne
    @JoinColumn(name = "segurancatb01_codigo_usuario")
    private Segurancatb01Usuario segurancatb01Usuario;

    //bi-directional many-to-one association to Renegociacaotb02RenegociacaoParcela
    @OneToMany(mappedBy = "renegociacaotb01Renegociacao")
    private List<Renegociacaotb02RenegociacaoParcela> renegociacaotb02RenegociacaoParcelas;

    //bi-directional many-to-one association to Renegociacaotb03ParcelaRenegociada
    @OneToMany(mappedBy = "renegociacaotb01Renegociacao")
    private List<Renegociacaotb03ParcelaRenegociada> renegociacaotb03ParcelaRenegociadas;

    public Renegociacaotb01Renegociacao() {
    }

    public int getCodigoRenegociacao() {
        return this.codigoRenegociacao;
    }

    public void setCodigoRenegociacao(int codigoRenegociacao) {
        this.codigoRenegociacao = codigoRenegociacao;
    }

    public Timestamp getDataRenegociacao() {
        return this.dataRenegociacao;
    }

    public void setDataRenegociacao(Timestamp dataRenegociacao) {
        this.dataRenegociacao = dataRenegociacao;
    }

    public int getFilaDevedores() {
        return this.filaDevedores;
    }

    public void setFilaDevedores(int filaDevedores) {
        this.filaDevedores = filaDevedores;
    }

    public int getNumeroParcelas() {
        return this.numeroParcelas;
    }

    public void setNumeroParcelas(int numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public String getObservacao() {
        return this.observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public BigDecimal getValorAcordado() {
        return this.valorAcordado;
    }

    public void setValorAcordado(BigDecimal valorAcordado) {
        this.valorAcordado = valorAcordado;
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

    public BigDecimal getValorRenegociado() {
        return this.valorRenegociado;
    }

    public void setValorRenegociado(BigDecimal valorRenegociado) {
        this.valorRenegociado = valorRenegociado;
    }

    public Cobrancatb07Atendimento getCobrancatb07Atendimento() {
        return this.cobrancatb07Atendimento;
    }

    public void setCobrancatb07Atendimento(Cobrancatb07Atendimento cobrancatb07Atendimento) {
        this.cobrancatb07Atendimento = cobrancatb07Atendimento;
    }

    public Segurancatb01Usuario getSegurancatb01Usuario() {
        return this.segurancatb01Usuario;
    }

    public void setSegurancatb01Usuario(Segurancatb01Usuario segurancatb01Usuario) {
        this.segurancatb01Usuario = segurancatb01Usuario;
    }

    public List<Renegociacaotb02RenegociacaoParcela> getRenegociacaotb02RenegociacaoParcelas() {
        return this.renegociacaotb02RenegociacaoParcelas;
    }

    public void setRenegociacaotb02RenegociacaoParcelas(List<Renegociacaotb02RenegociacaoParcela> renegociacaotb02RenegociacaoParcelas) {
        this.renegociacaotb02RenegociacaoParcelas = renegociacaotb02RenegociacaoParcelas;
    }

    public Empresatb02Pessoa getCredor() {
        return credor;
    }

    public void setCredor(Empresatb02Pessoa credor) {
        this.credor = credor;
    }

    public Renegociacaotb02RenegociacaoParcela addRenegociacaotb02RenegociacaoParcela(Renegociacaotb02RenegociacaoParcela renegociacaotb02RenegociacaoParcela) {
        getRenegociacaotb02RenegociacaoParcelas().add(renegociacaotb02RenegociacaoParcela);
        renegociacaotb02RenegociacaoParcela.setRenegociacaotb01Renegociacao(this);

        return renegociacaotb02RenegociacaoParcela;
    }

    public Renegociacaotb02RenegociacaoParcela removeRenegociacaotb02RenegociacaoParcela(Renegociacaotb02RenegociacaoParcela renegociacaotb02RenegociacaoParcela) {
        getRenegociacaotb02RenegociacaoParcelas().remove(renegociacaotb02RenegociacaoParcela);
        renegociacaotb02RenegociacaoParcela.setRenegociacaotb01Renegociacao(null);

        return renegociacaotb02RenegociacaoParcela;
    }

    public List<Renegociacaotb03ParcelaRenegociada> getRenegociacaotb03ParcelaRenegociadas() {
        return this.renegociacaotb03ParcelaRenegociadas;
    }

    public void setRenegociacaotb03ParcelaRenegociadas(List<Renegociacaotb03ParcelaRenegociada> renegociacaotb03ParcelaRenegociadas) {
        this.renegociacaotb03ParcelaRenegociadas = renegociacaotb03ParcelaRenegociadas;
    }

    public Renegociacaotb03ParcelaRenegociada addRenegociacaotb03ParcelaRenegociada(Renegociacaotb03ParcelaRenegociada renegociacaotb03ParcelaRenegociada) {
        getRenegociacaotb03ParcelaRenegociadas().add(renegociacaotb03ParcelaRenegociada);
        renegociacaotb03ParcelaRenegociada.setRenegociacaotb01Renegociacao(this);

        return renegociacaotb03ParcelaRenegociada;
    }

    public Renegociacaotb03ParcelaRenegociada removeRenegociacaotb03ParcelaRenegociada(Renegociacaotb03ParcelaRenegociada renegociacaotb03ParcelaRenegociada) {
        getRenegociacaotb03ParcelaRenegociadas().remove(renegociacaotb03ParcelaRenegociada);
        renegociacaotb03ParcelaRenegociada.setRenegociacaotb01Renegociacao(null);

        return renegociacaotb03ParcelaRenegociada;
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

}
