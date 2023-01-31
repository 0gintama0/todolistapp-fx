package dev.jeici.port;

import dev.jeici.domain.SimpleTask;

public
interface TaskOperationsPort
{
	void saveTask(SimpleTask simpleTask);
}
