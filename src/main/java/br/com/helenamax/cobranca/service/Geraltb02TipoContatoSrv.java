/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.service;

import br.com.helenamax.cobranca.jpa.Transactional;
import br.com.helenamax.cobranca.model.Geraltb02TipoContato;
import br.com.helenamax.cobranca.repository.Geraltb02TipoContatoRep;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

public class Geraltb02TipoContatoSrv implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Geraltb02TipoContatoRep geraltb02TipoContatoRep;

    @Transactional
    public void salvarPersist(Geraltb02TipoContato geraltb02TipoContato) {
        geraltb02TipoContatoRep.salvar(geraltb02TipoContato);
    }

    @Transactional
    public void salvarMerge(Geraltb02TipoContato geraltb02TipoContato) {
        geraltb02TipoContatoRep.alterar(geraltb02TipoContato);
    }

    public List<Geraltb02TipoContato> listar() {
        return geraltb02TipoContatoRep.listar();
    }

    public Geraltb02TipoContato listarPorId(int codigo) {
        
        Geraltb02TipoContato vo = geraltb02TipoContatoRep.getById(codigo);
        return vo;
    }

}
