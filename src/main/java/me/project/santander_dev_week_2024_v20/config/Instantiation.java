package me.project.santander_dev_week_2024_v20.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class Instantiation implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		
	}

}
