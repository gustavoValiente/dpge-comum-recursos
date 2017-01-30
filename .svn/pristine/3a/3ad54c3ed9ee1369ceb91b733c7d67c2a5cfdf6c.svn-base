package br.gov.ms.defensoria.comum.util;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;

public class ValidatorUtil {

	/**
	 * MÃ©todo que recebe uma string com o cnpj (com '.' '/' '-' ou nao) e verifica se o nÃºmero Ã© um cnpj valido.
	 * 
	 * @param cpf
	 * @return {@link Boolean} <code>true</code> se o cnpj for valido, <code>false</code> caso contrario.
	 */
	public static Boolean validarCNPJ(String cnpj) {
		if (cnpj.length() != 18)
			return false;
		cnpj = cnpj.replace(".", "");
		cnpj = cnpj.replace("-", "");
		cnpj = cnpj.replace("/", "");

		int soma = 0, dig;
		String cnpjCalc = cnpj.substring(0, 12);

		char[] chrCnpj = cnpj.toCharArray();

		/* Primeira parte */
		for (int i = 0; i < 4; i++)
			if (chrCnpj[i] - 48 >= 0 && chrCnpj[i] - 48 <= 9)
				soma += (chrCnpj[i] - 48) * (6 - (i + 1));
		for (int i = 0; i < 8; i++)
			if (chrCnpj[i + 4] - 48 >= 0 && chrCnpj[i + 4] - 48 <= 9)
				soma += (chrCnpj[i + 4] - 48) * (10 - (i + 1));
		dig = 11 - (soma % 11);

		cnpjCalc += (dig == 10 || dig == 11) ? "0" : Integer.toString(dig);

		/* Segunda parte */
		soma = 0;
		for (int i = 0; i < 5; i++)
			if (chrCnpj[i] - 48 >= 0 && chrCnpj[i] - 48 <= 9)
				soma += (chrCnpj[i] - 48) * (7 - (i + 1));
		for (int i = 0; i < 8; i++)
			if (chrCnpj[i + 5] - 48 >= 0 && chrCnpj[i + 5] - 48 <= 9)
				soma += (chrCnpj[i + 5] - 48) * (10 - (i + 1));
		dig = 11 - (soma % 11);
		cnpjCalc += (dig == 10 || dig == 11) ? "0" : Integer.toString(dig);

		return cnpj.equals(cnpjCalc);
	}

	/**
	 * MÃ©todo que recebe uma string com o cpf (com '.' e '-' ou nÃ£o) e verifica se o nÃºmero Ã© um cpf vÃ¡lido.
	 * 
	 * @param cpf
	 * @return {@link Boolean} <code>true</code> se o cpf for vÃ¡lido, <code>false</code> caso contrÃ¡rio.
	 */
	public static Boolean validarCPF(String cpf) {
		cpf = cpf.replace(".", "");
		cpf = cpf.replace("-", "");

		int d1, d2;
		int digito1, digito2, resto;
		int digitoCPF;
		String nDigResult;

		// inicializando as variÃ¡veis
		d1 = 0;
		d2 = 0;
		digito1 = 0;
		digito2 = 0;
		resto = 0;

		if (cpf.length() < 11) {
			return false;
		}

		for (int nCount = 1; nCount < cpf.length() - 1; nCount++) {
			digitoCPF = Integer.valueOf(cpf.substring(nCount - 1, nCount)).intValue();

			// multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4 e assim por diante.
			d1 = d1 + (11 - nCount) * digitoCPF;

			// para o segundo digito repita o procedimento incluindo o primeiro digito calculado no passo anterior.
			d2 = d2 + (12 - nCount) * digitoCPF;
		}
		;

		// Primeiro resto da divisÃ£o por 11.
		resto = (d1 % 11);

		// Se o resultado for 0 ou 1 o digito Ã© 0 caso contrÃ¡rio o digito Ã© 11 menos o resultado anterior.
		if (resto < 2)
			digito1 = 0;
		else
			digito1 = 11 - resto;

		d2 += 2 * digito1;

		// Segundo resto da divisÃ£o por 11.
		resto = (d2 % 11);

		// Se o resultado for 0 ou 1 o digito Ã© 0 caso contrÃ¡rio o digito Ã© 11 menos o resultado anterior.
		if (resto < 2)
			digito2 = 0;
		else
			digito2 = 11 - resto;

		// Digito verificador do CPF que estÃ¡ sendo validado.
		String nDigVerific = cpf.substring(cpf.length() - 2, cpf.length());

		// Concatenando o primeiro resto com o segundo.
		nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

		// comparar o digito verificador do cpf com o primeiro resto + o segundo resto.
		return nDigVerific.equals(nDigResult);

	}

	public static String removeAcentos(String passa) {
		passa = passa.replaceAll("[Ã‚Ã€Ã�Ã„Ãƒ]", "A");
		passa = passa.replaceAll("[Ã¢Ã£Ã Ã¡Ã¤]", "a");
		passa = passa.replaceAll("[ÃŠÃˆÃ‰Ã‹]", "E");
		passa = passa.replaceAll("[ÃªÃ¨Ã©Ã«]", "e");
		passa = passa.replaceAll("[ÃŽÃ�ÃŒÃ�]", "I");
		passa = passa.replaceAll("[Ã®Ã­Ã¬Ã¯]", "i");
		passa = passa.replaceAll("[Ã”Ã•Ã’Ã“Ã–]", "O");
		passa = passa.replaceAll("[Ã´ÃµÃ²Ã³Ã¶]", "o");
		passa = passa.replaceAll("[Ã›Ã™ÃšÃœ]", "U");
		passa = passa.replaceAll("[Ã»ÃºÃ¹Ã¼]", "u");
		passa = passa.replaceAll("Ã‡", "C");
		passa = passa.replaceAll("Ã§", "c");
		passa = passa.replaceAll("[Ã½Ã¿]", "y");
		passa = passa.replaceAll("Ã�", "Y");
		passa = passa.replaceAll("Ã±", "n");
		passa = passa.replaceAll("Ã‘", "N");
		passa = passa.replaceAll("['<>\\|/]", "");
		return passa;
	}

	public static String format(String pattern, Object value) {
		MaskFormatter mask;
		try {
			mask = new MaskFormatter(pattern);
			mask.setValueContainsLiteralCharacters(false);
			return mask.valueToString(value);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

}
