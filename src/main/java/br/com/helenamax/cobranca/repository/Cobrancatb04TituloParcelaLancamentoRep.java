package br.com.helenamax.cobranca.repository;

import br.com.helenamax.cobranca.model.Cobrancatb04TituloParcelaLancamento;
import javax.inject.Inject;
import javax.persistence.EntityManager;


public class Cobrancatb04TituloParcelaLancamentoRep extends BasicRepositorio<Cobrancatb04TituloParcelaLancamento, Integer> {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Cobrancatb04TituloParcelaLancamentoRep() {
        super(Cobrancatb04TituloParcelaLancamento.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }

    public Cobrancatb04TituloParcelaLancamento getById(int codigo) {
        //manager.createQuery("select c from Empresatb01Empresa c where c.cnpj = ?1")
        return super.pesquisarPorId(codigo);
    }

}
