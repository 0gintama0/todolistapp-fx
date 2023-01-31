package dev.jeici;

import dev.jeici.entities.User;
import dev.jeici.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public
class DataInitializer
{
	@Autowired
	private UserRepository repo;

	@Bean
	public
	CommandLineRunner getCommandLineRunner()
	{
		return args -> log.info("data user init: \nuser1: {},\nuser2: {},\nuser3: {}.",
	                        repo.save(User.builder().email("test_mail1").password("psw1").build()),
	                        repo.save(User.builder().email("test_mail2").password("psw2").build()),
	                        repo.save(User.builder().email("test_mail3").password("psw3").build()));
	}
}
