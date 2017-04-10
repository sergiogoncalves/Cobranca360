/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.service;

import br.com.helenamax.cobranca.jpa.Transactional;
import br.com.helenamax.cobranca.model.Cobrancatb02TituloParcela;
import br.com.helenamax.cobranca.model.Cobrancatb05TituloParcelaCheque;
import br.com.helenamax.cobranca.repository.Cobrancatb05TituloParcelaChequeRep;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

public class Cobrancatb05TituloParcelaChequeSrv implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Cobrancatb05TituloParcelaChequeRep cobrancatb05TituloParcelaChequeRep;

    @Transactional
    public void salvarPersist(Cobrancatb05TituloParcelaCheque cobrancatb03TituloTipo) {
        cobrancatb05TituloParcelaChequeRep.salvar(cobrancatb03TituloTipo);
    }

    @Transactional
    public void salvarMerge(Cobrancatb05TituloParcelaCheque cobrancatb03TituloTipo) {
        cobrancatb05TituloParcelaChequeRep.alterar(cobrancatb03TituloTipo);
    }

    public List<Cobrancatb05TituloParcelaCheque> listar() {
        return cobrancatb05TituloParcelaChequeRep.listar();
    }

    public Cobrancatb05TituloParcelaCheque listarPorId(int codigo) {
        
        Cobrancatb05TituloParcelaCheque vo = cobrancatb05TituloParcelaChequeRep.getById(codigo);
        return vo;
    }
    
    public void inserirCheques(List<Cobrancatb02TituloParcela> lista){
        
        for (Cobrancatb02TituloParcela vo : lista) {
            
            vo.setCobrancatb05TituloParcelaCheque(cobrancatb05TituloParcelaChequeRep.getByTituloParcelaCodigo(vo));
            
        }
        
    }

}
