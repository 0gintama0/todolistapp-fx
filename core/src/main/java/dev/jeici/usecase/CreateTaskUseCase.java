package dev.jeici.usecase;

import dev.jeici.domain.SimpleTask;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public
class CreateTaskUseCase
{

	public void execute(SimpleTask simpleTask)
	{
		System.out.println("Save SimpleTask: " + simpleTask);
	}
}
