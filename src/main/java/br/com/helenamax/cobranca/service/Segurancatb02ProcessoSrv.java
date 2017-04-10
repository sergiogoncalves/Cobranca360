/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.service;

import br.com.helenamax.cobranca.jpa.Transactional;
import br.com.helenamax.cobranca.model.Segurancatb02Processo;
import br.com.helenamax.cobranca.repository.Segurancatb02ProcessoRep;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

public class Segurancatb02ProcessoSrv implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Segurancatb02ProcessoRep segurancatb02ProcessoRep;

    @Transactional
    public void salvarPersist(Segurancatb02Processo segurancatb02Processo) {
        segurancatb02ProcessoRep.salvar(segurancatb02Processo);
    }

    @Transactional
    public void salvarMerge(Segurancatb02Processo segurancatb02Processo) {
        segurancatb02ProcessoRep.alterar(segurancatb02Processo);
    }

    public List<Segurancatb02Processo> listarTodos() {
        return segurancatb02ProcessoRep.buscarTodos();
    }

    public List<Segurancatb02Processo> listarTodosPai() {
        return segurancatb02ProcessoRep.buscarTodosPai();
    }

    public Segurancatb02Processo listarPorId(int id) {
        return segurancatb02ProcessoRep.pesquisarPorId(id);
    }

}
