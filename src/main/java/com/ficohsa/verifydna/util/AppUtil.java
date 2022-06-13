package com.ficohsa.verifydna.util;

import com.ficohsa.verifydna.exceptions.AppServiceException;

public class AppUtil {
	private AppUtil() {

	}

	public static boolean validateCharacter(String[] dna) {
		boolean res = true;
		int i = 0;
		while (i < dna.length && res) {
			if (!(dna[i].matches("[ACTG]*"))) {
				res = false;
			}
			i++;
		}

		if (!res) {
			throw new AppServiceException("Only letters A,T,C,G are allowed");
		}
		res = true;
		return res;
	}

	public static String conversionSave(String[] stringArray) {
		StringBuilder builder = new StringBuilder();
		builder.append(stringArray[0]);
		for (int i = 1; i < stringArray.length; i++) {
			builder.append(", ").append(stringArray[i]);
		}
		return builder.toString();
	}
}
