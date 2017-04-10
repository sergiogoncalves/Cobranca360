/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.controller;

import br.com.helenamax.cobranca.model.Cobrancatb03TituloTipo;
import br.com.helenamax.cobranca.service.Cobrancatb03TituloTipoSrv;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author 005712431
 */
@ViewScoped
@Named
public class ComponentesCtr  implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private Cobrancatb03TituloTipoSrv cobrancatb03TituloTipoSrv;
    
    private List<Cobrancatb03TituloTipo>  cobrancatb03TituloTipoColl;

    
    
    public void ListarCobrancatb03TituloTipo(){
        cobrancatb03TituloTipoColl = cobrancatb03TituloTipoSrv.listar();
    }
    
    
    
    /**
     * @return the cobrancatb03TituloTipoColl
     */
    public List<Cobrancatb03TituloTipo> getCobrancatb03TituloTipoColl() {
        return cobrancatb03TituloTipoColl;
    }

    /**
     * @param cobrancatb03TituloTipoColl the cobrancatb03TituloTipoColl to set
     */
    public void setCobrancatb03TituloTipoColl(List<Cobrancatb03TituloTipo> cobrancatb03TituloTipoColl) {
        this.cobrancatb03TituloTipoColl = cobrancatb03TituloTipoColl;
    }
    
}
