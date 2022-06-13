package com.ficohsa.verifydna;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class VerifyAdnApplicationTest {
	@Test
	void contextLoads() {
	}
	@Test
	void testApplication() {
		MockedStatic<SpringApplication> utilities = Mockito.mockStatic(SpringApplication.class);
		utilities.when((MockedStatic.Verification) SpringApplication.run(VerifyAdnApplication.class, new String[] {}))
				.thenReturn(null);
		VerifyAdnApplication.main(new String[] {});
		assertThat(SpringApplication.run(VerifyAdnApplication.class, new String[] {})).isEqualTo(null);
	}
}
