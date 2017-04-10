package br.com.helenamax.cobranca.repository;

import br.com.helenamax.cobranca.model.Cobrancatb02TituloParcela;
import br.com.helenamax.cobranca.model.Cobrancatb05TituloParcelaCheque;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

public class Cobrancatb05TituloParcelaChequeRep extends BasicRepositorio<Cobrancatb05TituloParcelaCheque, Integer> {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Cobrancatb05TituloParcelaChequeRep() {
        super(Cobrancatb05TituloParcelaCheque.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }

    public Cobrancatb05TituloParcelaCheque getById(int codigo) {
        //manager.createQuery("select c from Empresatb01Empresa c where c.cnpj = ?1")
        return super.pesquisarPorId(codigo);
    }

    public Cobrancatb05TituloParcelaCheque getByTituloParcelaCodigo(Cobrancatb02TituloParcela vo) {
        
        StringBuilder query = new StringBuilder();
        Object[] elements = new Object[1];

        query.append(" select c from Cobrancatb05TituloParcelaCheque c where c.cobrancatb02TituloParcela = ?1 ");

        elements[0] = vo;
        List<Cobrancatb05TituloParcelaCheque> retorno = super.getListEntity(query.toString(), elements);

        return retorno.get(0);

    }

}
