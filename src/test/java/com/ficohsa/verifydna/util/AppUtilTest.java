package com.ficohsa.verifydna.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ficohsa.verifydna.exceptions.AppServiceException;

 class AppUtilTest {

	@BeforeEach
	protected void setUp() throws Exception {

	}

	@Test
	void validateCharacter_false() {
		String[] comodin = { "ATGCGAW", "CAGTWGC", "TTAWTGT", "AWGAAGG", "WCCCCTA", "TCACTWG" };
		assertThatThrownBy(() -> AppUtil.validateCharacter(comodin)).isInstanceOf(AppServiceException.class);
	}
}
