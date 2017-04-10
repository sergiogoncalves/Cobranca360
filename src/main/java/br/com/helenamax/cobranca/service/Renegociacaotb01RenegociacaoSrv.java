/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.service;

import br.com.helenamax.cobranca.controller.ParametroSessaoCtr;
import br.com.helenamax.cobranca.controller.UsuarioSessaoCtr;
import br.com.helenamax.cobranca.jpa.Transactional;
import br.com.helenamax.cobranca.model.Cobrancatb01Titulo;
import br.com.helenamax.cobranca.model.Cobrancatb02TituloParcela;
import br.com.helenamax.cobranca.model.Renegociacaotb01Renegociacao;
import br.com.helenamax.cobranca.model.Renegociacaotb02RenegociacaoParcela;
import br.com.helenamax.cobranca.model.Renegociacaotb03ParcelaRenegociada;
import br.com.helenamax.cobranca.model.Segurancatb01Usuario;
import br.com.helenamax.cobranca.repository.Cobrancatb01TituloRep;
import br.com.helenamax.cobranca.repository.Cobrancatb02TituloParcelaRep;
import br.com.helenamax.cobranca.repository.Renegociacaotb01RenegociacaoRep;
import br.com.helenamax.cobranca.repository.Renegociacaotb02RenegociacaoParcelaRep;
import br.com.helenamax.cobranca.repository.Renegociacaotb03ParcelaRenegociadaRep;
import br.com.helenamax.cobranca.util.HorasUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

public class Renegociacaotb01RenegociacaoSrv implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Renegociacaotb01RenegociacaoRep renegociacaotb01RenegociacaoRep;

    @Inject
    private Renegociacaotb02RenegociacaoParcelaRep renegociacaotb02RenegociacaoParcelaRep;

    @Inject
    private Renegociacaotb03ParcelaRenegociadaRep renegociacaotb03ParcelaRenegociadaRep;

    @Inject
    private Cobrancatb01TituloRep cobrancatb01TituloRep;

    @Inject
    private UsuarioSessaoCtr usuarioSessaoCtr;

    @Inject
    private ParametroSessaoCtr parametroSessaoCtr;

    @Inject
    private Cobrancatb02TituloParcelaRep cobrancatb02TituloParcelaRep;

    @Transactional
    public void salvarPersist(Renegociacaotb01Renegociacao renegociacao,
            List<Cobrancatb02TituloParcela> parcelasRenegociadas) {

        renegociacao.setSegurancatb01Usuario(usuarioSessaoCtr.getSegurancatb01Usuario());

        //Gravar renegociação
        renegociacaotb01RenegociacaoRep.salvar(renegociacao);

        Cobrancatb01Titulo titulo = new Cobrancatb01Titulo();

        titulo.setDataEmissao(HorasUtils.retornarHoraAtual());

        titulo.setValorTitulo(renegociacao.getValorAcordado());

        titulo.setEmpresatb02PessoaCredor(renegociacao.getCredor());

        titulo.setEmpresatb02PessoaDevedor(renegociacao.getDevedor());

        titulo.setGeraltb01SituacaoFinanceira(parametroSessaoCtr.retornarSituacaoPorSigla("A"));

        titulo.setCobrancatb03TituloTipo(parametroSessaoCtr.retornarTituloTipoPorSigla("NM"));

        titulo.setNumeroParcelas(renegociacao.getNumeroParcelas());

        //Gravar o título        
        cobrancatb01TituloRep.salvar(titulo);

//        
        for (Renegociacaotb02RenegociacaoParcela parcela : renegociacao.getRenegociacaotb02RenegociacaoParcelas()) {

            parcela.setRenegociacaotb01Renegociacao(renegociacao);
            Cobrancatb02TituloParcela cobrancaGravar = new Cobrancatb02TituloParcela();
            //Gravar título parcela
            parcela.getCobrancatb02TituloParcela().setCobrancatb01Titulo(titulo);
            parcela.getCobrancatb02TituloParcela().setGeraltb01SituacaoFinanceira(parametroSessaoCtr.retornarSituacaoPorSigla("A"));

            cobrancaGravar = parcela.getCobrancatb02TituloParcela();

            cobrancatb02TituloParcelaRep.salvar(cobrancaGravar);

            parcela.setGeraltb01SituacaoFinanceira(parametroSessaoCtr.retornarSituacaoPorSigla("A"));

            //Gravar renegociação parcela
            parcela.setCobrancatb02TituloParcela(cobrancaGravar);

            renegociacaotb02RenegociacaoParcelaRep.salvar(parcela);
        }
        //------------------------------------------------------------------------------------------------

        for (Cobrancatb02TituloParcela parcelasRenegociada : parcelasRenegociadas) {
            Renegociacaotb03ParcelaRenegociada vo = new Renegociacaotb03ParcelaRenegociada();

            vo.setCobrancatb02TituloParcela(parcelasRenegociada);
            vo.setGeraltb01SituacaoFinanceira(parametroSessaoCtr.retornarSituacaoPorSigla("R"));
            vo.setRenegociacaotb01Renegociacao(renegociacao);

            //Gravar renegociação parcela renegociada
            renegociacaotb03ParcelaRenegociadaRep.salvar(vo);

            //Alerar Status  da parcela
            parcelasRenegociada.setGeraltb01SituacaoFinanceira(parametroSessaoCtr.retornarSituacaoPorSigla("R"));
            cobrancatb02TituloParcelaRep.alterar(parcelasRenegociada);
        }
    }

    @Transactional
    public void salvarMerge(Renegociacaotb01Renegociacao renegociacaotb01Renegociacao) {
        renegociacaotb01RenegociacaoRep.alterar(renegociacaotb01Renegociacao);
    }

    public List<Renegociacaotb01Renegociacao> listar() {
        return renegociacaotb01RenegociacaoRep.listar();
    }

    public Renegociacaotb01Renegociacao listarPorId(int codigo) {

        Renegociacaotb01Renegociacao vo = renegociacaotb01RenegociacaoRep.getById(codigo);
        return vo;
    }

    public List<Renegociacaotb01Renegociacao> listarRenegociacao(Date dataInicial,
            Date dataFinal,
            Segurancatb01Usuario usuario) {
        return renegociacaotb01RenegociacaoRep.bucarRenegociacao(dataInicial, dataFinal, usuario);
    }

    public List<Renegociacaotb01Renegociacao> listarEmpresaData(Date data) {
        return renegociacaotb01RenegociacaoRep.bucarEmpresaData(data);
    }

}
