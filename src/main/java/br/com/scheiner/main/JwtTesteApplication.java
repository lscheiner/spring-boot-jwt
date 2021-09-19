package br.com.scheiner.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.scheiner"})
@EnableJpaRepositories("br.com.scheiner.repository")
@EntityScan("br.com.scheiner.entity")  
public class JwtTesteApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtTesteApplication.class);
	}

}
