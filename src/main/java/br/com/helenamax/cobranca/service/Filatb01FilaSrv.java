/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.service;

import br.com.helenamax.cobranca.controller.UsuarioSessaoCtr;
import br.com.helenamax.cobranca.jpa.Transactional;
import br.com.helenamax.cobranca.model.Filatb01Fila;
import br.com.helenamax.cobranca.model.Filatb02FilaUsuario;
import br.com.helenamax.cobranca.model.Filatb03FilaDevedor;
import br.com.helenamax.cobranca.repository.Filatb01FilaRep;
import br.com.helenamax.cobranca.repository.Filatb02FilaUsuarioRep;
import br.com.helenamax.cobranca.repository.Filatb03FilaDevedorRep;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

public class Filatb01FilaSrv implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Filatb01FilaRep filatb01FilaRep;

    @Inject
    private UsuarioSessaoCtr usuarioSessaoCtr;

    @Inject
    private Filatb02FilaUsuarioRep filatb02FilaUsuarioRep;

    @Inject
    private Filatb03FilaDevedorRep filatb03FilaDevedorRep;

    @Transactional
    public void salvarPersist(Filatb01Fila filatb01Fila) {
        filatb01Fila.setEmpresatb01Empresa(usuarioSessaoCtr.getEmpresatb01Empresa());
        filatb01Fila.setSegurancatb01Usuario(usuarioSessaoCtr.getSegurancatb01Usuario());
        filatb01FilaRep.salvar(filatb01Fila);

        salvarDados(filatb01Fila);
    }

    @Transactional
    public void salvarMerge(Filatb01Fila filatb01Fila) {
        filatb01Fila.setEmpresatb01Empresa(usuarioSessaoCtr.getEmpresatb01Empresa());
        filatb01Fila.setSegurancatb01Usuario(usuarioSessaoCtr.getSegurancatb01Usuario());
        filatb01FilaRep.alterar(filatb01Fila);

        salvarDados(filatb01Fila);
    }

    private void salvarDados(Filatb01Fila filatb01Fila) {

        for (Filatb02FilaUsuario vo : filatb01Fila.getFilatb02FilaUsuarios()) {
            vo.setFilatb01Fila(filatb01Fila);
            vo.setAtivo(Boolean.TRUE);

            filatb02FilaUsuarioRep.alterar(vo);
        }

        for (Filatb03FilaDevedor vo : filatb01Fila.getFilatb03FilaDevedors()) {
            vo.setFilatb01Fila(filatb01Fila);
            filatb03FilaDevedorRep.alterar(vo);
        }

    }

    public List<Filatb01Fila> listar() {
        return filatb01FilaRep.listar();
    }

    public Filatb01Fila listarPorId(int codigo) {

        Filatb01Fila vo = filatb01FilaRep.getById(codigo);
        return vo;
    }

    public List<Filatb01Fila> buscarPorDataCriacao(Filatb01Fila filatb01Fila, Date dataInicio, Date DataFim) {
        return filatb01FilaRep.buscarPelaDataCriacao(filatb01Fila, dataInicio, DataFim);
    }

}
