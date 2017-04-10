/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.controller;

import br.com.helenamax.cobranca.model.Segurancatb01Usuario;
import br.com.helenamax.cobranca.model.Segurancatb06UsuarioProcesso;
import br.com.helenamax.cobranca.model.Segurancatb08ProcessoEmpresa;
import br.com.helenamax.cobranca.service.Segurancatb01UsuarioSrv;
import br.com.helenamax.cobranca.service.Segurancatb06UsuarioProcessoSrv;
import br.com.helenamax.cobranca.service.Segurancatb08ProcessoEmpresaSrv;
import br.com.helenamax.cobranca.util.Validador;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author 005712431
 */
@Named
@ViewScoped
public class SegurancaUsuarioProcessoCtr implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Segurancatb08ProcessoEmpresaSrv segurancatb08ProcessoEmpresaSrv;

    @Inject
    private Segurancatb06UsuarioProcessoSrv usuarioProcessoSrv;

    @Inject
    private Segurancatb08ProcessoEmpresa segurancatb08ProcessoEmpresaEscolhido;

    @Inject
    private Segurancatb01UsuarioSrv segurancatb01UsuarioSrv;
    
    @Inject
    private MenuCtr menuCtr;

    private List<Segurancatb08ProcessoEmpresa> segurancatb08ProcessoEmpresas;

    private List<Segurancatb06UsuarioProcesso> segurancatb06UsuarioProcessos;

    private List<Segurancatb01Usuario> segurancatb01Usuarios;

    private Segurancatb06UsuarioProcesso segurancatb06UsuarioProcessoVinculo;

    public void init() {
        listarProcessosEmpresa();
    }

    public void listarProcessosEmpresa() {
        if (!Validador.isListValida(segurancatb08ProcessoEmpresas)) {
            segurancatb08ProcessoEmpresas = new ArrayList<>();
        }
        segurancatb08ProcessoEmpresas = segurancatb08ProcessoEmpresaSrv.listarPorEmpresa();
    }

    public void buscarUsuariosPorProcesso(SelectEvent event) {
        setSegurancatb08ProcessoEmpresaEscolhido((Segurancatb08ProcessoEmpresa) event.getObject());
        segurancatb06UsuarioProcessos = usuarioProcessoSrv.listarPorProcesso(getSegurancatb08ProcessoEmpresaEscolhido());
    }

    public void salvarVinculo() {
        try {

            usuarioProcessoSrv.salvarMerge(segurancatb06UsuarioProcessoVinculo);

            RequestContext.getCurrentInstance().execute("PF('dlgVinculo').hide();");
            RequestContext.getCurrentInstance().execute("PF('dlgResultado').show();");
            
            menuCtr.montarMenu();
        } catch (Exception e) {
        }
    }

    /**
     * @return the segurancatb08ProcessoEmpresas
     */
    public List<Segurancatb08ProcessoEmpresa> getSegurancatb08ProcessoEmpresas() {
        return segurancatb08ProcessoEmpresas;
    }

    public void iniciarVinculo() {

        segurancatb06UsuarioProcessoVinculo = null;
        segurancatb06UsuarioProcessoVinculo = new Segurancatb06UsuarioProcesso();

        segurancatb06UsuarioProcessoVinculo.setSegurancatb08ProcessoEmpresa(segurancatb08ProcessoEmpresaEscolhido);

        listarUsuariosCadastradosParaEmpresa();

        RequestContext.getCurrentInstance().update("frmVinculo");
        RequestContext.getCurrentInstance().execute("PF('dlgVinculo').show();");
    }

    public void listarUsuariosCadastradosParaEmpresa() {
        segurancatb01Usuarios = segurancatb01UsuarioSrv.listarPorEmpresa();
    }

    /**
     * @param segurancatb08ProcessoEmpresas the segurancatb08ProcessoEmpresas to
     * set
     */
    public void setSegurancatb08ProcessoEmpresas(List<Segurancatb08ProcessoEmpresa> segurancatb08ProcessoEmpresas) {
        this.segurancatb08ProcessoEmpresas = segurancatb08ProcessoEmpresas;
    }

    /**
     * @return the segurancatb06UsuarioProcessos
     */
    public List<Segurancatb06UsuarioProcesso> getSegurancatb06UsuarioProcessos() {
        return segurancatb06UsuarioProcessos;
    }

    /**
     * @param segurancatb06UsuarioProcessos the segurancatb06UsuarioProcessos to
     * set
     */
    public void setSegurancatb06UsuarioProcessos(List<Segurancatb06UsuarioProcesso> segurancatb06UsuarioProcessos) {
        this.segurancatb06UsuarioProcessos = segurancatb06UsuarioProcessos;
    }

    /**
     * @return the segurancatb08ProcessoEmpresaEscolhido
     */
    public Segurancatb08ProcessoEmpresa getSegurancatb08ProcessoEmpresaEscolhido() {
        return segurancatb08ProcessoEmpresaEscolhido;
    }

    /**
     * @param segurancatb08ProcessoEmpresaEscolhido the
     * segurancatb08ProcessoEmpresaEscolhido to set
     */
    public void setSegurancatb08ProcessoEmpresaEscolhido(Segurancatb08ProcessoEmpresa segurancatb08ProcessoEmpresaEscolhido) {
        this.segurancatb08ProcessoEmpresaEscolhido = segurancatb08ProcessoEmpresaEscolhido;
    }

    /**
     * @return the segurancatb06UsuarioProcessoVinculo
     */
    public Segurancatb06UsuarioProcesso getSegurancatb06UsuarioProcessoVinculo() {
        return segurancatb06UsuarioProcessoVinculo;
    }

    /**
     * @param segurancatb06UsuarioProcessoVinculo the
     * segurancatb06UsuarioProcessoVinculo to set
     */
    public void setSegurancatb06UsuarioProcessoVinculo(Segurancatb06UsuarioProcesso segurancatb06UsuarioProcessoVinculo) {
        this.segurancatb06UsuarioProcessoVinculo = segurancatb06UsuarioProcessoVinculo;
    }

    /**
     * @return the segurancatb01Usuarios
     */
    public List<Segurancatb01Usuario> getSegurancatb01Usuarios() {
        return segurancatb01Usuarios;
    }

    /**
     * @param segurancatb01Usuarios the segurancatb01Usuarios to set
     */
    public void setSegurancatb01Usuarios(List<Segurancatb01Usuario> segurancatb01Usuarios) {
        this.segurancatb01Usuarios = segurancatb01Usuarios;
    }

}
