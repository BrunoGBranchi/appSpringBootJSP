package br.com.branchi.teste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "br.com.branchi.teste")
public class TesteApplication extends SpringBootServletInitializer {

	   @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	        return builder.sources(TesteApplication.class);
	    }
	
	public static void main(String[] args) {
		SpringApplication.run(TesteApplication.class, args);
	}

}
