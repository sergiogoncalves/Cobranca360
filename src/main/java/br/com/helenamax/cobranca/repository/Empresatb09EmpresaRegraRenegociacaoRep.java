/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.repository;

import br.com.helenamax.cobranca.model.Empresatb01Empresa;
import br.com.helenamax.cobranca.model.Empresatb09EmpresaRegraRenegociacao;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Helena
 */
public class Empresatb09EmpresaRegraRenegociacaoRep extends BasicRepositorio<Empresatb09EmpresaRegraRenegociacao, Integer> {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Empresatb09EmpresaRegraRenegociacaoRep() {
        super(Empresatb09EmpresaRegraRenegociacao.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }

    public List<Empresatb09EmpresaRegraRenegociacao> buscarPorPessoa(Empresatb01Empresa vo) {

        StringBuilder query = new StringBuilder();
        Object[] elements = new Object[1];

        query.append(" select c from Empresatb09EmpresaRegraRenegociacao c where c.empresatb01Empresa = ?1 ");

        elements[0] = vo;

        return super.getListEntity(query.toString(), elements);
    }

    public List<Empresatb09EmpresaRegraRenegociacao> buscarPorPessoaStatus(Empresatb01Empresa vo, boolean status) {

        //manager.createQuery("select c from Empresatb09EmpresaRegraRenegociacao c where c.empresatb01Empresa ?1 and c.ativo = ?2");
        
        StringBuilder query = new StringBuilder();
        Object[] elements = new Object[2];

        query.append(" select c from Empresatb09EmpresaRegraRenegociacao c where c.empresatb01Empresa = ?1 and c.ativo = ?2 ");

        elements[0] = vo;
        elements[1] = status;

        return super.getListEntity(query.toString(), elements);
    }

}
