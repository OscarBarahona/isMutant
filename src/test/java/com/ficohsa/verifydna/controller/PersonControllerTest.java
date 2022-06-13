package com.ficohsa.verifydna.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.ficohsa.verifydna.dto.DNA;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.net.URI;
import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonControllerTest {
	@LocalServerPort
	int randomServerPort;

	private DNA reqBody;

	private RestTemplate restTemplate;

	@BeforeEach
	protected void setUp() throws Exception {
		restTemplate = new RestTemplate();

	}

	@Test
	void testGetEmployeeListSuccess() throws URISyntaxException {
		final String baseUrl = "http://localhost:" + randomServerPort + "/mutant/stats";
		URI uri = new URI(baseUrl);
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	@Test
	void test_200() throws URISyntaxException {
		String[] comodin = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "AAAATA", "TCACTG" };
		reqBody = new DNA();
		reqBody.setAdn(comodin);
		final String baseUrl = "http://localhost:" + randomServerPort + "/mutant/";
		URI uri = new URI(baseUrl);
		HttpEntity<?> request = new HttpEntity<>(reqBody);
		ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
		assertEquals(result.getStatusCodeValue(), 200);
	}

}
