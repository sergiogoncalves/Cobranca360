/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.service;

import br.com.helenamax.cobranca.jpa.Transactional;
import br.com.helenamax.cobranca.model.Empresatb01Empresa;
import br.com.helenamax.cobranca.model.Segurancatb01Usuario;
import br.com.helenamax.cobranca.repository.Segurancatb01UsuarioRep;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

public class Segurancatb01UsuarioSrv implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Segurancatb01UsuarioRep segurancatb01UsuarioRep;

    @Transactional
    public void salvarPersist(Segurancatb01Usuario segurancatb01Usuario) {
        segurancatb01UsuarioRep.salvar(segurancatb01Usuario);
    }

    @Transactional
    public void salvarMerge(Segurancatb01Usuario segurancatb01Usuario) {
        segurancatb01UsuarioRep.alterar(segurancatb01Usuario);
    }

    public List<Segurancatb01Usuario> listar(Segurancatb01Usuario vo) {
        return segurancatb01UsuarioRep.criteriaBuscarUsuario(vo);
    }

    public Segurancatb01Usuario listarPorId(int codigo) {
        return segurancatb01UsuarioRep.pesquisarPorId(codigo);
    }

    public List<Segurancatb01Usuario> listarPorEmpresa() {
        Segurancatb01Usuario vo = new Segurancatb01Usuario();
        return segurancatb01UsuarioRep.criteriaBuscarUsuario(vo);
    }

    public Segurancatb01Usuario listarPorLoginEmpresa(String login, Empresatb01Empresa empresa) {
        return segurancatb01UsuarioRep.buscarPorLoginEmpresa(login, empresa);
    }

}
