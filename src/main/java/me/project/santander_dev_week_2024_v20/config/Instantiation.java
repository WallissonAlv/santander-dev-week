package me.project.santander_dev_week_2024_v20.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import me.project.santander_dev_week_2024_v20.domain.models.Account;
import me.project.santander_dev_week_2024_v20.domain.models.Card;
import me.project.santander_dev_week_2024_v20.domain.models.User;
import me.project.santander_dev_week_2024_v20.domain.repositories.AccountRepository;
import me.project.santander_dev_week_2024_v20.domain.repositories.CardRepository;
import me.project.santander_dev_week_2024_v20.domain.repositories.UserRepository;

@Configuration
@Profile("test")
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private CardRepository cardRepository; 
	
	@Override
	public void run(String... args) throws Exception {
		
		Account ac1 = new Account(); 
		Account ac2 = new Account();
		
		ac1.setAgency("000001"); ac1.setNumber("0001");
		ac2.setAgency("000002"); ac2.setNumber("0002");
		
		accountRepository.saveAll(Arrays.asList(ac1,ac2));
		
		Card ca1 = new Card();
		Card ca2 = new Card();
		
		ca1.setNumber("99999");ca1.setDescription("Santander");
		ca2.setNumber("88888");ca2.setDescription("Santander");
		cardRepository.saveAll(Arrays.asList(ca1,ca2));
		
		User u1 = new User(null, "Wallisson Alves", ac1, ca1); 
		User u2 = new User(null, "Ingred Nauyra", ac2, ca2); 
		
		userRepository.saveAll(Arrays.asList(u1,u2));
	}

}
