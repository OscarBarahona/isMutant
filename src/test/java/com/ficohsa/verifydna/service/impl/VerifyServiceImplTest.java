package com.ficohsa.verifydna.service.impl;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyBoolean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ficohsa.verifydna.dto.DNA;
import com.ficohsa.verifydna.dto.Stats;
import com.ficohsa.verifydna.entity.Person;
import com.ficohsa.verifydna.exceptions.AppServiceException;
import com.ficohsa.verifydna.repository.PersonRepository;
import com.ficohsa.verifydna.util.AppUtil;

class VerifyServiceImplTest {
	@InjectMocks
	private VerifyServiceImpl service;

	@Mock
	Stats s;
	@Mock
	PersonRepository repository;

	private Person p;
	private DNA dna;

	@BeforeEach
	protected void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		String[] comodin = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		p = new Person();
		p.setDna(AppUtil.conversionSave(comodin));
		p.setMutant(true);
		dna = new DNA();
		dna.setAdn(comodin);
		s = new Stats();

	}

	@Test
	void PersonComplements() {
		p.setIdPerson((long) 1);
		p.getDna();
		p.getIdPerson();
		p.isMutant();
		assertNotNull(p.toString());
	}

	@Test
	void testMutant_True() {
		String[] comodin = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		Assertions.assertTrue(service.isMutant(comodin));
	}

	@Test
	void testMutant_dna_null() {
		String[] comodin = null;
		assertThatThrownBy(() -> service.isMutant(comodin)).isInstanceOf(AppServiceException.class);
	}

	@Test
	void testMutant_dna_mayor_Size() {
		String[] comodin = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG", "ATGCGA" };
		assertThatThrownBy(() -> service.isMutant(comodin)).isInstanceOf(AppServiceException.class);
	}

	@Test
	void Stats_NotNull() {
		Assertions.assertNotNull(service.stats());
	}

	@Test
	void findByDNA_Null() {
		String[] comodin = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		Assertions.assertNull(service.findByDNA(AppUtil.conversionSave(comodin)));
	}

	@Test
	void savenNotNull() {
		String[] comodin = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		when(service.save(AppUtil.conversionSave(comodin), anyBoolean())).thenReturn(new Person());
	}
}