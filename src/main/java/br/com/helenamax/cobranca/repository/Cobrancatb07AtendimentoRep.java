/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.repository;

import br.com.helenamax.cobranca.model.Cobrancatb07Atendimento;
import br.com.helenamax.cobranca.model.Cobrancatb10AtendimentoSituacao;
import br.com.helenamax.cobranca.model.Empresatb01Empresa;
import br.com.helenamax.cobranca.model.Empresatb02Pessoa;
import br.com.helenamax.cobranca.service.Cobrancatb08AtendimentoTituloParcelaSrv;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Helena
 */
public class Cobrancatb07AtendimentoRep extends BasicRepositorio<Cobrancatb07Atendimento, Integer> {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    @Inject
    private Cobrancatb08AtendimentoTituloParcelaSrv cobrancatb08AtendimentoTituloParcelaSrv;

    public Cobrancatb07AtendimentoRep() {
        super(Cobrancatb07Atendimento.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }

    public Cobrancatb07Atendimento getById(int codigo) {
        //manager.createQuery("select c from Empresatb01Empresa c where c.cnpj = ?1")
        return super.pesquisarPorId(codigo);
    }

    public Cobrancatb07Atendimento buscarAvancado(Cobrancatb07Atendimento vo) {
        //manager.createQuery("select c from Cobrancatb07Atendimento c  JOIN FETCH c.cobrancatb09AtendimentoAndamentos INNER JOIN c.cobrancatb08AtendimentoTituloParcelas where c.credor = ?1 and c.devedor = ?2 and c.segurancatb01Usuario = ?3 and c.cobrancatb10AtendimentoSituacao = ?4 ");

        StringBuilder query = new StringBuilder();

        Object[] elements = new Object[4];

        query.append(" select c from Cobrancatb07Atendimento c  where c.credor = ?1 and c.devedor = ?2 and c.segurancatb01Usuario = ?3 and c.cobrancatb10AtendimentoSituacao = ?4 ");

        elements[0] = vo.getCredor();
        elements[1] = vo.getDevedor();
        elements[2] = vo.getSegurancatb01Usuario();
        elements[3] = vo.getCobrancatb10AtendimentoSituacao();

        List<Cobrancatb07Atendimento> lista = new ArrayList<>();

        lista = super.getListEntity(query.toString(), elements);
        if (lista.size() > 0) {
            Cobrancatb07Atendimento retorno = new Cobrancatb07Atendimento();

            retorno = lista.get(0);

            retorno.setCobrancatb08AtendimentoTituloParcelas(cobrancatb08AtendimentoTituloParcelaSrv.listarPorAtendimento(retorno));

            return retorno;
        }

        return null;

    }

    public List<Cobrancatb07Atendimento> buscarEmpresaData(Empresatb01Empresa empresa, Date data) {
        //manager.createQuery("select c from Cobrancatb07Atendimento c where c.dataAtendimento = ?1 and c.segurancatb01Usuario.empresatb02Pessoa.empresatb01Empresa = ?2  ");

        StringBuilder query = new StringBuilder();

        Object[] elements = new Object[2];

        query.append(" select c from Cobrancatb07Atendimento c where DATE(c.dataAtendimento) = DATE(?1) and c.segurancatb01Usuario.empresatb02Pessoa.empresatb01Empresa = ?2 ");

        elements[0] = data;
        elements[1] = empresa;

        return super.getListEntity(query.toString(), elements);

    }

    public List<Cobrancatb07Atendimento> buscarPorDevedorSituacao(Empresatb02Pessoa devedor, Empresatb02Pessoa credor, Cobrancatb10AtendimentoSituacao situacao) {
       // manager.createQuery(" select c from Cobrancatb07Atendimento c where c.segurancatb01Usuario.empresatb02Pessoa.empresatb01Empresa = ?1 and c.devedor = ?2 AND c.devedor = ?3 and c.cobrancatb10AtendimentoSituacao = ?4 ORDER BY c.dataAtendimento  ");

        StringBuilder query = new StringBuilder();

        Object[] elements = new Object[4];

        query.append(" select c from Cobrancatb07Atendimento c where c.segurancatb01Usuario.empresatb02Pessoa.empresatb01Empresa = ?1 and c.devedor = ?2 AND c.credor = ?3 and c.cobrancatb10AtendimentoSituacao = ?4 ORDER BY c.dataAtendimento  ");

        elements[0] = usuarioSessaoCtr.getEmpresatb01Empresa();
        elements[1] = devedor;
        elements[2] = credor;
        elements[3] = situacao;  

        return super.getListEntity(query.toString(), elements);

    }

}
