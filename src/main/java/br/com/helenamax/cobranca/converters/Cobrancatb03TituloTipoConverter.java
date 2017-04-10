/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.converters;

import br.com.helenamax.cobranca.model.Cobrancatb03TituloTipo;
import br.com.helenamax.cobranca.service.Cobrancatb03TituloTipoSrv;
import br.com.helenamax.cobranca.util.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author 005712431
 */
@FacesConverter("cobrancatb03TituloTipoConverter")
public class Cobrancatb03TituloTipoConverter implements Converter {

    private Cobrancatb03TituloTipoSrv cobrancatb03TituloTipoSrv;

    public Cobrancatb03TituloTipoConverter() {
        this.cobrancatb03TituloTipoSrv = CDIServiceLocator.getBean(Cobrancatb03TituloTipoSrv.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Cobrancatb03TituloTipo retorno = null;

        if (value != null && !value.isEmpty()) {
            int codigo = Integer.valueOf(value);
            retorno = cobrancatb03TituloTipoSrv.listarPorId(codigo);
        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String retorno = "";

        if (value != null) {
            if (!value.equals("")) {
                try {

                    int codigo = ((Cobrancatb03TituloTipo) value).getCodigoTituloTipo();
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
