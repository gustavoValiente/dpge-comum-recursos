package br.gov.ms.defensoria.comum.util;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.joda.time.DateTime;

public class DateUtils {

	private static final Calendar calendar = Calendar.getInstance();

	@SuppressWarnings("unused")
	private static final BigDecimal x = new BigDecimal(24 * 60 * 60 * 1000);

	public static Date createDate(int year, int month, int date, int hourOfDay, int minute) {
		calendar.set(year, month, date, hourOfDay, minute);
		return calendar.getTime();
	}

	public static Date createDate(int year, int month, int date, int hourOfDay, int minute, int second) {
		calendar.set(year, month, date, hourOfDay, minute, second);
		return calendar.getTime();
	}

	public static int getYear(Date date) {
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}

	public static int getHour(Date date) {
		calendar.setTime(date);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	public static int getDay(Date date) {
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	public static int getMinute(Date date) {
		calendar.setTime(date);
		return calendar.get(Calendar.MINUTE);
	}

	public static int getSecond(Date date) {
		calendar.setTime(date);
		return calendar.get(Calendar.SECOND);
	}

	public static int getMonth(Date date) {
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH);
	}

	public static Date getInitialDayOfMonth(int month, int year) {
		calendar.set(year, month, 1, 0, 0, 0);
		return calendar.getTime();
	}

	public static Date getAddDay(Date data) {
		Calendar c1 = Calendar.getInstance();
		c1.setTime(data);
		c1.add(Calendar.DAY_OF_MONTH, 1);
		return c1.getTime();
	}

	public static Date getFinalDayOfMonth(int month, int year) {
		calendar.set(year, month, 1, 23, 59, 59);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return calendar.getTime();
	}

	public static BigDecimal numberOfDaysOnMonth(Date date1, Date date2, int month, int year) {
		Date initialDayOfMonth = getInitialDayOfMonth(month, year);
		Date finalDayOfMonth = getFinalDayOfMonth(month, year);
		return numberOfDaysBetweenDates(date1, date2, initialDayOfMonth, finalDayOfMonth);
	}

	@SuppressWarnings("unused")
	public static BigDecimal numberOfDaysBetweenDates(Date date1, Date date2, Date initialDate, Date finalDate) {
		if ((date1.before(finalDate) || (date1.equals(finalDate))) && (date2.after(initialDate) || date2.equals(initialDate))) {
			Date inicial;
			// Date i = date1.before(initialDate) ? initialDate : date1;
			if ((date1.before(initialDate)) || date1.equals(initialDate)) {
				inicial = initialDate;
			} else {
				inicial = date1;
			}
			Date termino;
			// Esta variavel divideMes serve para validação da qtd utilizada de
			// diarias por mes
			BigDecimal divideMes = BigDecimal.ZERO;
			// termino = date2.after(finalDate) ? finalDate : ;
			if (date2.after(finalDate) || date2.equals(finalDate)) {
				termino = finalDate;
				divideMes = BigDecimal.valueOf(0.5);
			} else {
				termino = date2;
			}

		}
		return BigDecimal.ZERO;
	}

	public static int calcularDiasUteis(Date initialDate, Date finalDate) {
		GregorianCalendar dataInicial = new GregorianCalendar();
		GregorianCalendar dataFinal = new GregorianCalendar();

		dataInicial.setTime(initialDate);
		dataFinal.setTime(finalDate);

		int nrDias = 0;
		int indice = 0;
		while (dataInicial.compareTo(dataFinal) == -1) {
			if (indice == 0) {
				dataInicial.add(GregorianCalendar.DAY_OF_MONTH, 0);
			} else {
				dataInicial.add(GregorianCalendar.DAY_OF_MONTH, 1);
			}
			if (dataInicial.get(GregorianCalendar.DAY_OF_WEEK) != GregorianCalendar.SUNDAY && dataInicial.get(GregorianCalendar.DAY_OF_WEEK) != GregorianCalendar.SATURDAY) {
				nrDias++;
			}
			indice++;
		}

		return nrDias;
	}

	public static int calcularDias(Date initialDate, Date finalDate) {
		GregorianCalendar dataInicial = new GregorianCalendar();
		GregorianCalendar dataFinal = new GregorianCalendar();

		dataInicial.setTime(initialDate);
		dataFinal.setTime(finalDate);

		int nrDias = 0;
		int indice = 0;
		while (dataInicial.compareTo(dataFinal) == -1) {
			if (indice == 0) {
				dataInicial.add(GregorianCalendar.DAY_OF_MONTH, 0);
			} else {
				dataInicial.add(GregorianCalendar.DAY_OF_MONTH, 1);
			}
			nrDias++;

			indice++;
		}
		return nrDias;
	}

	public static int diffInDays(Date d1, Date d2) {
		int MILLIS_IN_DAY = 86400000;

		Calendar c1 = Calendar.getInstance();
		c1.setTime(d1);
		c1.set(Calendar.MILLISECOND, 0);
		c1.set(Calendar.SECOND, 0);
		c1.set(Calendar.MINUTE, 0);
		c1.set(Calendar.HOUR_OF_DAY, 0);

		Calendar c2 = Calendar.getInstance();
		c2.setTime(d2);
		c2.set(Calendar.MILLISECOND, 0);
		c2.set(Calendar.SECOND, 0);
		c2.set(Calendar.MINUTE, 0);
		c2.set(Calendar.HOUR_OF_DAY, 0);
		return (int) ((c1.getTimeInMillis() - c2.getTimeInMillis()) / MILLIS_IN_DAY);
	}

	/**
	 * Verifica se um período contém um determinado mês dentro de si.
	 * 
	 * @param date1
	 *            início do período.
	 * @param date2
	 *            fim do período.
	 * @param month
	 *            mês a ser analisado.
	 * @param year
	 *            ano do mês a ser analisado.
	 * @return <code>true</code> caso o período contenha o mês especificado.
	 *         <code>false</code> caso contrário.
	 * @O campo no método numberOfDaysOnMonth "", faz referencia ao tipo de
	 *    pedido de diária quando utiliza esta função.
	 */
	public static boolean containsMonth(Date date1, Date date2, int month, int year) {
		BigDecimal numberOfDaysOnMonth = numberOfDaysOnMonth(date1, date2, month, year);
		return numberOfDaysOnMonth.equals(BigDecimal.ZERO) ? false : true;
	}

	public static DateTime zeraHora(DateTime dateTime) {
		return new DateTime(dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(), 0, 0, 0, 0);
	}

	public static String retornaMes(Integer mes) {
		String mesString = "";
		if (mes == 1)
			mesString = "Janeiro";
		else if (mes == 2)
			mesString = "Fevereiro";
		else if (mes == 3)
			mesString = "Mar�o";
		else if (mes == 4)
			mesString = "Abril";
		else if (mes == 5)
			mesString = "Maio";
		else if (mes == 6)
			mesString = "Junho";
		else if (mes == 7)
			mesString = "Julho";
		else if (mes == 8)
			mesString = "Agosto";
		else if (mes == 9)
			mesString = "Setembro";
		else if (mes == 10)
			mesString = "Outubro";
		else if (mes == 11)
			mesString = "Novembro";
		else if (mes == 12)
			mesString = "Dezembro";

		return mesString;

	}

	public static int retornarQtdMeses(Date dtInicio, Date dtFim) {
		int mesInicio = DateUtils.getMonth(dtInicio) + 1;
		int anoInicio = DateUtils.getYear(dtInicio);
		int mesFim = DateUtils.getMonth(dtFim) + 1;
		int anoFim = DateUtils.getYear(dtFim);
		int qtdMeses = 0;
		if (anoFim == anoInicio) {
			qtdMeses = (mesFim - mesInicio) + 1;
		} else {
			int qtdMesSaida = (12 - mesInicio) + 1;
			int qtdMesChegada = (12 - (12 - mesFim));
			qtdMeses = (qtdMesChegada + qtdMesSaida);
		}
		return qtdMeses;
	}

	public static String getDataPorExtenso(Date data) {
		DateFormat dfmt = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy 'as' HH:mm", new Locale("pt", "BR"));
		return dfmt.format(data);
	}

	public static String getDataPorExtensoDocumento(Date data) {
		DateFormat dfmt = new SimpleDateFormat("dd-MM-yyyy-HH-mm", new Locale("pt", "BR"));
		return dfmt.format(data);
	}

	public static String getDataPorExtensoUSA(Date data) {
		DateFormat dfmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:00.00");
		return dfmt.format(data);
	}

	public static String getHoraPorExtenso(Date data) {
		DateFormat dfmt = new SimpleDateFormat("HH:mm");
		return dfmt.format(data);
	}

	public static String getDataPorExtensoSemHora(Date data) {
		DateFormat dfmt = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy ", new Locale("pt", "BR"));
		return dfmt.format(data);
	}

	public static String getDataPorExtensoNormal(Date data) {
		DateFormat dfmt = new SimpleDateFormat("dd/MM/yyyy ", new Locale("pt", "BR"));
		return dfmt.format(data);
	}
}
