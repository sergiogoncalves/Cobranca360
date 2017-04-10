/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.converters;

import br.com.helenamax.cobranca.model.Empresatb02Pessoa;
import br.com.helenamax.cobranca.model.Segurancatb02Processo;
import br.com.helenamax.cobranca.service.Empresatb02PessoaSrv;
import br.com.helenamax.cobranca.service.Segurancatb02ProcessoSrv;
import br.com.helenamax.cobranca.util.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author 005712431
 */
@FacesConverter(forClass = Segurancatb02Processo.class)
public class Segurancatb02ProcessoConverter implements Converter {

    private Segurancatb02ProcessoSrv segurancatb02ProcessoSrv;

    public Segurancatb02ProcessoConverter() {
        this.segurancatb02ProcessoSrv = CDIServiceLocator.getBean(Segurancatb02ProcessoSrv.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Segurancatb02Processo retorno = null;

        if (value != null && !value.isEmpty()) {
            int codigo = Integer.valueOf(value);
            retorno = segurancatb02ProcessoSrv.listarPorId(codigo);
        }
        else{
            retorno = new Segurancatb02Processo();
        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String retorno = "";

        if (value != null) {
            if (!value.equals("")) {
                try {

                    int codigo = ((Segurancatb02Processo) value).getCodigoProcesso();
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
