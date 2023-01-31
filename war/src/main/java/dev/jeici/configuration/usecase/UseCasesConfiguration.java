package dev.jeici.configuration.usecase;

import dev.jeici.usecase.CreateTaskUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public
class UseCasesConfiguration
{
	@Bean
	CreateTaskUseCase createTaskUseCase()
	{
		return new CreateTaskUseCase();
	}
}
