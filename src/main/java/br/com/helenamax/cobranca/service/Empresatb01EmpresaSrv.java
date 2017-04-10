/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.service;

import br.com.helenamax.cobranca.jpa.Transactional;
import br.com.helenamax.cobranca.model.Empresatb01Empresa;
import br.com.helenamax.cobranca.repository.Empresatb01EmpresaRep;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

public class Empresatb01EmpresaSrv implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Empresatb01EmpresaRep empresatb01EmpresaRep;

    @Transactional
    public void salvarPersist(Empresatb01Empresa Empresatb01Empresa) {
        empresatb01EmpresaRep.salvar(Empresatb01Empresa);
    }

    @Transactional
    public void salvarMerge(Empresatb01Empresa Empresatb01Empresa) {
        empresatb01EmpresaRep.alterar(Empresatb01Empresa);
    }

    public List<Empresatb01Empresa> listar() {
        return empresatb01EmpresaRep.listar();
    }

    public Empresatb01Empresa listarPorId(int codigo) {
        return empresatb01EmpresaRep.pesquisarPorId(codigo);
    }
    
    public Empresatb01Empresa listarPorCnpj(String cnpj){
        return empresatb01EmpresaRep.getEmpresaByCnpj(cnpj);
    }
}
