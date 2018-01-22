package com.shortn0tes.feignclient.model;

import java.util.Random;
import lombok.Data;
import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;

/**
 * Created on 1/15/2018.
 */
@Data
public class User {

	Long id;
	String name;
	String username;
	String email;
	Address address;
	String phone;
	String website;
	Company company;

	public User randomize() {
		RandomStringGenerator randomStringGenerator = new RandomStringGenerator.Builder()
			.withinRange('0', 'z')
			.filteredBy(CharacterPredicates.LETTERS, CharacterPredicates.DIGITS)
			.build();
		Random random = new Random();

		if (id == null) {
			id = random.nextLong();
		}
		name = randomStringGenerator.generate(12);
		username = randomStringGenerator.generate(12);
		email = randomStringGenerator.generate(12);
		setAddress(new Address().randomize());
		phone = Integer.toString(random.nextInt());
		website = randomStringGenerator.generate(12);
		setCompany(new Company().randomize());
		return this;
	}
}
