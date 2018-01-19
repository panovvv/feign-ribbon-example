package com.shortn0tes.userservice.model;

import lombok.Data;
import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;

/**
 * Created on 1/15/2018.
 */
@Data
public class Company {

	String name;
	String catchphrase;
	String bs;

	public Company randomize() {
		RandomStringGenerator randomStringGenerator = new RandomStringGenerator.Builder()
			.withinRange('0', 'z')
			.filteredBy(CharacterPredicates.LETTERS, CharacterPredicates.DIGITS)
			.build();

		name = randomStringGenerator.generate(12);
		catchphrase = randomStringGenerator.generate(12);
		bs = randomStringGenerator.generate(12);
		return this;
	}
}
