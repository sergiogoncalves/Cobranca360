/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.repository;

import br.com.helenamax.cobranca.model.Segurancatb02Processo;
import br.com.helenamax.cobranca.model.Segurancatb06UsuarioProcesso;
import br.com.helenamax.cobranca.model.Segurancatb08ProcessoEmpresa;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Helena
 */
public class Segurancatb08ProcessoEmpresaRep extends BasicRepositorio<Segurancatb08ProcessoEmpresa, Integer> {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Segurancatb08ProcessoEmpresaRep() {
        super(Segurancatb08ProcessoEmpresa.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }

    public List<Segurancatb08ProcessoEmpresa> buscarPorProcesso(Segurancatb02Processo processo) {
        //manager.createQuery("select c from Segurancatb08ProcessoEmpresa c where c.segurancatb02Processo = ?1");

        StringBuilder query = new StringBuilder();
        Object[] elements = new Object[1];

        query.append(" select c from Segurancatb08ProcessoEmpresa c where c.segurancatb02Processo = ?1 ");

        elements[0] = processo;

        return super.getListEntity(query.toString(), elements);

    }

    public List<Segurancatb08ProcessoEmpresa> buscarPorEmpresa() {
       // manager.createQuery("select c from Segurancatb08ProcessoEmpresa c where c.empresatb01Empresa = ?1 ");

        StringBuilder query = new StringBuilder();
        Object[] elements = new Object[1];

        query.append(" select c from Segurancatb08ProcessoEmpresa c where c.empresatb01Empresa = ?1 ");

        elements[0] = usuarioSessaoCtr.getEmpresatb01Empresa();

        return super.getListEntity(query.toString(), elements);

    }

}
