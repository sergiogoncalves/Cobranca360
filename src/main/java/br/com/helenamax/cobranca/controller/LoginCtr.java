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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

@ViewScoped
@Named
public class LoginCtr implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Empresatb01EmpresaSrv empresatb01EmpresaSrv;

    @Inject
    private Segurancatb01UsuarioSrv segurancatb01UsuarioSrv;
    
    @Inject
    private UsuarioSessaoCtr usuarioSessaoCtr;

    private String codigoEmpresa;
    private String usuario;
    private String senha;

    private Empresatb01Empresa empresaUsuario;
    private Segurancatb01Usuario usuarioLogin;

    public void buscarEmpresa() {
        
        empresaUsuario = empresatb01EmpresaSrv.listarPorId(Integer.parseInt(codigoEmpresa));
        
      /*  try {
            
            if (empresaUsuario == null) {
                throw new Exception("Empresa não encontrada!");
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", e.getMessage()));
        }*/
    }

    public void buscarLogin() {
        
         usuarioLogin = segurancatb01UsuarioSrv.listarPorLoginEmpresa(usuario, empresaUsuario);
        /*try {
           
            if (usuarioLogin == null) {
                throw new Exception("Usuário não encontrado!");
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", e.getMessage()));
        }*/

    }

    public String logar() {
        try {
            
            buscarEmpresa();
            
            buscarLogin();
            
            if (usuarioLogin.getSenha().equals(senha)) {
                
                usuarioSessaoCtr.iniciarUsuario(usuarioLogin, empresaUsuario);
                
                
                
                 return "empty-page?faces-redirect=true";
            }
            else{
                throw new Exception("Empresa, usuário ou senha incorreto(s)");
            }
        } catch (Exception e) {
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no formulário:", "Empresa, usuário ou senha incorreto(s)"));

            
        }
        return null;
    }

    /**
     * @return the codigoEmpresa
     */
    public String getCodigoEmpresa() {
        return codigoEmpresa;
    }

    /**
     * @param codigoEmpresa the codigoEmpresa to set
     */
    public void setCodigoEmpresa(String codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the empresaUsuario
     */
    public Empresatb01Empresa getEmpresaUsuario() {
        return empresaUsuario;
    }

    /**
     * @param empresaUsuario the empresaUsuario to set
     */
    public void setEmpresaUsuario(Empresatb01Empresa empresaUsuario) {
        this.empresaUsuario = empresaUsuario;
    }

    /**
     * @return the usuarioLogin
     */
    public Segurancatb01Usuario getUsuarioLogin() {
        return usuarioLogin;
    }

    /**
     * @param usuarioLogin the usuarioLogin to set
     */
    public void setUsuarioLogin(Segurancatb01Usuario usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
    }

}
