package com.ficohsa.verifydna.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonIgnoreProperties
@ToString
@Getter
@Setter
public class DNA {
	@JsonProperty("dna")
	private String[] adn ;

}
