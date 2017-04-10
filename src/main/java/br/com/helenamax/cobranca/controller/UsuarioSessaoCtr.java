/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.controller;

import br.com.helenamax.cobranca.model.Empresatb01Empresa;
import br.com.helenamax.cobranca.model.Segurancatb01Usuario;
import br.com.helenamax.cobranca.service.Empresatb01EmpresaSrv;
import br.com.helenamax.cobranca.service.Segurancatb01UsuarioSrv;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author 005712431
 */
@Named
@SessionScoped
public class UsuarioSessaoCtr implements Serializable {

    private static final long serialVersionUID = 1L;

    private Empresatb01Empresa empresatb01Empresa;
    private Segurancatb01Usuario segurancatb01Usuario;

    @Inject
    Empresatb01EmpresaSrv empresatb01EmpresaSrv;

    @Inject
    Segurancatb01UsuarioSrv segurancatb01UsuarioSrv;

    @Inject
    private MenuCtr menuCtr;

    private boolean jaProcessadoMenu = false;

    public void init() {

    }

    public void iniciarUsuario(Segurancatb01Usuario usuario, Empresatb01Empresa empresa) {
        segurancatb01Usuario = usuario;
        empresatb01Empresa = empresa;
        menuCtr.montarMenu();
    }

    public String sairSistema() {
        try {
            empresatb01Empresa = null;
            segurancatb01Usuario = null;
            
            
            FacesContext.getCurrentInstance().getExternalContext().redirect("entrar.xhtml");
            
            return "entrar?faces-redirect=true";
            
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @return the empresatb01Empresa
     */
    public Empresatb01Empresa getEmpresatb01Empresa() {
        return empresatb01Empresa;
    }

    /**
     * @return the segurancatb01Usuario
     */
    public Segurancatb01Usuario getSegurancatb01Usuario() {
        return segurancatb01Usuario;
    }

    public boolean permissaoModulo(String modulo) {

        boolean resultado = true;

        if (!jaProcessadoMenu) {
            if (modulo.equals("Empresa")) {
                resultado = true;
            }
        }

        jaProcessadoMenu = true;

        return resultado;
    }

    /**
     * @return the jaProcessadoMenu
     */
    public boolean isJaProcessadoMenu() {
        return jaProcessadoMenu;
    }

    /**
     * @param jaProcessadoMenu the jaProcessadoMenu to set
     */
    public void setJaProcessadoMenu(boolean jaProcessadoMenu) {
        this.jaProcessadoMenu = jaProcessadoMenu;
    }

    public boolean isLogado() {

        if (empresatb01Empresa != null && segurancatb01Usuario != null) {
            return true;
        }
        return false;
    }

}
