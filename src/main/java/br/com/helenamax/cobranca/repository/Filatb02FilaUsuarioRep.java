/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.repository;

import br.com.helenamax.cobranca.model.Filatb02FilaUsuario;
import javax.inject.Inject;
import javax.persistence.EntityManager;

public class Filatb02FilaUsuarioRep extends BasicRepositorio<Filatb02FilaUsuario, Integer> {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Filatb02FilaUsuarioRep() {
        super(Filatb02FilaUsuario.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }

    public Filatb02FilaUsuario getById(int codigo) {
        //manager.createQuery("select c from Empresatb01Empresa c where c.cnpj = ?1")
        return super.pesquisarPorId(codigo);
    }

}
