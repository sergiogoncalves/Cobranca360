/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.repository;

import br.com.helenamax.cobranca.controller.UsuarioSessaoCtr;
import br.com.helenamax.cobranca.model.Empresatb01Empresa;
import br.com.helenamax.cobranca.model.Segurancatb01Usuario;
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
public class Segurancatb01UsuarioRep extends BasicRepositorio<Segurancatb01Usuario, Integer> {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Segurancatb01UsuarioRep() {
        super(Segurancatb01Usuario.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }

    public List<Segurancatb01Usuario> criteriaBuscarUsuario(Segurancatb01Usuario vo) {

        CriteriaBuilder builder = getCriteriaBuilder();
        CriteriaQuery<Segurancatb01Usuario> criteriaQuery = builder.createQuery(Segurancatb01Usuario.class);
        Root<Segurancatb01Usuario> a = criteriaQuery.from(Segurancatb01Usuario.class);

        criteriaQuery.select(a);

        List<Predicate> predicates = new ArrayList<>();

        ParameterExpression<Empresatb01Empresa> empresa = builder.parameter(Empresatb01Empresa.class, "empresa");
        predicates.add(builder.equal(a.get("empresatb02Pessoa").get("empresatb01Empresa"), empresa));

        if (vo.getLogin() != null && !vo.getLogin().equals("")) {
            ParameterExpression<String> login = builder.parameter(String.class, "login");

            predicates.add(builder.like(a.<String>get("login"), login));
        }
        if (vo.getEmpresatb02Pessoa() != null) {

            if (vo.getEmpresatb02Pessoa().getNome() != null && !vo.getEmpresatb02Pessoa().getNome().equals("")) {
                ParameterExpression<String> nome = builder.parameter(String.class, "nome");
                predicates.add(builder.like(a.<String>get("empresatb02Pessoa").<String>get("nome"), nome));
            }
        }

        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        TypedQuery<Segurancatb01Usuario> query = getEntityManager().createQuery(criteriaQuery);

        query.setParameter("empresa", usuarioSessaoCtr.getEmpresatb01Empresa());

        if (vo.getLogin() != null && !vo.getLogin().equals("")) {
            query.setParameter("login", "%" + vo.getLogin() + "%");
        }

        if (vo.getEmpresatb02Pessoa() != null) {
            if (vo.getEmpresatb02Pessoa().getNome() != null && !vo.getEmpresatb02Pessoa().getNome().equals("")) {
                query.setParameter("nome", "%" + vo.getEmpresatb02Pessoa().getNome() + "%");
            }
        }
        return query.getResultList();
    }

    public Segurancatb01Usuario buscarPorLoginEmpresa(String login, Empresatb01Empresa empresa) {
        //manager.createQuery("select c from Segurancatb01Usuario c where c.empresatb02Pessoa.empresatb01Empresa = ?1 AND c.login = ?2 ");
        StringBuilder query = new StringBuilder();
        Object[] elements = new Object[2];

        query.append(" select c from Segurancatb01Usuario c where c.empresatb02Pessoa.empresatb01Empresa = ?1 AND c.login = ?2 ");

        elements[0] = empresa;
        elements[1] = login;

        return super.getSimpleEntity(query.toString(), elements);
    }

}
