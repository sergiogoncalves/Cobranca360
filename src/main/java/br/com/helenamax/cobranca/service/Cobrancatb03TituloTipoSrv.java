/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.service;

import br.com.helenamax.cobranca.jpa.Transactional;
import br.com.helenamax.cobranca.model.Cobrancatb03TituloTipo;
import br.com.helenamax.cobranca.repository.Cobrancatb03TituloTipoRep;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

public class Cobrancatb03TituloTipoSrv implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Cobrancatb03TituloTipoRep cobrancatb03TituloTipoRep;

    @Transactional
    public void salvarPersist(Cobrancatb03TituloTipo cobrancatb03TituloTipo) {
        cobrancatb03TituloTipoRep.salvar(cobrancatb03TituloTipo);
    }

    @Transactional
    public void salvarMerge(Cobrancatb03TituloTipo cobrancatb03TituloTipo) {
        cobrancatb03TituloTipoRep.alterar(cobrancatb03TituloTipo);
    }

    public List<Cobrancatb03TituloTipo> listar() {
        return cobrancatb03TituloTipoRep.listar();
    }

    public Cobrancatb03TituloTipo listarPorId(int codigo) {

        Cobrancatb03TituloTipo vo = cobrancatb03TituloTipoRep.getById(codigo);
        return vo;
    }

    public Cobrancatb03TituloTipo listarPorSigla(String sigla) {

        Cobrancatb03TituloTipo vo = cobrancatb03TituloTipoRep.buscarPorSigla(sigla);
        return vo;
    }

}
