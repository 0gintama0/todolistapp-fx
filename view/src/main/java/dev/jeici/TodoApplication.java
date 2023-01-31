package dev.jeici;

import dev.jeici.presentation.enumeration.FxmlViewEnum;
import dev.jeici.presentation.state.StageManager;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public
class TodoApplication
	extends Application
{

	protected ConfigurableApplicationContext springContext;
	protected StageManager                   stageManager;

	public static
	void main(final String[] args)
	{
		Application.launch(args);
	}

	@Override
	public
	void init()
	{
		springContext = springBootApplicationContext();
	}

	@Override
	public
	void start(Stage stage)
	{
		stageManager = springContext.getBean(StageManager.class, stage);
		stage.initStyle(StageStyle.UNDECORATED);
		displayInitialScene();
	}

	@Override
	public
	void stop()
	{
		springContext.close();
	}

	/**
	 * Useful to override this method by sub-classes wishing to change the first
	 * Scene to be displayed on startup. Example: Functional tests on main
	 * window.
	 */
	protected
	void displayInitialScene()
	{

		stageManager.switchScene(FxmlViewEnum.LOGIN);
	}

	private
	ConfigurableApplicationContext springBootApplicationContext()
	{
		SpringApplicationBuilder builder = new SpringApplicationBuilder(TodoApplication.class);
		String[] args = getParameters().getRaw().toArray(new String[0]);
		return builder.run(args);
	}
}

