/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.controller;

import br.com.helenamax.cobranca.model.Segurancatb02Processo;
import br.com.helenamax.cobranca.model.Segurancatb08ProcessoEmpresa;
import br.com.helenamax.cobranca.service.Segurancatb02ProcessoSrv;
import br.com.helenamax.cobranca.service.Segurancatb08ProcessoEmpresaSrv;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

@ViewScoped
@Named
public class AdministrativoCtr implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Segurancatb02ProcessoSrv segurancatb02ProcessoSrv;

    @Inject
    private Segurancatb02Processo segurancatb02ProcessoAtual;

    @Inject
    private Segurancatb08ProcessoEmpresaSrv segurancatb08ProcessoEmpresaSrv;

    @Inject
    private EmpresaCtr empresaCtr;

    private Segurancatb08ProcessoEmpresa segurancatb08ProcessoEmpresaGravar;

    private List<Segurancatb02Processo> segurancatb02ProcessoColl;

    private List<Segurancatb02Processo> processosPaiColl;

    private List<Segurancatb08ProcessoEmpresa> processoEmpresasColl;

    public void init() {
        buscarProcessosPai();
        setSegurancatb02ProcessoColl(segurancatb02ProcessoSrv.listarTodos());

    }

    public void salvar() {
        try {

            segurancatb02ProcessoSrv.salvarMerge(segurancatb02ProcessoAtual);
            init();
            novo();
            RequestContext.getCurrentInstance().execute("PF('dlgResultado').show();");
        } catch (Exception e) {
        }
    }

    public void buscarProcessosPai() {
        processosPaiColl = segurancatb02ProcessoSrv.listarTodosPai();
    }

    public void novo() {
        segurancatb02ProcessoAtual = null;
        segurancatb02ProcessoAtual = new Segurancatb02Processo();
    }

    public void mudarProcesso(SelectEvent event) {
        segurancatb02ProcessoAtual = (Segurancatb02Processo) event.getObject();
        processoEmpresasColl = segurancatb08ProcessoEmpresaSrv.listarPorProcesso(((Segurancatb02Processo) event.getObject()));
    }

    public void abrirVinculoEmpresas() {
        if (empresaCtr.getEmpresatb01EmpresaColl() == null) {
            empresaCtr.buscarEmpresas();
        }
        segurancatb08ProcessoEmpresaGravar = null;
        segurancatb08ProcessoEmpresaGravar = new Segurancatb08ProcessoEmpresa();

        RequestContext.getCurrentInstance().update("frmVinculo");
        RequestContext.getCurrentInstance().execute("PF('dlgVinculo').show();");
    }

    public void salvarEmpresaProcesso() {
        try {
            segurancatb08ProcessoEmpresaGravar.setSegurancatb02Processo(segurancatb02ProcessoAtual);

            segurancatb08ProcessoEmpresaSrv.salvarMerge(segurancatb08ProcessoEmpresaGravar);

            RequestContext.getCurrentInstance().execute("PF('dlgVinculo').hide();");
            RequestContext.getCurrentInstance().execute("PF('dlgResultado').show();");
        } catch (Exception e) {
        }

    }

    /**
     * @return the segurancatb02ProcessoColl
     */
    public List<Segurancatb02Processo> getSegurancatb02ProcessoColl() {
        return segurancatb02ProcessoColl;
    }

    /**
     * @param segurancatb02ProcessoColl the segurancatb02ProcessoColl to set
     */
    public void setSegurancatb02ProcessoColl(List<Segurancatb02Processo> segurancatb02ProcessoColl) {
        this.segurancatb02ProcessoColl = segurancatb02ProcessoColl;
    }

    /**
     * @return the segurancatb02ProcessoAtual
     */
    public Segurancatb02Processo getSegurancatb02ProcessoAtual() {
        return segurancatb02ProcessoAtual;
    }

    /**
     * @param segurancatb02ProcessoAtual the segurancatb02ProcessoAtual to set
     */
    public void setSegurancatb02ProcessoAtual(Segurancatb02Processo segurancatb02ProcessoAtual) {
        this.segurancatb02ProcessoAtual = segurancatb02ProcessoAtual;
    }

    /**
     * @return the processosPaiColl
     */
    public List<Segurancatb02Processo> getProcessosPaiColl() {
        return processosPaiColl;
    }

    /**
     * @param processosPaiColl the processosPaiColl to set
     */
    public void setProcessosPaiColl(List<Segurancatb02Processo> processosPaiColl) {
        this.processosPaiColl = processosPaiColl;
    }

    /**
     * @return the processoEmpresasColl
     */
    public List<Segurancatb08ProcessoEmpresa> getProcessoEmpresasColl() {
        return processoEmpresasColl;
    }

    /**
     * @param processoEmpresasColl the processoEmpresasColl to set
     */
    public void setProcessoEmpresasColl(List<Segurancatb08ProcessoEmpresa> processoEmpresasColl) {
        this.processoEmpresasColl = processoEmpresasColl;
    }

    /**
     * @return the segurancatb08ProcessoEmpresaGravar
     */
    public Segurancatb08ProcessoEmpresa getSegurancatb08ProcessoEmpresaGravar() {
        return segurancatb08ProcessoEmpresaGravar;
    }

    /**
     * @param segurancatb08ProcessoEmpresaGravar the
     * segurancatb08ProcessoEmpresaGravar to set
     */
    public void setSegurancatb08ProcessoEmpresaGravar(Segurancatb08ProcessoEmpresa segurancatb08ProcessoEmpresaGravar) {
        this.segurancatb08ProcessoEmpresaGravar = segurancatb08ProcessoEmpresaGravar;
    }

}
