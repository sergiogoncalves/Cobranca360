/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.service;

import br.com.helenamax.cobranca.jpa.Transactional;
import br.com.helenamax.cobranca.model.Cobrancatb10AtendimentoSituacao;
import br.com.helenamax.cobranca.repository.Cobrancatb10AtendimentoSituacaoRep;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

public class Cobrancatb10AtendimentoSituacaoSrv implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Cobrancatb10AtendimentoSituacaoRep cobrancatb10AtendimentoSituacaoRep;

    @Transactional
    public void salvarPersist(Cobrancatb10AtendimentoSituacao cobrancatb08AtendimentoTituloParcela) {
        cobrancatb10AtendimentoSituacaoRep.salvar(cobrancatb08AtendimentoTituloParcela);
    }

    @Transactional
    public void salvarMerge(Cobrancatb10AtendimentoSituacao cobrancatb08AtendimentoTituloParcela) {
        cobrancatb10AtendimentoSituacaoRep.alterar(cobrancatb08AtendimentoTituloParcela);
    }

    public List<Cobrancatb10AtendimentoSituacao> listar() {
        return cobrancatb10AtendimentoSituacaoRep.listar();
    }

    public Cobrancatb10AtendimentoSituacao listarPorId(int codigo) {

        Cobrancatb10AtendimentoSituacao vo = cobrancatb10AtendimentoSituacaoRep.getById(codigo);
        return vo; 
    }

    public Cobrancatb10AtendimentoSituacao listarPorSigla(String sigla) {
        return cobrancatb10AtendimentoSituacaoRep.buscarPorSigla(sigla);
    }

}
