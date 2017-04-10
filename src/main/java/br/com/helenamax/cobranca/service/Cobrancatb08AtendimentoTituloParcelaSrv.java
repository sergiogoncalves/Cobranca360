/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.service;

import br.com.helenamax.cobranca.jpa.Transactional;
import br.com.helenamax.cobranca.model.Cobrancatb07Atendimento;
import br.com.helenamax.cobranca.model.Cobrancatb08AtendimentoTituloParcela;
import br.com.helenamax.cobranca.repository.Cobrancatb08AtendimentoTituloParcelaRep;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

public class Cobrancatb08AtendimentoTituloParcelaSrv implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Cobrancatb08AtendimentoTituloParcelaRep cobrancatb08AtendimentoTituloParcelaRep;

    @Transactional
    public void salvarPersist(Cobrancatb08AtendimentoTituloParcela cobrancatb08AtendimentoTituloParcela) {
        cobrancatb08AtendimentoTituloParcelaRep.salvar(cobrancatb08AtendimentoTituloParcela);
    }

    @Transactional
    public void salvarMerge(Cobrancatb08AtendimentoTituloParcela cobrancatb08AtendimentoTituloParcela) {
        cobrancatb08AtendimentoTituloParcelaRep.alterar(cobrancatb08AtendimentoTituloParcela);
    }

    public List<Cobrancatb08AtendimentoTituloParcela> listar() {
        return cobrancatb08AtendimentoTituloParcelaRep.listar();
    }

    public Cobrancatb08AtendimentoTituloParcela listarPorId(int codigo) {

        Cobrancatb08AtendimentoTituloParcela vo = cobrancatb08AtendimentoTituloParcelaRep.getById(codigo);
        return vo;
    }

    public List<Cobrancatb08AtendimentoTituloParcela> listarPorAtendimento(Cobrancatb07Atendimento vo) {
        return cobrancatb08AtendimentoTituloParcelaRep.buscarPorAtendimento(vo);
    }

}
