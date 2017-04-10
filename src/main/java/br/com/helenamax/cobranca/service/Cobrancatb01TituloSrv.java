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
import br.com.helenamax.cobranca.repository.Cobrancatb01TituloRep;
import br.com.helenamax.cobranca.repository.Cobrancatb02TituloParcelaRep;
import br.com.helenamax.cobranca.repository.Cobrancatb05TituloParcelaChequeRep;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

public class Cobrancatb01TituloSrv implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Cobrancatb01TituloRep cobrancatb01TituloRep;

    @Inject
    private Cobrancatb02TituloParcelaRep cobrancatb02TituloParcelaRep;

    @Inject
    private Cobrancatb05TituloParcelaChequeRep cobrancatb05TituloParcelaChequeRep;

    @Transactional
    public void salvar(Cobrancatb01Titulo cobrancatb01Titulo, List<Cobrancatb02TituloParcela> coll) {

        if (cobrancatb01Titulo.getCodigoTitulo() != 0) {
            cobrancatb01TituloRep.alterar(cobrancatb01Titulo);
        } else {
            cobrancatb01TituloRep.salvar(cobrancatb01Titulo);
        }

        for (Cobrancatb02TituloParcela vo : coll) {

            vo.setCobrancatb01Titulo(cobrancatb01Titulo);

            if (vo.getCodigoTituloParcela() != 0) {
                cobrancatb02TituloParcelaRep.alterar(vo);
            } else {
                cobrancatb02TituloParcelaRep.salvar(vo);
            }

            if (vo.getCobrancatb05TituloParcelaCheque() != null) {

                if (vo.getCobrancatb05TituloParcelaCheque().getAgencia() != null && !vo.getCobrancatb05TituloParcelaCheque().getAgencia().equals("")) {

                    vo.getCobrancatb05TituloParcelaCheque().setCobrancatb02TituloParcela(vo);

                    cobrancatb05TituloParcelaChequeRep.alterar(vo.getCobrancatb05TituloParcelaCheque());
                }
            }

        }
    }

    @Transactional
    public void salvarMerge(Cobrancatb01Titulo cobrancatb03TituloTipo) {
        cobrancatb01TituloRep.alterar(cobrancatb03TituloTipo);
    }

    public List<Cobrancatb01Titulo> listar() {
        return cobrancatb01TituloRep.listar();
    }

    public Cobrancatb01Titulo listarPorId(int codigo) {

        Cobrancatb01Titulo vo = cobrancatb01TituloRep.getById(codigo);
        return vo;
    }

    public List<Cobrancatb01Titulo> listarPorPessoa(Empresatb02Pessoa vo) {
        return cobrancatb01TituloRep.buscarPorPessoa(vo);
    }

    public List<Cobrancatb01Titulo> listarPorParametro(int diasAtrasoInicio,
            int diasAtrasoFim,
            Double valorInicio,
            Double valorFim) {
        
        
        return cobrancatb01TituloRep.buscarPorParametro(diasAtrasoInicio,
                diasAtrasoFim,
                valorInicio,
                valorFim);
    }

}
