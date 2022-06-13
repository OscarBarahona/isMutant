package com.ficohsa.verifydna.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ficohsa.verifydna.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Serializable> {

	@Query(nativeQuery = true, value = "SELECT P.ID,P.IS_MUTANT, P.DNA FROM PERSON  P WHERE P.DNA=:dna")
	public Person validateDNA(@Param("dna") String dna);

	@Query(nativeQuery = true, value = "SELECT COALESCE(COUNT(IS_MUTANT),0) FROM PERSON WHERE IS_MUTANT=TRUE")
	public int count_mutant_dna();

	@Query(nativeQuery = true, value = "SELECT COALESCE(COUNT(IS_MUTANT),0) FROM PERSON WHERE IS_MUTANT=FALSE")
	public int count_human_dna();
	
	

}
