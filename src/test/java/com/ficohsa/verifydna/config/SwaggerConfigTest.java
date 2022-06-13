package com.ficohsa.verifydna.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SwaggerConfigTest {

	@Test
	void test() {
		SwaggerConfig c = new SwaggerConfig();
		Assertions.assertNotNull(c.apiDocket());
	}
}
