/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.repository;

import br.com.helenamax.cobranca.model.Filatb01Fila;
import br.com.helenamax.cobranca.model.Geraltb02TipoContato;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Helena
 */
public class Filatb01FilaRep extends BasicRepositorio<Filatb01Fila, Integer> {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Filatb01FilaRep() {
        super(Filatb01Fila.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }

    public Filatb01Fila getById(int codigo) {
        //manager.createQuery("select c from Empresatb01Empresa c where c.cnpj = ?1")
        return super.pesquisarPorId(codigo);
    }

    public List<Filatb01Fila> buscarPelaDataCriacao(Filatb01Fila filatb01Fila, Date dataInicio, Date DataFim) {
        //manager.createQuery("select c from Filatb01Fila c where c.dataCriacao BETWEEN ?1 and ?2 and c.empresatb01Empresa = ?3");
        
        StringBuilder query = new StringBuilder();
        Object[] elements = new Object[3];

        query.append(" select c from Filatb01Fila c where c.dataCriacao BETWEEN ?1 and ?2 and c.empresatb01Empresa = ?3 ");

        elements[0] = dataInicio;
        elements[1] = DataFim;
        elements[2] = usuarioSessaoCtr.getEmpresatb01Empresa();

        return super.getListEntity(query.toString(), elements);
    }

}
