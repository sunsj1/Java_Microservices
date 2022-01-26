package com.practice.webaervice.restful_web_services.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;
	@GetMapping(path="/hello_world")
	public String HelloWorld() {
		return "Hello World";
		
	}
	
	@GetMapping(path="/helloworldbean")
	public HelloWorldBean hellloWorldBean() {
		
		return new HelloWorldBean("Hello World");
		
	}
	
	
	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorldBean hellloWorldBean(@PathVariable String name) {
		
		return new HelloWorldBean(String.format("Hello World,%s",name));
		
	}
	
	@GetMapping(path="/hello_world-internationalized")
	public String HelloWorldInternationalized(
			//@RequestHeader(name="Accept-Language",required=false) Locale locale
			) {
		return  messageSource.getMessage("good.morning.message",null,"Default Message",
				//locale);
				LocaleContextHolder.getLocale());
		
	}
}
