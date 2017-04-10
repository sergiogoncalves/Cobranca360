/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.converters;

import br.com.helenamax.cobranca.util.StringUtil;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Helena
 */
@FacesConverter("removerMascaraIntegerConverter")
public class RemoverMascaraIntegerConverter  implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        }
        String retorno = StringUtil.removeMascara("[^0-9]", value);
         return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
//        return StringUtil.removeMascara("[^0-9]", value.toString());
        return value.toString();
    }
    
}
