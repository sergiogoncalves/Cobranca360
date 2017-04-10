/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.service;

import br.com.helenamax.cobranca.jpa.Transactional;
import br.com.helenamax.cobranca.model.Cobrancatb09AtendimentoAndamento;
import br.com.helenamax.cobranca.repository.Cobrancatb09AtendimentoAndamentoRep;
import java.io.Serializable;
import javax.inject.Inject;

public class Cobrancatb09AtendimentoAndamentoSrv implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Cobrancatb09AtendimentoAndamentoRep cobrancatb09AtendimentoAndamentoRep;

    @Transactional
    public void salvarPersist(Cobrancatb09AtendimentoAndamento cobrancatb08AtendimentoTituloParcela) {
        cobrancatb09AtendimentoAndamentoRep.salvar(cobrancatb08AtendimentoTituloParcela);
    }

    @Transactional
    public void salvarMerge(Cobrancatb09AtendimentoAndamento cobrancatb08AtendimentoTituloParcela) {
        cobrancatb09AtendimentoAndamentoRep.alterar(cobrancatb08AtendimentoTituloParcela);
    }

    @Transactional
    public void remover(Cobrancatb09AtendimentoAndamento cobrancatb09AtendimentoAndamento) {
        cobrancatb09AtendimentoAndamentoRep.removerEntidadePorId(cobrancatb09AtendimentoAndamento.getCodigoAtendimentoAndamento());
    }

}
