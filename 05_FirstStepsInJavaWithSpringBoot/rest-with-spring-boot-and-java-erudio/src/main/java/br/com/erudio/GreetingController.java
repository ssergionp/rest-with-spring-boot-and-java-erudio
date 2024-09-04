package br.com.erudio;

import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class GreetingController {
	
	private static final String template = "Hello, %s! You are %d years old!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/greeting")
	public Greeting greeting(
			@RequestParam(value = "name", defaultValue = "World") String name,
			@RequestParam(value = "idade", defaultValue = "0") int idade) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name, idade));
	}
}
