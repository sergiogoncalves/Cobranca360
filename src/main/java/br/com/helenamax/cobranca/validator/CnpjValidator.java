/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.validator;

import br.com.helenamax.cobranca.util.StringUtil;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator("cnpjValidator")
public class CnpjValidator implements  Validator  {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value != null) {
            String cnpj = StringUtil.removeMascara("##.###.###/####-##", value.toString());

            if (cnpj.length() != 14) {

                FacesMessage msg
                        = new FacesMessage("Falha no cadastro", "Cnpj inválido");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                
                throw new ValidatorException(msg);

            }

        }
    }

}
