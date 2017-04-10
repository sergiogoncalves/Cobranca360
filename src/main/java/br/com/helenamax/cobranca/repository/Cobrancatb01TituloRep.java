/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.repository;

import br.com.helenamax.cobranca.model.Cobrancatb01Titulo;
import br.com.helenamax.cobranca.model.Empresatb02Pessoa;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Helena
 */
public class Cobrancatb01TituloRep extends BasicRepositorio<Cobrancatb01Titulo, Integer> {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Cobrancatb01TituloRep() {
        super(Cobrancatb01Titulo.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }

    public Cobrancatb01Titulo getById(int codigo) {
        //manager.createQuery("select c from Empresatb01Empresa c where c.cnpj = ?1")
        return super.pesquisarPorId(codigo);
    }

    public List<Cobrancatb01Titulo> buscarPorPessoa(Empresatb02Pessoa vo) {

        StringBuilder query = new StringBuilder();
        Object[] elements = new Object[3];

        query.append("select c from Cobrancatb01Titulo c where c.empresatb02PessoaDevedor = ?1 ");

        elements[0] = vo;

        return super.getListEntity(query.toString(), elements);
    }

    public List<Cobrancatb01Titulo> buscarPorParametro(int diasAtrasoInicio,
            int diasAtrasoFim,
            Double valorInicio,
            Double valorFim
    ) {

        //manager.createQuery("select c from Cobrancatb01Titulo c JOIN c.cobrancatb02TituloParcelas d WHERE c.empresatb02PessoaCredor.empresatb01Empresa = ?1 DATEDIFF(DATE(NOW()), DATE(d.dataVencimento)) between ?1 and ?2  and d.valorParcela between ?1 and ?2 ");
        StringBuilder query = new StringBuilder();
        Object[] elements = new Object[3];
        //elements[0] = usuarioSessaoCtr.getEmpresatb01Empresa();

        query.append(" select c from Cobrancatb01Titulo c JOIN c.cobrancatb02TituloParcelas d WHERE c.empresatb02PessoaCredor.empresatb01Empresa = :Empresa ");

        if (diasAtrasoFim > 0) {
            query.append(" AND DATEDIFF(DATE(NOW()), DATE(d.dataVencimento)) between :diasInicio and :diasFim  ");
        }

        if (valorFim != null && valorFim > 0d) {
            query.append(" and d.valorParcela between :valorInicio and :valorFim  ");
        }

        TypedQuery<Cobrancatb01Titulo> queryBd = manager.createQuery(query.toString(), Cobrancatb01Titulo.class);

        queryBd.setParameter("Empresa", usuarioSessaoCtr.getEmpresatb01Empresa());

        if (diasAtrasoFim > 0) {

            queryBd.setParameter("diasInicio", diasAtrasoInicio);

            queryBd.setParameter("diasFim", diasAtrasoFim);
        }

        if (valorFim != null && valorFim > 0d) {

            queryBd.setParameter("valorInicio", new BigDecimal(valorInicio)  );

            queryBd.setParameter("valorFim", new BigDecimal(valorFim));
        }

        return queryBd.getResultList();
    }

}
