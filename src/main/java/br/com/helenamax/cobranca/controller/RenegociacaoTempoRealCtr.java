/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.controller;

import br.com.helenamax.cobranca.model.Cobrancatb07Atendimento;
import br.com.helenamax.cobranca.model.Renegociacaotb01Renegociacao;
import br.com.helenamax.cobranca.service.Cobrancatb07AtendimentoSrv;
import br.com.helenamax.cobranca.service.Renegociacaotb01RenegociacaoSrv;
import br.com.helenamax.cobranca.util.HorasUtils;
import br.com.helenamax.cobranca.util.Validador;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author 005712431
 */
@Named
@ViewScoped
public class RenegociacaoTempoRealCtr implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Cobrancatb07AtendimentoSrv cobrancatb07AtendimentoSrv;

    @Inject
    private UsuarioSessaoCtr usuarioSessaoCtr;

    @Inject
    private Renegociacaotb01RenegociacaoSrv renegociacaotb01RenegociacaoSrv;

    private List<Cobrancatb07Atendimento> cobrancatb07AtendimentoColl;

    private List<Renegociacaotb01Renegociacao> renegociacaotb01RenegociacaoColl;

    private List<Cobrancatb07Atendimento> cobrancaEmAtendimentoColl;

    private List<Cobrancatb07Atendimento> cobrancaPausadaColl;

    private List<Cobrancatb07Atendimento> cobrancaFinalizadaColl;

    private List<Cobrancatb07Atendimento> cobrancaInvalidadaColl;

    private int totalAtendimentos;

    private int totalRenegociacoes;

    private BigDecimal totalRenegociado;
    
    private Date dataTempoReal = HorasUtils.retornarHoraAtual();

    public void atualizarDados() {
        totalAtendimentos = 0;
        listarTotalAtendimentos();
        listarRenegociacoes();
        totalizarRenegociacoes();
        separarTiposAtendimentos();

    }

    public void listarTotalAtendimentos() {

        if (!Validador.isListValida(cobrancatb07AtendimentoColl)) {
            cobrancatb07AtendimentoColl = new ArrayList<>();
        }

        cobrancatb07AtendimentoColl.clear();

        cobrancatb07AtendimentoColl = cobrancatb07AtendimentoSrv.buscarPorEmpresaData(usuarioSessaoCtr.getEmpresatb01Empresa(), dataTempoReal);

        totalAtendimentos = cobrancatb07AtendimentoColl.size();
    }

    public void listarRenegociacoes() {
        if (!Validador.isListValida(renegociacaotb01RenegociacaoColl)) {
            renegociacaotb01RenegociacaoColl = new ArrayList<>();
        }
        renegociacaotb01RenegociacaoColl.clear();

        renegociacaotb01RenegociacaoColl = renegociacaotb01RenegociacaoSrv.listarEmpresaData(dataTempoReal);

        setTotalRenegociacoes(renegociacaotb01RenegociacaoColl.size());

    }

    public void totalizarRenegociacoes() {
        totalRenegociado = new BigDecimal(0);

        for (Renegociacaotb01Renegociacao vo : renegociacaotb01RenegociacaoColl) {
            totalRenegociado = totalRenegociado.add(vo.getValorAcordado());
        }

    }

    public void separarTiposAtendimentos() {

        if (!Validador.isListValida(cobrancaEmAtendimentoColl)) {
            cobrancaEmAtendimentoColl = new ArrayList<>();
        }

        if (!Validador.isListValida(cobrancaPausadaColl)) {
            cobrancaPausadaColl = new ArrayList<>();
        }

        if (!Validador.isListValida(cobrancaFinalizadaColl)) {
            cobrancaFinalizadaColl = new ArrayList<>();
        }

        if (!Validador.isListValida(cobrancaInvalidadaColl)) {
            cobrancaInvalidadaColl = new ArrayList<>();
        }
        cobrancaEmAtendimentoColl.clear(); 
        cobrancaPausadaColl.clear();
        cobrancaFinalizadaColl.clear();
        cobrancaInvalidadaColl.clear();

        for (Cobrancatb07Atendimento vo : cobrancatb07AtendimentoColl) {

            if (vo.getCobrancatb10AtendimentoSituacao().getSigla().equals("EA")) {
                cobrancaEmAtendimentoColl.add(vo);
            }

            if (vo.getCobrancatb10AtendimentoSituacao().getSigla().equals("AP")) {
                cobrancaPausadaColl.add(vo);
            }

            if (vo.getCobrancatb10AtendimentoSituacao().getSigla().equals("AF")) {
                cobrancaFinalizadaColl.add(vo);
            }

            if (vo.getCobrancatb10AtendimentoSituacao().getSigla().equals("AI")) {
                cobrancaInvalidadaColl.add(vo);
            }

        }

    }

    /**
     * @return the cobrancatb07AtendimentoColl
     */
    public List<Cobrancatb07Atendimento> getCobrancatb07AtendimentoColl() {
        return cobrancatb07AtendimentoColl;
    }

    /**
     * @param cobrancatb07AtendimentoColl the cobrancatb07AtendimentoColl to set
     */
    public void setCobrancatb07AtendimentoColl(List<Cobrancatb07Atendimento> cobrancatb07AtendimentoColl) {
        this.cobrancatb07AtendimentoColl = cobrancatb07AtendimentoColl;
    }

    /**
     * @return the totalAtendimentos
     */
    public int getTotalAtendimentos() {
        return totalAtendimentos;
    }

    /**
     * @param totalAtendimentos the totalAtendimentos to set
     */
    public void setTotalAtendimentos(int totalAtendimentos) {
        this.totalAtendimentos = totalAtendimentos;
    }

    /**
     * @return the renegociacaotb01RenegociacaoColl
     */
    public List<Renegociacaotb01Renegociacao> getRenegociacaotb01RenegociacaoColl() {
        return renegociacaotb01RenegociacaoColl;
    }

    /**
     * @param renegociacaotb01RenegociacaoColl the
     * renegociacaotb01RenegociacaoColl to set
     */
    public void setRenegociacaotb01RenegociacaoColl(List<Renegociacaotb01Renegociacao> renegociacaotb01RenegociacaoColl) {
        this.renegociacaotb01RenegociacaoColl = renegociacaotb01RenegociacaoColl;
    }

    /**
     * @return the totalRenegociacoes
     */
    public int getTotalRenegociacoes() {
        return totalRenegociacoes;
    }

    /**
     * @param totalRenegociacoes the totalRenegociacoes to set
     */
    public void setTotalRenegociacoes(int totalRenegociacoes) {
        this.totalRenegociacoes = totalRenegociacoes;
    }

    /**
     * @return the totalRenegociado
     */
    public BigDecimal getTotalRenegociado() {
        return totalRenegociado;
    }

    /**
     * @param totalRenegociado the totalRenegociado to set
     */
    public void setTotalRenegociado(BigDecimal totalRenegociado) {
        this.totalRenegociado = totalRenegociado;
    }

    /**
     * @return the cobrancaEmAtendimentoColl
     */
    public List<Cobrancatb07Atendimento> getCobrancaEmAtendimentoColl() {
        return cobrancaEmAtendimentoColl;
    }

    /**
     * @param cobrancaEmAtendimentoColl the cobrancaEmAtendimentoColl to set
     */
    public void setCobrancaEmAtendimentoColl(List<Cobrancatb07Atendimento> cobrancaEmAtendimentoColl) {
        this.cobrancaEmAtendimentoColl = cobrancaEmAtendimentoColl;
    }

    /**
     * @return the cobrancaPausadaColl
     */
    public List<Cobrancatb07Atendimento> getCobrancaPausadaColl() {
        return cobrancaPausadaColl;
    }

    /**
     * @param cobrancaPausadaColl the cobrancaPausadaColl to set
     */
    public void setCobrancaPausadaColl(List<Cobrancatb07Atendimento> cobrancaPausadaColl) {
        this.cobrancaPausadaColl = cobrancaPausadaColl;
    }

    /**
     * @return the cobrancaFinalizadaColl
     */
    public List<Cobrancatb07Atendimento> getCobrancaFinalizadaColl() {
        return cobrancaFinalizadaColl;
    }

    /**
     * @param cobrancaFinalizadaColl the cobrancaFinalizadaColl to set
     */
    public void setCobrancaFinalizadaColl(List<Cobrancatb07Atendimento> cobrancaFinalizadaColl) {
        this.cobrancaFinalizadaColl = cobrancaFinalizadaColl;
    }

    /**
     * @return the cobrancaInvalidadaColl
     */
    public List<Cobrancatb07Atendimento> getCobrancaInvalidadaColl() {
        return cobrancaInvalidadaColl;
    }

    /**
     * @param cobrancaInvalidadaColl the cobrancaInvalidadaColl to set
     */
    public void setCobrancaInvalidadaColl(List<Cobrancatb07Atendimento> cobrancaInvalidadaColl) {
        this.cobrancaInvalidadaColl = cobrancaInvalidadaColl;
    }

    /**
     * @return the dataTempoReal
     */
    public Date getDataTempoReal() {
        return dataTempoReal;
    }

    /**
     * @param dataTempoReal the dataTempoReal to set
     */
    public void setDataTempoReal(Date dataTempoReal) {
        this.dataTempoReal = dataTempoReal;
    }

}
