/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.util;

import java.text.ParseException;
import java.util.Random;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author 016255421
 */
public class StringUtil {

    public static String replaceNumerico(String valor) {

        if (Validador.isStringValida(valor)) {
            valor = valor.replace(".", "").replace(",", ".");
            return valor;

        }

        return valor;
    }

    public static String[] splitPropriedade(String valor) {

        return valor.split("[\\W]");
    }

    public static String format(String pattern, Object value, boolean suppressZero) {
        if (!suppressZero || Double.parseDouble(value.toString()) != 0) {
            MaskFormatter mask;
            try {
                mask = new MaskFormatter(pattern);
                mask.setValueContainsLiteralCharacters(false);
                return mask.valueToString(value);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } else {
            return "";
        }
    }

    public static String removeMascara(String pattern, String valor) {
        return valor.replaceAll(pattern, "");
    }

    public static int retornaNumeroAlatorio() {
        Random r = new Random();

        return r.nextInt(1000);
    }

}
