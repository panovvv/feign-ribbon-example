package com.shortn0tes.feignexample.model;

import lombok.Data;

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
}
