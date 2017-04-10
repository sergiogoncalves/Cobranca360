/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.converters;

import br.com.helenamax.cobranca.model.Cobrancatb01Titulo;
import br.com.helenamax.cobranca.service.Cobrancatb01TituloSrv;

import br.com.helenamax.cobranca.util.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author 005712431
 */
@FacesConverter(forClass = Cobrancatb01Titulo.class)
public class Cobrancatb01TituloConverter implements Converter {

    private Cobrancatb01TituloSrv cobrancatb01TituloSrv;

    public Cobrancatb01TituloConverter() {
        this.cobrancatb01TituloSrv = CDIServiceLocator.getBean(Cobrancatb01TituloSrv.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Cobrancatb01Titulo retorno = null;

        if (value != null && !value.isEmpty()) {
            int codigo = Integer.valueOf(value);
            retorno = cobrancatb01TituloSrv.listarPorId(codigo);
        }
        else{
            retorno = new Cobrancatb01Titulo();
        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String retorno = "";

        if (value != null) {
            if (!value.equals("")) {
                try {

                    int codigo = ((Cobrancatb01Titulo) value).getCodigoTitulo();
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
