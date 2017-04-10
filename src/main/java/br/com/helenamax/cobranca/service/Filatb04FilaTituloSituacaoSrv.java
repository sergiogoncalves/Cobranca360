package br.com.helenamax.cobranca.service;

import br.com.helenamax.cobranca.controller.UsuarioSessaoCtr;
import br.com.helenamax.cobranca.jpa.Transactional;
import br.com.helenamax.cobranca.model.Filatb04FilaTituloSituacao;
import br.com.helenamax.cobranca.repository.Filatb04FilaTituloSituacaoRep;
import java.io.Serializable;
import javax.inject.Inject;

public class Filatb04FilaTituloSituacaoSrv implements Serializable {

    private static final long serialVersionUID = 1L;


    @Inject
    private UsuarioSessaoCtr usuarioSessaoCtr;
    
    @Inject
    private Filatb04FilaTituloSituacaoRep filatb04FilaTituloSituacaoRep;

    @Transactional
    public void salvarPersist(Filatb04FilaTituloSituacao filatb04FilaTituloSituacao) {
        filatb04FilaTituloSituacaoRep.salvar(filatb04FilaTituloSituacao);
    }

    @Transactional
    public void salvarMerge(Filatb04FilaTituloSituacao filatb04FilaTituloSituacao) {
        filatb04FilaTituloSituacaoRep.alterar(filatb04FilaTituloSituacao);
    }
    
    public Filatb04FilaTituloSituacao buscarPorSigla(String sigla){
        return filatb04FilaTituloSituacaoRep.buscarPorSigla(sigla);
    }


}
