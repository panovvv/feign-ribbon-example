package com.shortn0tes.userservice.model;

import java.util.Random;
import lombok.Data;
import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;

/**
 * Created on 1/15/2018.
 */
@Data
public class Address {

	String street;
	String suite;
	String city;
	String zipcode;
	Geo geo;

	public Address randomize() {
		RandomStringGenerator randomStringGenerator = new RandomStringGenerator.Builder()
			.withinRange('0', 'z')
			.filteredBy(CharacterPredicates.LETTERS, CharacterPredicates.DIGITS)
			.build();
		Random random = new Random();

		street = randomStringGenerator.generate(12);
		suite = Integer.toString(random.nextInt());
		city = randomStringGenerator.generate(12);
		zipcode = Integer.toString(random.nextInt());
		setGeo(new Geo().randomize());
		return this;
	}
}
