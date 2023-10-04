package com.xworkz.intelligenceBureau.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ComponentScan("com.xworkz")
public class IntelligenceBureauConfiguration {

	public IntelligenceBureauConfiguration() {
		System.out.println("IntelligenceBureauConfiguration constructor");
	}
	@Bean
	public ViewResolver viewResolver() {
		System.out.println("viewResolver bean is created");
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		resolver.setSuffix(".jsp");
		resolver.setPrefix("/");
		return resolver;
	}
	@Bean
	public LocalContainerEntityManagerFactoryBean bean() {
		System.out.println("LocalContainerEntityManagerFactoryBean started");
		LocalContainerEntityManagerFactoryBean bean=new LocalContainerEntityManagerFactoryBean();
		System.out.println("bean created"+bean);
		return bean;
		
	}
}
