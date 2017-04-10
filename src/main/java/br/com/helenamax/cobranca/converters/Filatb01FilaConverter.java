/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.converters;

import br.com.helenamax.cobranca.model.Empresatb01Empresa;
import br.com.helenamax.cobranca.model.Filatb01Fila;
import br.com.helenamax.cobranca.service.Empresatb01EmpresaSrv;
import br.com.helenamax.cobranca.service.Filatb01FilaSrv;
import br.com.helenamax.cobranca.util.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author 005712431
 */
@FacesConverter(forClass = Filatb01Fila.class)
public class Filatb01FilaConverter implements Converter {

    private Filatb01FilaSrv filatb01FilaSrv;

    public Filatb01FilaConverter() {
        this.filatb01FilaSrv = CDIServiceLocator.getBean(Filatb01FilaSrv.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Filatb01Fila retorno = null;

        if (value != null && !value.isEmpty()) {
            int codigo = Integer.valueOf(value);
            retorno = filatb01FilaSrv.listarPorId(codigo);
        }
        else{
            retorno = new Filatb01Fila();
        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String retorno = "";

        if (value != null) {
            if (!value.equals("")) {
                try {
                    int codigo = ((Filatb01Fila) value).getCodigoFila();
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
