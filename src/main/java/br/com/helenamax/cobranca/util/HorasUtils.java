package br.com.helenamax.cobranca.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.joda.time.DateTime;
import org.joda.time.Days;

public class HorasUtils {

    public static Date retornarHoraAtual(String timezonePadrao) {

        Calendar cal = new GregorianCalendar();
        cal.setTimeZone(TimeZone.getTimeZone(timezonePadrao));

        int ano = cal.get(Calendar.YEAR);
        int mes = cal.get(Calendar.MONTH);
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        int hora = cal.get(Calendar.HOUR_OF_DAY);
        int minuto = cal.get(Calendar.MINUTE);
        int segundo = cal.get(Calendar.SECOND);

        GregorianCalendar greg = new GregorianCalendar();

        greg.set(ano, mes, dia, hora, minuto, segundo);

        return greg.getTime();
    }

    public static Timestamp retornarHoraAtual() {

        Calendar cal = new GregorianCalendar();

        int ano = cal.get(Calendar.YEAR);
        int mes = cal.get(Calendar.MONTH);
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        int hora = cal.get(Calendar.HOUR_OF_DAY);
        int minuto = cal.get(Calendar.MINUTE);
        int segundo = cal.get(Calendar.SECOND);

        GregorianCalendar greg = new GregorianCalendar();

        greg.set(ano, mes, dia, hora, minuto, segundo);

        return new Timestamp(greg.getTimeInMillis());
    }

    public static int retornarDiferencaEntreDatas(DateTime dataInicial, DateTime dataFinal) {

        int dias = Days.daysBetween(dataInicial, dataFinal).getDays();

        if (dias < 0) {
            dias = 0;
        }
        return dias;
    }

    public static Date addMes(Date data, int qtdeMes) {

        Calendar c = Calendar.getInstance();
        
        c.setTime(data);
        
        c.set(Calendar.MONTH, qtdeMes);

        return c.getTime();
    }

}
