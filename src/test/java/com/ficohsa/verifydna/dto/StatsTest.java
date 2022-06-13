package com.ficohsa.verifydna.dto;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StatsTest {
	private Stats s;

	@BeforeEach
	void setUp() throws Exception {
		s = new Stats();
	}

	@Test
	void setter_getter() {
		s.setCount_human_dna(1);
		s.setCount_mutant_dna(1);
		s = new Stats(s.getCount_human_dna(), s.getCount_mutant_dna());
		s.setRadio();
		s.getCount_human_dna();
		s.getCount_mutant_dna();
		assertNotNull(s.getRatio());
		assertNotNull(s.toString());

	}

	@Test
	void setRatio_countMuant_0() {
		s = new Stats(1, 0);
		assertNotNull(s.toString());
	}

	@Test
	void setRatio_countHumant_0() {
		s = new Stats(0, 1);
		assertNotNull(s.toString());
	}
}
