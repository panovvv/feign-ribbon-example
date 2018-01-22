package com.shortn0tes.feignclient.model;

import java.util.Random;
import lombok.Data;

/**
 * Created on 1/15/2018.
 */
@Data
public class Geo {

	String lat;
	String lng;

	public Geo randomize() {
		Random random = new Random();
		lat = Double.toString(random.nextDouble());
		lng = Double.toString(random.nextDouble());
		return this;
	}
}
