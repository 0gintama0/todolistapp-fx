package dev.jeici.presentation.state;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.util.ResourceBundle;


public
class SpringFXMLLoader
{
	@Autowired
	protected ResourceBundle     resourceBundle;
	@Autowired
	protected ApplicationContext context;

	public
	Parent load(String fxmlPath)
	throws IOException
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setControllerFactory(context::getBean); //Spring now FXML Controller Factory
		loader.setResources(resourceBundle);
		loader.setLocation(getClass().getResource(fxmlPath));
		return loader.load();
	}
}
