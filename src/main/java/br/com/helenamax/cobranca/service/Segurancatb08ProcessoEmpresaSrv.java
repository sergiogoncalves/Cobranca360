/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.service;

import br.com.helenamax.cobranca.jpa.Transactional;
import br.com.helenamax.cobranca.model.Segurancatb02Processo;
import br.com.helenamax.cobranca.model.Segurancatb08ProcessoEmpresa;
import br.com.helenamax.cobranca.repository.Segurancatb08ProcessoEmpresaRep;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

public class Segurancatb08ProcessoEmpresaSrv implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Segurancatb08ProcessoEmpresaRep segurancatb08ProcessoEmpresaRep;

    @Transactional
    public void salvarPersist(Segurancatb08ProcessoEmpresa segurancatb08ProcessoEmpresa) {
        segurancatb08ProcessoEmpresaRep.salvar(segurancatb08ProcessoEmpresa);
    }

    @Transactional
    public void salvarMerge(Segurancatb08ProcessoEmpresa segurancatb08ProcessoEmpresa) {
        segurancatb08ProcessoEmpresaRep.alterar(segurancatb08ProcessoEmpresa);
    }

    public List<Segurancatb08ProcessoEmpresa> listarPorProcesso(Segurancatb02Processo processo) {
        return segurancatb08ProcessoEmpresaRep.buscarPorProcesso(processo);
    }

    public List<Segurancatb08ProcessoEmpresa> listarPorEmpresa() {
        return segurancatb08ProcessoEmpresaRep.buscarPorEmpresa();
    }

}
