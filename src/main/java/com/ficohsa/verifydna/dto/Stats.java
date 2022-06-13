package com.ficohsa.verifydna.dto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Stats {
	private int count_mutant_dna;
	private int count_human_dna;
	private double ratio;

	public Stats(int count_human_dna, int count_mutant_dna) {
		this.count_human_dna = count_human_dna;
		this.count_mutant_dna = count_mutant_dna;
		setRadio();
	}

	public int getCount_mutant_dna() {
		return count_mutant_dna;
	}

	public void setCount_mutant_dna(int count_mutant_dna) {
		this.count_mutant_dna = count_mutant_dna;
	}

	public int getCount_human_dna() {
		return count_human_dna;
	}

	public void setCount_human_dna(int count_human_dna) {
		this.count_human_dna = count_human_dna;
	}

	public double getRatio() {
		return ratio;
	}

	public void setRadio() {
		if (count_mutant_dna > 0 && count_human_dna > 0) {
			ratio = (float) Math.round((float) count_mutant_dna / (count_human_dna + count_mutant_dna) * 100) / 100;
		} else if (count_mutant_dna == 0) {
			ratio = 0;
		} else {
			ratio = 1;
		}
	}

}
