package com.ficohsa.verifydna.dto;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DNATest {
	private DNA dna;

	@BeforeEach
	void setUp() throws Exception {
		dna = new DNA();
	}

	@Test
	void getter_setter() {
		String[] comodin = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		dna.setAdn(comodin);
		dna.getAdn();
		Assertions.assertNotNull(dna.toString());
	}

}
