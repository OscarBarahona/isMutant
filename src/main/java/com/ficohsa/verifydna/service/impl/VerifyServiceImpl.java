package com.ficohsa.verifydna.service.impl;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ficohsa.verifydna.dto.Stats;
import com.ficohsa.verifydna.entity.Person;
import com.ficohsa.verifydna.exceptions.AppServiceException;
import com.ficohsa.verifydna.repository.PersonRepository;
import com.ficohsa.verifydna.service.IVerifyService;
import com.ficohsa.verifydna.util.AppUtil;

@Service
public class VerifyServiceImpl implements IVerifyService {
	final Logger log = LoggerFactory.getLogger(VerifyServiceImpl.class);

	@Autowired
	PersonRepository repository;

	@Transactional
	@Override
	public boolean isMutant(String[] dna) {
		if (dna == null) {
			throw new AppServiceException("DNA is null");
		}
		if (dna.length != 6) {
			throw new AppServiceException("the number of characters must not be less than or greater than 6 digits");
		}
		AppUtil.validateCharacter(dna);

		int totalDna = 0;
		boolean respuesta = false;

		// Recorre el arreglo principal
		for (int i = 0; i < dna.length; i++) {
			// j determina la posicion dentro del string
			for (int j = 0; j < dna[i].length(); j++) {
				// Control Horizontal
				if (j < dna[i].length() - 3) {
					if (isEqual(dna[i].charAt(j), dna[i].charAt(j + 1), dna[i].charAt(j + 2), dna[i].charAt(j + 3))) {
						totalDna++;
					}
				}
				// Control Vertical
				if (i < dna.length - 3) {
					// vertical check
					if (isEqual(dna[i].charAt(j), dna[i + 1].charAt(j), dna[i + 2].charAt(j), dna[i + 3].charAt(j))) {
						totalDna++;
					}
				}

				// Control Oblicuo
				if (i < dna.length - 3 && j < dna[i].length() - 3) {
					if (isEqual(dna[i].charAt(j), dna[i + 1].charAt(j + 1), dna[i + 2].charAt(j + 2),
							dna[i + 3].charAt(j + 3))) {
						totalDna++;
					}
				}

				// Control Oblicuo Invertido
				if (i >= 3 && j < dna[i].length() - 3) {
					if (isEqual(dna[i].charAt(j), dna[i - 1].charAt(j + 1), dna[i - 2].charAt(j + 2),
							dna[i - 3].charAt(j + 3))) {
						totalDna++;
					}
				}

				if (totalDna > 1) {
					respuesta = true;

				}
			}

		}

		return respuesta;
	}

	@Override
	public boolean isEqual(char a, char b, char c, char d) {
		return a == b && b == c && c == d;
	}

	@Override
	public Stats stats() {
		Stats states = new Stats(repository.count_human_dna(), repository.count_mutant_dna());
		log.info("States {}", states);
		return states;

	}

	@Override
	public Person findByDNA(String dna) {
		return repository.validateDNA(dna);
	}

	@Override
	public Person save(String dna, boolean type) {
		Person ps = new Person();
		ps.setMutant(type);
		ps.setDna(dna);
		return repository.save(ps);
	}

}
