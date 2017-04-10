/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.repository;

import br.com.helenamax.cobranca.model.Empresatb01Empresa;
import br.com.helenamax.cobranca.model.Empresatb02Pessoa;
import br.com.helenamax.cobranca.model.Empresatb03PessoaFisica;
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
public class Empresatb03PessoaFisicaRep extends BasicRepositorio<Empresatb03PessoaFisica, Integer> {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Empresatb03PessoaFisicaRep() {
        super(Empresatb03PessoaFisica.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }

    public List<Empresatb03PessoaFisica> buscarPessoa(Empresatb03PessoaFisica vo) {
        //manager.createQuery("select c from Empresatb03PessoaFisica c WHERE c.empresatb02Pessoa.empresatb01Empresa = :Empresa   AND c.docFederal like %?1% AND c.empresatb02Pessoa.nome = like %?2% ");

        StringBuilder query = new StringBuilder();
        Object[] elements = new Object[3];

        query.append("select c from Empresatb03PessoaFisica c WHERE c.empresatb02Pessoa.empresatb01Empresa = ?1 ");

        elements[0] = vo.getEmpresatb02Pessoa().getEmpresatb01Empresa();

        if (vo.getDocFederal() != null && !vo.getDocFederal().equals("")) {

            query.append(" AND c.docFederal like ?2 ");
            elements[1] = "%" + vo.getDocFederal() + "%";

        } else {
            elements[1] = null;
        }

        if (vo.getEmpresatb02Pessoa().getNome() != null && !vo.getEmpresatb02Pessoa().getNome().equals("")) {
            query.append(" AND c.empresatb02Pessoa.nome like ?3 ");
            elements[2] = "%" + vo.getEmpresatb02Pessoa().getNome() + "%";

        } else {
            elements[2] = null;
        }

        return super.getListEntity(query.toString(), elements);
    }

    public List<Empresatb03PessoaFisica> criteriaBuscarPessoa(Empresatb03PessoaFisica vo) {

        CriteriaBuilder builder = getCriteriaBuilder();
        CriteriaQuery<Empresatb03PessoaFisica> criteriaQuery = builder.createQuery(Empresatb03PessoaFisica.class);
        Root<Empresatb03PessoaFisica> a = criteriaQuery.from(Empresatb03PessoaFisica.class);

        criteriaQuery.select(a);

        List<Predicate> predicates = new ArrayList<>();

        ParameterExpression<Empresatb01Empresa> empresa = builder.parameter(Empresatb01Empresa.class, "empresa");
        predicates.add(builder.equal(a.get("empresatb02Pessoa").get("empresatb01Empresa"), empresa));

        if (vo.getDocFederal() != null && !vo.getDocFederal().equals("")) {
            ParameterExpression<String> docFederal = builder.parameter(String.class, "docFederal");

            predicates.add(builder.like(a.<String>get("docFederal"), docFederal));
        }

        if (vo.getEmpresatb02Pessoa().getNome() != null && !vo.getEmpresatb02Pessoa().getNome().equals("")) {
            ParameterExpression<String> nome = builder.parameter(String.class, "nome");
            predicates.add(builder.like(a.<String>get("empresatb02Pessoa").<String>get("nome"), nome));
        }

        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        TypedQuery<Empresatb03PessoaFisica> query = getEntityManager().createQuery(criteriaQuery);

        query.setParameter("empresa", usuarioSessaoCtr.getEmpresatb01Empresa());

        if (vo.getDocFederal() != null && !vo.getDocFederal().equals("")) {
            query.setParameter("docFederal", "%" + vo.getDocFederal() + "%");
        }

        if (vo.getEmpresatb02Pessoa().getNome() != null && !vo.getEmpresatb02Pessoa().getNome().equals("")) {
            query.setParameter("nome", "%" + vo.getEmpresatb02Pessoa().getNome() + "%");
        }

        return query.getResultList();
    }

    public Empresatb03PessoaFisica criteriaBuscaPorPessoa(Empresatb02Pessoa vo) {
        CriteriaBuilder builder = getCriteriaBuilder();
        CriteriaQuery<Empresatb03PessoaFisica> criteriaQuery = builder.createQuery(Empresatb03PessoaFisica.class);
        Root<Empresatb03PessoaFisica> a = criteriaQuery.from(Empresatb03PessoaFisica.class);

        criteriaQuery.select(a);

        List<Predicate> predicates = new ArrayList<>();

        ParameterExpression<Empresatb02Pessoa> pessoa = builder.parameter(Empresatb02Pessoa.class, "pessoa");
        predicates.add(builder.equal(a.get("empresatb02Pessoa"), pessoa));

        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        TypedQuery<Empresatb03PessoaFisica> query = getEntityManager().createQuery(criteriaQuery);
        query.setParameter("pessoa", vo);
        
        return query.getSingleResult();
    }
}
