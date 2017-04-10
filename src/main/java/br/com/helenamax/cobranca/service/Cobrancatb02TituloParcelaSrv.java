/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.service;

import br.com.helenamax.cobranca.jpa.Transactional;
import br.com.helenamax.cobranca.model.Cobrancatb01Titulo;
import br.com.helenamax.cobranca.model.Cobrancatb02TituloParcela;
import br.com.helenamax.cobranca.model.Empresatb02Pessoa;
import br.com.helenamax.cobranca.model.Geraltb01SituacaoFinanceira;
import br.com.helenamax.cobranca.repository.Cobrancatb02TituloParcelaRep;
import br.com.helenamax.cobranca.repository.Cobrancatb05TituloParcelaChequeRep;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

public class Cobrancatb02TituloParcelaSrv implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Cobrancatb02TituloParcelaRep cobrancatb02TituloParcelaRep;

    @Inject
    private Cobrancatb05TituloParcelaChequeRep cobrancatb05TituloParcelaChequeRep;

    @Transactional
    public void salvarPersist(Cobrancatb02TituloParcela cobrancatb02TituloParcela) {
        cobrancatb02TituloParcelaRep.salvar(cobrancatb02TituloParcela);
    }

    @Transactional
    public void salvarMerge(Cobrancatb02TituloParcela cobrancatb02TituloParcela) {
        cobrancatb02TituloParcelaRep.alterar(cobrancatb02TituloParcela);
    }

    @Transactional
    public void remover(Cobrancatb02TituloParcela cobrancatb02TituloParcela) {

        if (cobrancatb02TituloParcela.getCobrancatb05TituloParcelaCheque() != null && cobrancatb02TituloParcela.getCobrancatb05TituloParcelaCheque().getCodigoTituloParcelaCheque() != 0) {
            cobrancatb05TituloParcelaChequeRep.removerEntidadePorId(cobrancatb02TituloParcela.getCobrancatb05TituloParcelaCheque().getCodigoTituloParcelaCheque());
        }

        cobrancatb02TituloParcelaRep.removerEntidadePorId(cobrancatb02TituloParcela.getCodigoTituloParcela());
    }

    public List<Cobrancatb02TituloParcela> listar() {
        return cobrancatb02TituloParcelaRep.listar();
    }

    public Cobrancatb02TituloParcela listarPorId(int codigo) {

        Cobrancatb02TituloParcela vo = cobrancatb02TituloParcelaRep.getById(codigo);
        return vo;
    }

    public List<Cobrancatb02TituloParcela> listarPorTitulo(Cobrancatb01Titulo vo) {
        return cobrancatb02TituloParcelaRep.buscarPorTitulo(vo);
    }

    public List<Cobrancatb02TituloParcela> buscarPorDevedorSituacao(Empresatb02Pessoa devedor, Geraltb01SituacaoFinanceira situacao,  Empresatb02Pessoa credor) {
        return cobrancatb02TituloParcelaRep.buscarPorDevedorSituacao(devedor, situacao, credor);
    }

}
