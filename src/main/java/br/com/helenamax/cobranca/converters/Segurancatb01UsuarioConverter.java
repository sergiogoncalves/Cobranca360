/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.converters;

import br.com.helenamax.cobranca.model.Segurancatb01Usuario;
import br.com.helenamax.cobranca.service.Empresatb03PessoaFisicaSrv;
import br.com.helenamax.cobranca.service.Segurancatb01UsuarioSrv;
import br.com.helenamax.cobranca.util.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author 005712431
 */
@FacesConverter(forClass = Segurancatb01Usuario.class)
public class Segurancatb01UsuarioConverter implements Converter {

    private Segurancatb01UsuarioSrv segurancatb01UsuarioSrv;

    private Empresatb03PessoaFisicaSrv empresatb03PessoaFisicaSrv;

    public Segurancatb01UsuarioConverter() {
        this.segurancatb01UsuarioSrv = CDIServiceLocator.getBean(Segurancatb01UsuarioSrv.class);
        this.empresatb03PessoaFisicaSrv = CDIServiceLocator.getBean(Empresatb03PessoaFisicaSrv.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Segurancatb01Usuario retorno = null;

        if (value != null && !value.isEmpty()) {
            int codigo = Integer.valueOf(value);
            retorno = segurancatb01UsuarioSrv.listarPorId(codigo);

            if (retorno.getEmpresatb02Pessoa().getTipoPessoa().equals("F")) {
                retorno.getEmpresatb02Pessoa().setEmpresatb03PessoaFisica(empresatb03PessoaFisicaSrv.listarPorPessoa(retorno.getEmpresatb02Pessoa()));  
            }
            
        } else {
            retorno = new Segurancatb01Usuario();
        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String retorno = "";

        if (value != null) {
            if (!value.equals("")) {
                try {

                    int codigo = ((Segurancatb01Usuario) value).getCodigoUsuario();
                    if (codigo != 0) {
                        retorno = String.valueOf(codigo);
                    }

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                return retorno;
            }
        }
        return "";
    }

}
