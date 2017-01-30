package br.gov.ms.defensoria.comum.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Formatador {

	private static Locale locale = new Locale("pt", "BR");

	private static final DecimalFormatSymbols REAL = new DecimalFormatSymbols(locale);

	public static Locale getLocaleBrasil() {
		return locale;
	}

	public static String formatarCnpj(String cnpj) {
		if (cnpj == null) {
			return null;
		}
		return cnpj.toString().replaceAll("^(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})$", "$1.$2.$3/$4-$5");
	}

	public static String formatarCep(String cep) {
		if (cep == null) {
			return null;
		}
		return cep.toString().replaceAll("^(\\d{5})(\\d{3})$", "$1-$2");
	}

	public static String formatarMoeda(BigDecimal numero) {
		if (numero == null) {
			return null;
		}
		DecimalFormat formater = new DecimalFormat("###,###,##0.00", REAL);

		return formater.format((Number) numero);
	}

	public static String formatarData(Date data) {
		if (data == null) {
			return null;
		}
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		return format.format(data);
	}

	public static String formatarData(Date data, String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(data);
	}

	public static Date parseDate(String source, String pattern) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.parse(source);
	}

	public static Date parseData(String dataString) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		return format.parse(dataString);
	}

}
