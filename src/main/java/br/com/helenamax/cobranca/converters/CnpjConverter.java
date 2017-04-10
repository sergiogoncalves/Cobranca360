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
 * @author 005712431
 */
@FacesConverter("cnpjConverter")
public class CnpjConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        }
         return StringUtil.format("##.###.###/####-##", value, true);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return StringUtil.format("##.###.###/####-##", value, true);
    }

}
