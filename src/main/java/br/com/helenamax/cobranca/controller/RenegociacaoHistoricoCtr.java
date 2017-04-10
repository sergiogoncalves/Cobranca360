/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.controller;

import br.com.helenamax.cobranca.model.Renegociacaotb01Renegociacao;
import br.com.helenamax.cobranca.model.Segurancatb01Usuario;
import br.com.helenamax.cobranca.service.Renegociacaotb01RenegociacaoSrv;
import br.com.helenamax.cobranca.service.Segurancatb01UsuarioSrv;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author 005712431
 */
@Named
@ViewScoped
public class RenegociacaoHistoricoCtr implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Segurancatb01UsuarioSrv segurancatb01UsuarioSrv;
    
    @Inject
    private Segurancatb01Usuario segurancatb01UsuarioEscolhido;
    
    @Inject
    private Renegociacaotb01RenegociacaoSrv renegociacaotb01RenegociacaoSrv;

    private List<Segurancatb01Usuario> segurancatb01UsuarioColl;
    
    private List<Renegociacaotb01Renegociacao> renegociacaoColl;
    
    private Date dataInicial;
    private Date dataFinal;

    public void iniciar() {
        try {
            
            segurancatb01UsuarioColl = segurancatb01UsuarioSrv.listarPorEmpresa();

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", e.getMessage()));
        }

    }
    
    public void buscarRenegociacao(){
        
        try {
            renegociacaoColl = renegociacaotb01RenegociacaoSrv.listarRenegociacao(dataInicial, dataFinal, segurancatb01UsuarioEscolhido); 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    //----------------------------------------------------------------

    /**
     * @return the segurancatb01UsuarioColl
     */
    public List<Segurancatb01Usuario> getSegurancatb01UsuarioColl() {
        return segurancatb01UsuarioColl;
    }

    /**
     * @param segurancatb01UsuarioColl the segurancatb01UsuarioColl to set
     */
    public void setSegurancatb01UsuarioColl(List<Segurancatb01Usuario> segurancatb01UsuarioColl) {
        this.segurancatb01UsuarioColl = segurancatb01UsuarioColl;
    }

    /**
     * @return the segurancatb01UsuarioEscolhido
     */
    public Segurancatb01Usuario getSegurancatb01UsuarioEscolhido() {
        return segurancatb01UsuarioEscolhido;
    }

    /**
     * @param segurancatb01UsuarioEscolhido the segurancatb01UsuarioEscolhido to set
     */
    public void setSegurancatb01UsuarioEscolhido(Segurancatb01Usuario segurancatb01UsuarioEscolhido) {
        this.segurancatb01UsuarioEscolhido = segurancatb01UsuarioEscolhido;
    }

    /**
     * @return the dataInicial
     */
    public Date getDataInicial() {
        return dataInicial;
    }

    /**
     * @param dataInicial the dataInicial to set
     */
    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    /**
     * @return the dataFinal
     */
    public Date getDataFinal() {
        return dataFinal;
    }

    /**
     * @param dataFinal the dataFinal to set
     */
    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    /**
     * @return the renegociacaoColl
     */
    public List<Renegociacaotb01Renegociacao> getRenegociacaoColl() {
        return renegociacaoColl;
    }

    /**
     * @param renegociacaoColl the renegociacaoColl to set
     */
    public void setRenegociacaoColl(List<Renegociacaotb01Renegociacao> renegociacaoColl) {
        this.renegociacaoColl = renegociacaoColl;
    }

}
