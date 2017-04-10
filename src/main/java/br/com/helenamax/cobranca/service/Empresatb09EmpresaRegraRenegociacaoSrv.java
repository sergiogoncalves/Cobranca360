/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.service;

import br.com.helenamax.cobranca.controller.UsuarioSessaoCtr;
import br.com.helenamax.cobranca.jpa.Transactional;
import br.com.helenamax.cobranca.model.Empresatb01Empresa;
import br.com.helenamax.cobranca.model.Empresatb09EmpresaRegraRenegociacao;
import br.com.helenamax.cobranca.repository.Empresatb09EmpresaRegraRenegociacaoRep;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

public class Empresatb09EmpresaRegraRenegociacaoSrv implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private UsuarioSessaoCtr usuarioSessaoCtr;

    @Inject
    private Empresatb09EmpresaRegraRenegociacaoRep empresatb09EmpresaRegraRenegociacaoRep;

    @Transactional
    public void salvarPersist(Empresatb09EmpresaRegraRenegociacao empresatb09EmpresaRegraRenegociacao) {
        empresatb09EmpresaRegraRenegociacao.setEmpresatb01Empresa(usuarioSessaoCtr.getEmpresatb01Empresa());
        empresatb09EmpresaRegraRenegociacaoRep.salvar(empresatb09EmpresaRegraRenegociacao);
    }

    @Transactional
    public void salvarMerge(Empresatb09EmpresaRegraRenegociacao empresatb09EmpresaRegraRenegociacao) {
        empresatb09EmpresaRegraRenegociacao.setEmpresatb01Empresa(usuarioSessaoCtr.getEmpresatb01Empresa());
        empresatb09EmpresaRegraRenegociacaoRep.alterar(empresatb09EmpresaRegraRenegociacao);
    }

    public Empresatb09EmpresaRegraRenegociacao listarPorId(int codigo) {
        return empresatb09EmpresaRegraRenegociacaoRep.pesquisarPorId(codigo);
    }

    public List<Empresatb09EmpresaRegraRenegociacao> listarPorEmpresa(Empresatb01Empresa vo) {
        return empresatb09EmpresaRegraRenegociacaoRep.buscarPorPessoa(vo);
    }

    public List<Empresatb09EmpresaRegraRenegociacao> listarPorEmpresaStatus(Empresatb01Empresa vo, boolean status) {
        return empresatb09EmpresaRegraRenegociacaoRep.buscarPorPessoaStatus(vo, status);
    }

}
