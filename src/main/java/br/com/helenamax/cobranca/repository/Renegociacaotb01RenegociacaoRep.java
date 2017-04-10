/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.repository;

import br.com.helenamax.cobranca.model.Empresatb01Empresa;
import br.com.helenamax.cobranca.model.Renegociacaotb01Renegociacao;
import br.com.helenamax.cobranca.model.Segurancatb01Usuario;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

public class Renegociacaotb01RenegociacaoRep extends BasicRepositorio<Renegociacaotb01Renegociacao, Integer> {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Renegociacaotb01RenegociacaoRep() {
        super(Renegociacaotb01Renegociacao.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }

    public Renegociacaotb01Renegociacao getById(int codigo) {
        //manager.createQuery("select c from Empresatb01Empresa c where c.cnpj = ?1")
        return super.pesquisarPorId(codigo);
    }

    public List<Renegociacaotb01Renegociacao> buscarPorPessoa(Renegociacaotb01Renegociacao vo) {

        //manager.createQuery(" select c from Empresatb06PessoaContato c where c.empresatb02Pessoa = ?1 ");
        StringBuilder query = new StringBuilder();
        Object[] elements = new Object[1];

        query.append(" select c from Empresatb06PessoaContato c where c.empresatb02Pessoa = ?1 ");

        elements[0] = vo;

        return super.getListEntity(query.toString(), elements);
    }

    public List<Renegociacaotb01Renegociacao> bucarRenegociacao(Date dataInicial,
            Date dataFinal,
            Segurancatb01Usuario usuario) {

        // manager.createQuery(" select c from Renegociacaotb01Renegociacao c where c.segurancatb01Usuario.empresatb02Pessoa.empresatb01Empresa = ?1 and c.dataRenegociacao BETWEEN ?2 and ?3  and c.segurancatb01Usuario ?4");
        StringBuilder query = new StringBuilder();
        Object[] elements;

        query.append(" select c from Renegociacaotb01Renegociacao c where c.segurancatb01Usuario.empresatb02Pessoa.empresatb01Empresa = ?1  ");
        query.append(" and c.dataRenegociacao BETWEEN ?2 and ?3 ");

        if (usuario != null) {
            elements = new Object[4];

            query.append(" and c.segurancatb01Usuario = ?4 ");

            elements[0] = usuarioSessaoCtr.getEmpresatb01Empresa();
            elements[1] = dataInicial;
            elements[2] = dataFinal;
            elements[3] = usuario;
        } else {
            elements = new Object[3];

            elements[0] = usuarioSessaoCtr.getEmpresatb01Empresa();
            elements[1] = dataInicial;
            elements[2] = dataFinal;
        }

        return super.getListEntity(query.toString(), elements);
    }

    public List<Renegociacaotb01Renegociacao> bucarEmpresaData(Date data) {

        //manager.createQuery(" select c from Renegociacaotb01Renegociacao c where DATE(c.dataRenegociacao) = DATE(?1) and c.segurancatb01Usuario.empresatb02Pessoa.empresatb01Empresa = ?2 ");

        StringBuilder query = new StringBuilder();
        Object[] elements;

        query.append(" select c from Renegociacaotb01Renegociacao c where DATE(c.dataRenegociacao) = DATE(?1) and c.segurancatb01Usuario.empresatb02Pessoa.empresatb01Empresa = ?2  ");

        elements = new Object[2];

        elements[0] = data ;
        elements[1] = usuarioSessaoCtr.getEmpresatb01Empresa();


        return super.getListEntity(query.toString(), elements);
    }

}
