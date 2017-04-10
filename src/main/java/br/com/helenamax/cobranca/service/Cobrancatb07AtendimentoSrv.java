/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.service;

import br.com.helenamax.cobranca.jpa.Transactional;
import br.com.helenamax.cobranca.model.Cobrancatb07Atendimento;
import br.com.helenamax.cobranca.model.Cobrancatb08AtendimentoTituloParcela;
import br.com.helenamax.cobranca.model.Cobrancatb09AtendimentoAndamento;
import br.com.helenamax.cobranca.model.Cobrancatb10AtendimentoSituacao;
import br.com.helenamax.cobranca.model.Empresatb01Empresa;
import br.com.helenamax.cobranca.model.Empresatb02Pessoa;
import br.com.helenamax.cobranca.repository.Cobrancatb07AtendimentoRep;
import br.com.helenamax.cobranca.repository.Cobrancatb08AtendimentoTituloParcelaRep;
import br.com.helenamax.cobranca.repository.Cobrancatb09AtendimentoAndamentoRep;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

public class Cobrancatb07AtendimentoSrv implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Cobrancatb07AtendimentoRep cobrancatb07AtendimentoRep;

    @Inject
    private Cobrancatb09AtendimentoAndamentoRep cobrancatb09AtendimentoAndamentoRep;

    @Inject
    private Cobrancatb08AtendimentoTituloParcelaRep cobrancatb08AtendimentoTituloParcela;

    @Transactional
    public void salvarPersist(Cobrancatb07Atendimento cobrancatb07Atendimento) {

        cobrancatb07AtendimentoRep.salvar(cobrancatb07Atendimento);

        salvarAndamento(cobrancatb07Atendimento);
        salvarTituloParcela(cobrancatb07Atendimento);
    }

    private void salvarAndamento(Cobrancatb07Atendimento cobrancatb07Atendimento) {

        if (cobrancatb07Atendimento.getCobrancatb09AtendimentoAndamentos() != null) {
            if (cobrancatb07Atendimento.getCobrancatb09AtendimentoAndamentos().size() > 0) {
                for (Cobrancatb09AtendimentoAndamento vo : cobrancatb07Atendimento.getCobrancatb09AtendimentoAndamentos()) {
                    vo.setCobrancatb07Atendimento(cobrancatb07Atendimento);

                    cobrancatb09AtendimentoAndamentoRep.alterar(vo);
                }
            }
        }
    }

    private void salvarTituloParcela(Cobrancatb07Atendimento cobrancatb07Atendimento) {

        if (cobrancatb07Atendimento.getCobrancatb08AtendimentoTituloParcelas() != null) {
            if (cobrancatb07Atendimento.getCobrancatb08AtendimentoTituloParcelas().size() > 0) {

                for (Cobrancatb08AtendimentoTituloParcela vo : cobrancatb07Atendimento.getCobrancatb08AtendimentoTituloParcelas()) {

                    vo.setCobrancatb07Atendimento(cobrancatb07Atendimento);
                    cobrancatb08AtendimentoTituloParcela.alterar(vo);
                }

            }

        }

    }

    @Transactional
    public void salvarMerge(Cobrancatb07Atendimento cobrancatb07Atendimento) {
        cobrancatb07AtendimentoRep.alterar(cobrancatb07Atendimento);
        salvarAndamento(cobrancatb07Atendimento);
        salvarTituloParcela(cobrancatb07Atendimento);
    }

    public List<Cobrancatb07Atendimento> listar() {
        return cobrancatb07AtendimentoRep.listar();
    }

    public Cobrancatb07Atendimento listarPorId(int codigo) {

        Cobrancatb07Atendimento vo = cobrancatb07AtendimentoRep.getById(codigo);
        return vo;
    }

    public Cobrancatb07Atendimento buscarAberto(Cobrancatb07Atendimento cobrancatb07Atendimento) {

        Cobrancatb07Atendimento vo = cobrancatb07AtendimentoRep.buscarAvancado(cobrancatb07Atendimento);

        return vo;
    }

    public List<Cobrancatb07Atendimento> buscarPorEmpresaData(Empresatb01Empresa empresa, Date data) {
        return cobrancatb07AtendimentoRep.buscarEmpresaData(empresa, data);
    }

    public List<Cobrancatb07Atendimento> buscarPorDevedorSituacao(Empresatb02Pessoa devedor, Empresatb02Pessoa credor, Cobrancatb10AtendimentoSituacao situacao) {
        return cobrancatb07AtendimentoRep.buscarPorDevedorSituacao(devedor, credor, situacao);
    }

}
