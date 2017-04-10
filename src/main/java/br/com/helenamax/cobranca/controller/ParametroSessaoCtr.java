/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.controller;

import br.com.helenamax.cobranca.model.Cobrancatb03TituloTipo;
import br.com.helenamax.cobranca.model.Cobrancatb10AtendimentoSituacao;
import br.com.helenamax.cobranca.model.Filatb04FilaTituloSituacao;
import br.com.helenamax.cobranca.model.Geraltb01SituacaoFinanceira;
import br.com.helenamax.cobranca.service.Cobrancatb03TituloTipoSrv;
import br.com.helenamax.cobranca.service.Cobrancatb10AtendimentoSituacaoSrv;
import br.com.helenamax.cobranca.service.Filatb04FilaTituloSituacaoSrv;
import br.com.helenamax.cobranca.service.Geraltb01SituacaoFinanceiraSrv;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class ParametroSessaoCtr implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Geraltb01SituacaoFinanceiraSrv geraltb01SituacaoFinanceiraSrv;

    @Inject
    private Cobrancatb03TituloTipoSrv cobrancatb03TituloTipoSrv;
    
    @Inject
    private Cobrancatb10AtendimentoSituacaoSrv cobrancatb10AtendimentoSituacaoSrv;
    
    @Inject
    private Filatb04FilaTituloSituacaoSrv filatb04FilaTituloSituacaoSrv;

    public Map<String, Object> retornarParametrosTelaBuscaPessoa() {
        Map<String, Object> options = new HashMap<>();

        options.put("position", "top");
        options.put("modal", true);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        options.put("width", "50%");
        options.put("height", "480");

        return options;
    }

    public Geraltb01SituacaoFinanceira retornarSituacaoPorSigla(String sigla) {
        return geraltb01SituacaoFinanceiraSrv.listarPorSigla(sigla);
    }

    public Cobrancatb03TituloTipo retornarTituloTipoPorSigla(String sigla) {
        return cobrancatb03TituloTipoSrv.listarPorSigla(sigla);
    }

    public Cobrancatb10AtendimentoSituacao retornarAtendimentoSituacaoPorSigla(String sigla) {
        return cobrancatb10AtendimentoSituacaoSrv.listarPorSigla(sigla);
    }
    
    public Filatb04FilaTituloSituacao retornarSituacaoFilaPorSigla(String sigla){
        return filatb04FilaTituloSituacaoSrv.buscarPorSigla(sigla);
    }

}
