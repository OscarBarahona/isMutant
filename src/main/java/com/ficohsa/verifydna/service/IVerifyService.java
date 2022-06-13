package com.ficohsa.verifydna.service;

import com.ficohsa.verifydna.dto.Stats;
import com.ficohsa.verifydna.entity.Person;

public interface IVerifyService {
	boolean isMutant(String[] dna);

	boolean isEqual(char a, char b, char c, char d);
	Stats stats();
	Person findByDNA(String dna);
	Person save(String dna, boolean type);
}
