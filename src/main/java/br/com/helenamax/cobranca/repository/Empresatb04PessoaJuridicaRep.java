/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.repository;

import br.com.helenamax.cobranca.model.Empresatb01Empresa;
import br.com.helenamax.cobranca.model.Empresatb04PessoaJuridica;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Helena
 */
public class Empresatb04PessoaJuridicaRep extends BasicRepositorio<Empresatb04PessoaJuridica, Integer> {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Empresatb04PessoaJuridicaRep() {
        super(Empresatb04PessoaJuridica.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }

    public List<Empresatb04PessoaJuridica> criteriaBuscarPessoa(Empresatb04PessoaJuridica vo) {

        CriteriaBuilder builder = getCriteriaBuilder();
        CriteriaQuery<Empresatb04PessoaJuridica> criteriaQuery = builder.createQuery(Empresatb04PessoaJuridica.class);
        Root<Empresatb04PessoaJuridica> a = criteriaQuery.from(Empresatb04PessoaJuridica.class);

        criteriaQuery.select(a);

        List<Predicate> predicates = new ArrayList<>();

        ParameterExpression<Empresatb01Empresa> empresa = builder.parameter(Empresatb01Empresa.class, "empresa");
        predicates.add(builder.equal(a.get("empresatb02Pessoa").get("empresatb01Empresa"), empresa));

        if (vo.getCnpj() != null && !vo.getCnpj().equals("")) {
            ParameterExpression<String> cnpj = builder.parameter(String.class, "cnpj");

            predicates.add(builder.like(a.<String>get("cnpj"), cnpj));
        }

        if (vo.getNomeFantasia() != null && !vo.getNomeFantasia().equals("")) {
            ParameterExpression<String> nomeFantasia = builder.parameter(String.class, "nomeFantasia");
            predicates.add(builder.like(a.<String>get("nomeFantasia"), nomeFantasia));
        }

        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        TypedQuery<Empresatb04PessoaJuridica> query = getEntityManager().createQuery(criteriaQuery);

        query.setParameter("empresa", usuarioSessaoCtr.getEmpresatb01Empresa());

        if (vo.getCnpj() != null && !vo.getCnpj().equals("")) {
            query.setParameter("cnpj", "%" + vo.getCnpj() + "%");
        }

        if (vo.getNomeFantasia() != null && !vo.getNomeFantasia().equals("")) {
            query.setParameter("nome", "%" + vo.getNomeFantasia() + "%");
        }

        return query.getResultList();
    }
}
