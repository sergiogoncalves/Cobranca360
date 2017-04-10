/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.repository;

import br.com.helenamax.cobranca.model.Segurancatb06UsuarioProcesso;
import br.com.helenamax.cobranca.model.Segurancatb08ProcessoEmpresa;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Helena
 */
public class Segurancatb06UsuarioProcessoRep extends BasicRepositorio<Segurancatb06UsuarioProcesso, Integer> {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Segurancatb06UsuarioProcessoRep() {
        super(Segurancatb06UsuarioProcesso.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }

    public List<Segurancatb06UsuarioProcesso> buscarPorUsuario() {
        //manager.createQuery("select c from Segurancatb06UsuarioProcesso c where c.segurancatb01Usuario = ?1");

        StringBuilder query = new StringBuilder();
        Object[] elements = new Object[1];

        query.append(" select c from Segurancatb06UsuarioProcesso c where c.segurancatb01Usuario = ?1 ");

        elements[0] = usuarioSessaoCtr.getSegurancatb01Usuario();

        return super.getListEntity(query.toString(), elements);
    }

    public List<Segurancatb06UsuarioProcesso> buscarPorProcesso(Segurancatb08ProcessoEmpresa processo) {
        //manager.createQuery("select c from Segurancatb06UsuarioProcesso c where c.segurancatb08ProcessoEmpresa = ?1");

        StringBuilder query = new StringBuilder();
        Object[] elements = new Object[1];

        query.append(" select c from Segurancatb06UsuarioProcesso c where c.segurancatb08ProcessoEmpresa = ?1 ");

        elements[0] = processo;

        return super.getListEntity(query.toString(), elements);
    }

}
