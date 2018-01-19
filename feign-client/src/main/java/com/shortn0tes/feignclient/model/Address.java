package com.shortn0tes.feignexample.model;

import java.util.List;
import lombok.Data;

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
}
