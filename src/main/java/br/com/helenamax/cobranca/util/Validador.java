package br.com.helenamax.cobranca.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author 016255421
 */
public class Validador {

    public static boolean isObjectValido(Object object) {

        return object != null;

    }
    
    public static ArrayList iniciarList(){
        return new ArrayList();
    }

    public static boolean isArrayValido(Object[] array) {
        return (array != null) && (array.length >= 1);
    }

    public static boolean isCollectionValida(Collection collection) {
        return (collection != null) && (!collection.isEmpty());
    }

    public static boolean isListValida(List list) {
        return (list != null) && (!list.isEmpty());
    }

    public static boolean isMapValido(Map map) {
        return (map != null) && (!map.isEmpty());
    }

    public static boolean isStringValida(String valorString) {
        return (valorString != null) && (!valorString.trim().equals(""));
    }

    public static boolean isDataValida(Date data) {
        return (data != null) && (data.getTime() >= -2208972740000L);
    }

    public static boolean isNumericoValido(byte numero) {
        return validarNumero(numero);
    }

    public static boolean isNumericoValido(short numero) {
        return validarNumero(numero);
    }

    public static boolean isNumericoValido(int numero) {
        return validarNumero(numero);
    }

    public static boolean isNumericoValido(long numero) {
        return validarNumero(numero);
    }

    public static boolean isNumericoValido(float numero) {
        return validarNumero(numero);
    }

    public static boolean isNumericoValido(double numero) {
        return validarNumero(numero);
    }

    public static boolean isNumericoValido(Byte numero) {
        return validarNumero(numero);
    }

    public static boolean isNumericoValido(Short numero) {
        return validarNumero(numero);
    }

    public static boolean isNumericoValido(Integer numero) {
        return validarNumero(numero);
    }

    public static boolean isNumericoValido(Long numero) {
        return validarNumero(numero);
    }

    public static boolean isNumericoValido(Float numero) {
        return validarNumero(numero);
    }

    public static boolean isNumericoValido(Double numero) {
        return validarNumero(numero);
    }

    public static boolean isNumericoValido(BigDecimal numero) {
        return validarNumero(numero);
    }

    private static boolean validarNumero(double numero) {
        return numero != 0.0D;
    }

    private static boolean validarNumero(Number numero) {
        return (numero != null) && (numero.doubleValue() != 0.0D);
    }

    public static boolean isCpfValido(String CPF) {

        if (!isStringValida(CPF)) {

            return false;

        }
        CPF = StringUtil.removeMascara("[^0-9]", CPF);;
        if (CPF.equals("00000000000") || CPF.equals("11111111111")
                || CPF.equals("22222222222") || CPF.equals("33333333333")
                || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777")
                || CPF.equals("88888888888") || CPF.equals("99999999999")
                || CPF.length() != 11 || CPF.length() == 14) {

            return (false);
        } else {

            char dig10, dig11;
            int sm, i, r, num, peso;

            // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
            try {
                // Calculo do 1o. Digito Verificador
                sm = 0;
                peso = 10;
                for (i = 0; i < 9; i++) {
                    // converte o i-esimo caractere do CPF em um numero:
                    // por exemplo, transforma o caractere '0' no inteiro 0        
                    // (48 eh a posicao de '0' na tabela ASCII)        
                    num = CPF.charAt(i) - 48;
                    sm = sm + (num * peso);
                    peso = peso - 1;
                }

                r = 11 - (sm % 11);
                if ((r == 10) || (r == 11)) {
                    dig10 = '0';
                } else {
                    dig10 = (char) (r + 48); // converte no respectivo caractere numerico
                }
                // Calculo do 2o. Digito Verificador
                sm = 0;
                peso = 11;
                for (i = 0; i < 10; i++) {
                    num = CPF.charAt(i) - 48;
                    sm = sm + (num * peso);
                    peso = peso - 1;
                }

                r = 11 - (sm % 11);
                if ((r == 10) || (r == 11)) {
                    dig11 = '0';
                } else {
                    dig11 = (char) (r + 48);
                }

                // Verifica se os digitos calculados conferem com os digitos informados.
                if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {

                    return true;
                } else {

                    return (false);
                }
            } catch (InputMismatchException erro) {

                return (false);
            }

        }
    }

    public static boolean isEmailValido(String email) {
        if ((email == null) || (email.trim().length() == 0)) {
            return false;
        }
        String emailPattern = "\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
        Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isNomeValido(String nome) {
        String nomePattern = "^[a-zA-ZéúíóáÉÚÍÓÁèùìòàÈÙÌÒÀõãñÕÃÑêûîôâÊÛÎÔÂëÿüïöäËYÜÏÖÄ\\-\\'\\s]+$";
        if (isStringValida(nome)) {
            return nome.matches(nomePattern);
        }
        return false;
    }

    public static boolean isDigitoValido(String valor) {
        if (isStringValida(valor)) {
            return valor.matches("\\d*");
        }
        return false;
    }
}
