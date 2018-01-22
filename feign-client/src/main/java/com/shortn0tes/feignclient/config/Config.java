package com.shortn0tes.feignclient.config;

import com.shortn0tes.feignclient.feign.UserClient;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.ribbon.LoadBalancingTarget;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.support.SpringMvcContract;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created on 1/15/2018.
 */
@Configuration
@EnableFeignClients
@RibbonClient(name = "user-client")
public class Config {

	@Bean
	UserClient userClient() {
		return Feign.builder()
			.contract(new SpringMvcContract())
			.encoder(new JacksonEncoder())
			.decoder(new JacksonDecoder())
			.logger(new Logger.ErrorLogger())
			.logLevel(Logger.Level.FULL)
			.target(LoadBalancingTarget.create(UserClient.class, "http://user-client"));
	}
}
