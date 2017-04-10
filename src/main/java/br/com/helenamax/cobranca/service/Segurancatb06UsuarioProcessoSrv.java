/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.service;

import br.com.helenamax.cobranca.jpa.Transactional;
import br.com.helenamax.cobranca.model.Segurancatb06UsuarioProcesso;
import br.com.helenamax.cobranca.model.Segurancatb08ProcessoEmpresa;
import br.com.helenamax.cobranca.repository.Segurancatb06UsuarioProcessoRep;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

public class Segurancatb06UsuarioProcessoSrv implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Segurancatb06UsuarioProcessoRep segurancatb06UsuarioProcessoRep;

    @Transactional
    public void salvarPersist(Segurancatb06UsuarioProcesso segurancatb06UsuarioProcesso) {
        segurancatb06UsuarioProcessoRep.salvar(segurancatb06UsuarioProcesso);
    }

    @Transactional
    public void salvarMerge(Segurancatb06UsuarioProcesso segurancatb06UsuarioProcesso) {
        segurancatb06UsuarioProcessoRep.alterar(segurancatb06UsuarioProcesso);
    }

    public List<Segurancatb06UsuarioProcesso> listarPorUsuario() {
        return segurancatb06UsuarioProcessoRep.buscarPorUsuario();
    }

    public List<Segurancatb06UsuarioProcesso> listarPorProcesso(Segurancatb08ProcessoEmpresa processo) {
        return segurancatb06UsuarioProcessoRep.buscarPorProcesso(processo);
    }

}
