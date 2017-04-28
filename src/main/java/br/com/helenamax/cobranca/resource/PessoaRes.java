/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.resource;

import br.com.helenamax.cobranca.model.Empresatb01Empresa;
import br.com.helenamax.cobranca.service.Empresatb01EmpresaSrv;
import com.thoughtworks.xstream.XStream;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author 005712431
 */
@Path("Empresa")
public class PessoaRes {

    @Inject
    private Empresatb01Empresa empresatb01Empresa;

    @Inject
    private Empresatb01EmpresaSrv empresatb01EmpresaSrv;

    @Path("{codg}")
    @GET
   // @Produces(MediaType.APPLICATION_XML)
    public String busca(@PathParam("codg") int codg) {
        
        //String teste;
        //teste = new XStream().fromXML(empresatb01EmpresaSrv.listarPorId(codg));
        
       //return 
        return "";
    }

}
