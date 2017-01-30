package br.gov.ms.defensoria.comum.util;

import java.text.Normalizer;
import java.util.Collection;

import br.gov.ms.defensoria.comum.generics.IGenericEntity;

public class SimpleValidate {

	public static boolean isNullOrBlank(String str) {

		if (str != null) {
			str = str.trim();
		}

		return (str == null || "".equals(str) || "null".equals(str));
	}

	public static boolean isNullOrNoID(IGenericEntity entity) {
		return (entity == null || entity.getId() == null);
	}

	@SuppressWarnings("rawtypes")
	public static boolean isNullOrEmpty(Collection collection) {
		return (collection == null || collection.isEmpty());
	}

	public static String removerAcentos(String str) {
		return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}
}
