/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.repository;

import br.com.helenamax.cobranca.model.Cobrancatb01Titulo;
import br.com.helenamax.cobranca.model.Cobrancatb02TituloParcela;
import br.com.helenamax.cobranca.model.Empresatb02Pessoa;
import br.com.helenamax.cobranca.model.Geraltb01SituacaoFinanceira;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Helena
 */
public class Cobrancatb02TituloParcelaRep extends BasicRepositorio<Cobrancatb02TituloParcela, Integer> {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Cobrancatb02TituloParcelaRep() {
        super(Cobrancatb02TituloParcela.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }

    public Cobrancatb02TituloParcela getById(int codigo) {
        //manager.createQuery("select c from Empresatb01Empresa c where c.cnpj = ?1")
        return super.pesquisarPorId(codigo);
    }
    
    public List<Cobrancatb02TituloParcela> buscarPorTitulo(Cobrancatb01Titulo vo) {

        StringBuilder query = new StringBuilder();
        Object[] elements = new Object[1];

        query.append(" select c from Cobrancatb02TituloParcela c WHERE c.cobrancatb01Titulo = ?1 ");

        elements[0] = vo;

        return super.getListEntity(query.toString(), elements);
    }
    
       public List<Cobrancatb02TituloParcela> buscarPorDevedorSituacao(Empresatb02Pessoa devedor, Geraltb01SituacaoFinanceira situacao, Empresatb02Pessoa credor) {
        
        //manager.createQuery("select a from Cobrancatb02TituloParcela a JOIN a.cobrancatb01Titulo b WHERE b.empresatb02PessoaDevedor = ?1 and a.geraltb01SituacaoFinanceira = ?2 and b.empresatb02PessoaCredor = ?3");

        StringBuilder query = new StringBuilder();
        Object[] elements = new Object[3];

        query.append(" select a from Cobrancatb02TituloParcela a JOIN a.cobrancatb01Titulo b WHERE b.empresatb02PessoaDevedor = ?1 and a.geraltb01SituacaoFinanceira = ?2 and b.empresatb02PessoaCredor = ?3 ");

        elements[0] = devedor;
        elements[1] = situacao;
        elements[2] = credor;

        return super.getListEntity(query.toString(), elements);
    }


}
