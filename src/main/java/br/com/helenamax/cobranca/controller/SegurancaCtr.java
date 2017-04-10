/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.controller;

import br.com.helenamax.cobranca.model.Empresatb02Pessoa;
import br.com.helenamax.cobranca.model.Empresatb03PessoaFisica;
import br.com.helenamax.cobranca.model.Segurancatb01Usuario;
import br.com.helenamax.cobranca.service.Segurancatb01UsuarioSrv;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
public class SegurancaCtr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private ParametroSessaoCtr parametroSessaoCtr;

    @Inject
    private Segurancatb01Usuario segurancatb01Usuario;

    @Inject
    private Segurancatb01UsuarioSrv segurancatb01UsuarioSrv;

    @Inject
    private Segurancatb01Usuario segurancatb01UsuarioPesquisa;

    private List<Segurancatb01Usuario> segurancatb01UsuarioColl;

    private String repeteSenha;

    public void initCadastro() {
        if (segurancatb01Usuario.getEmpresatb02Pessoa() == null) {
            segurancatb01Usuario.setEmpresatb02Pessoa(new Empresatb02Pessoa());
            segurancatb01Usuario.getEmpresatb02Pessoa().setEmpresatb03PessoaFisica(new Empresatb03PessoaFisica());

        }

        repeteSenha = segurancatb01Usuario.getSenha();
    }

    public void initPrincipal() {
        segurancatb01UsuarioPesquisa.setEmpresatb02Pessoa(new Empresatb02Pessoa());
        segurancatb01UsuarioPesquisa.getEmpresatb02Pessoa().setEmpresatb03PessoaFisica(new Empresatb03PessoaFisica());

    }

    public void abrirBuscaPessoa() {
        try {
            RequestContext.getCurrentInstance().openDialog("/pessoa/pessoa-fisica-busca", parametroSessaoCtr.retornarParametrosTelaBuscaPessoa(), null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void onPessoaReturn(SelectEvent event) {
        try {
            if (event.getObject() != null) {
                if (event.getObject() instanceof Empresatb03PessoaFisica) {

                    segurancatb01Usuario.setEmpresatb02Pessoa(((Empresatb03PessoaFisica) event.getObject()).getEmpresatb02Pessoa());
                    segurancatb01Usuario.getEmpresatb02Pessoa().setEmpresatb03PessoaFisica((Empresatb03PessoaFisica) event.getObject());
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Para usuários de sistema só é permitido pessoa física."));
                }
            }
        } catch (Exception e) {
        }
    }

    public void salvarUsuario() {
        try {

            if (!segurancatb01Usuario.getSenha().equals(repeteSenha)) {
                throw new Exception("As senhas devem ser iguais.");
            }

            segurancatb01UsuarioSrv.salvarMerge(segurancatb01Usuario);

            RequestContext.getCurrentInstance().execute("PF('dlgResultado').show();");

        } catch (Exception e) {

            RequestContext.getCurrentInstance().execute("PF('dlgGravar').hide();");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", e.getMessage()));

        }
        RequestContext.getCurrentInstance().execute("PF('dlgGravar').hide();");
    }

    public void buscarUsuario() {
        try {
            segurancatb01UsuarioColl = segurancatb01UsuarioSrv.listar(segurancatb01UsuarioPesquisa);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", e.getMessage()));
        }

    }



//-------------------------------------------------------------------------------------    
    /**
     * @return the segurancatb01Usuario
     */
    public Segurancatb01Usuario getSegurancatb01Usuario() {
        return segurancatb01Usuario;
    }

    /**
     * @param segurancatb01Usuario the segurancatb01Usuario to set
     */
    public void setSegurancatb01Usuario(Segurancatb01Usuario segurancatb01Usuario) {
        this.segurancatb01Usuario = segurancatb01Usuario;
    }

    /**
     * @return the repeteSenha
     */
    public String getRepeteSenha() {
        return repeteSenha;
    }

    /**
     * @param repeteSenha the repeteSenha to set
     */
    public void setRepeteSenha(String repeteSenha) {
        this.repeteSenha = repeteSenha;
    }

    /**
     * @return the segurancatb01UsuarioPesquisa
     */
    public Segurancatb01Usuario getSegurancatb01UsuarioPesquisa() {
        return segurancatb01UsuarioPesquisa;
    }

    /**
     * @param segurancatb01UsuarioPesquisa the segurancatb01UsuarioPesquisa to
     * set
     */
    public void setSegurancatb01UsuarioPesquisa(Segurancatb01Usuario segurancatb01UsuarioPesquisa) {
        this.segurancatb01UsuarioPesquisa = segurancatb01UsuarioPesquisa;
    }

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

}
