/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.controller;

import br.com.helenamax.cobranca.model.Filatb01Fila;
import br.com.helenamax.cobranca.service.Filatb01FilaSrv;
import br.com.helenamax.cobranca.util.Validador;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ViewScoped
@Named
public class FilaCtr implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private UsuarioSessaoCtr usuarioSessaoCtr;

    @Inject
    private Filatb01FilaSrv filatb01FilaSrv;

    private Date dataInicio;
    private Date dataFim;

    private List<Filatb01Fila> filaColl;

    public void buscarFila() {
        if (!Validador.isListValida(filaColl)) {
            filaColl = Validador.iniciarList();
        }

        try {
            filaColl = filatb01FilaSrv.buscarPorDataCriacao(null, dataInicio, dataFim);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", e.getMessage()));
        }
    }

    /**
     * @return the dataInicio
     */
    public Date getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * @return the dataFim
     */
    public Date getDataFim() {
        return dataFim;
    }

    /**
     * @param dataFim the dataFim to set
     */
    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    /**
     * @return the filaColl
     */
    public List<Filatb01Fila> getFilaColl() {
        return filaColl;
    }

    /**
     * @param filaColl the filaColl to set
     */
    public void setFilaColl(List<Filatb01Fila> filaColl) {
        this.filaColl = filaColl;
    }

}
