/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.converters;

import br.com.helenamax.cobranca.model.Geraltb02TipoContato;
import br.com.helenamax.cobranca.service.Geraltb02TipoContatoSrv;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.com.helenamax.cobranca.util.CDIServiceLocator;

/**
 *
 * @author Helena
 */
@FacesConverter("tipoContatoConverter")
public class TipoContatoConverter implements Converter {

    private Geraltb02TipoContatoSrv geraltb02TipoContatoSrv;

     public TipoContatoConverter() {
        try {
            geraltb02TipoContatoSrv = CDIServiceLocator.getBean(Geraltb02TipoContatoSrv.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Geraltb02TipoContato retorno = null;

        try {

            if (value != null && !value.isEmpty()) {

                int codigo = Integer.valueOf(value);

                retorno = geraltb02TipoContatoSrv.listarPorId(codigo);

                return retorno;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String retorno = "";

        if (value != null) {

            if (!value.equals("")) {
                try {
                    
                    int codigo = ((Geraltb02TipoContato) value).getCodigoTipoContato();
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
