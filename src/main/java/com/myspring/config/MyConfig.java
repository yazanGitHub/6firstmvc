package com.myspring.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.myspring.formatter.PhoneFormatter;

@Configuration
@EnableWebMvc
@ComponentScan("com.myspring.controller")
public class MyConfig implements WebMvcConfigurer{
	
	// set up my view resolver
	@Bean
	public InternalResourceViewResolver myViewResolver()
	{
		InternalResourceViewResolver myViewResolver = new InternalResourceViewResolver();
		myViewResolver.setPrefix("/WEB-INF/views/");
		myViewResolver.setSuffix(".jsp");
		return myViewResolver;
	}
	
	// start code :  to get the formatter for the phone variable
	// added to get one string phone string from the user and splitting it to pass the phone object
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(new PhoneFormatter());
	}
	// end code :  to get the formatter for the phone variable

	
	// start code :  adding bean to read from message properties file
	// to load message.properties file 
	@Bean
	MessageSource messageSource()
	{
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("message");
		return messageSource;
	}
	@Bean(name="validator")
	// this is to tell spring that i have a new resource for message 
	public LocalValidatorFactoryBean validator() {
		LocalValidatorFactoryBean localCalidatorDactoryBean = new LocalValidatorFactoryBean();
		localCalidatorDactoryBean.setValidationMessageSource(messageSource());
		return localCalidatorDactoryBean;
	}
	// this method is inside ewbmvcConfiguration interface
	@Override
	public Validator getValidator() {
		// TODO Auto-generated method stub
		return  validator();
	}
	// end code :  to adding bean to read from message properties file
	

}
