package com.xworkz.intelligenceBureau.configuration;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.xworkz")
public class IntelligenceBureauConfiguration {

	public IntelligenceBureauConfiguration() {
		System.out.println("IntelligenceBureauConfiguration constructor");
	}
}
