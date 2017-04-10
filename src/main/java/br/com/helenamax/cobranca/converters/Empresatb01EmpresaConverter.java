/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.converters;

import br.com.helenamax.cobranca.model.Empresatb01Empresa;
import br.com.helenamax.cobranca.service.Empresatb01EmpresaSrv;
import br.com.helenamax.cobranca.util.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author 005712431
 */
@FacesConverter(forClass = Empresatb01Empresa.class)
public class Empresatb01EmpresaConverter implements Converter {

    private Empresatb01EmpresaSrv empresatb01EmpresaSrv;

    public Empresatb01EmpresaConverter() {
        this.empresatb01EmpresaSrv = CDIServiceLocator.getBean(Empresatb01EmpresaSrv.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Empresatb01Empresa retorno = null;

        if (value != null && !value.isEmpty()) {
            int codigo = Integer.valueOf(value);
            retorno = empresatb01EmpresaSrv.listarPorId(codigo);
        }
        else{
            retorno = new Empresatb01Empresa();
        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String retorno = "";

        if (value != null) {
            if (!value.equals("")) {
                try {

                    int codigo = ((Empresatb01Empresa) value).getCodigoEmpresa();
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
