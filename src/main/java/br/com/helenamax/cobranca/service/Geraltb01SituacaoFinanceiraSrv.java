/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.service;

import br.com.helenamax.cobranca.jpa.Transactional;
import br.com.helenamax.cobranca.model.Geraltb01SituacaoFinanceira;
import br.com.helenamax.cobranca.repository.Geraltb01SituacaoFinanceiraRep;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

public class Geraltb01SituacaoFinanceiraSrv implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Geraltb01SituacaoFinanceiraRep geraltb01SituacaoFinanceiraRep;

    @Transactional
    public void salvarPersist(Geraltb01SituacaoFinanceira geraltb02TipoContato) {
        geraltb01SituacaoFinanceiraRep.salvar(geraltb02TipoContato);
    }

    @Transactional
    public void salvarMerge(Geraltb01SituacaoFinanceira geraltb02TipoContato) {
        geraltb01SituacaoFinanceiraRep.alterar(geraltb02TipoContato);
    }

    public List<Geraltb01SituacaoFinanceira> listar() {
        return geraltb01SituacaoFinanceiraRep.listar();
    }

    public Geraltb01SituacaoFinanceira listarPorId(int codigo) {

        Geraltb01SituacaoFinanceira vo = geraltb01SituacaoFinanceiraRep.getById(codigo);
        return vo;
    }

    public Geraltb01SituacaoFinanceira listarPorSigla(String sigla) {
        return geraltb01SituacaoFinanceiraRep.buscarPorSigla(sigla);
    }



}
