package dev.jeici.presentation.state;

import dev.jeici.presentation.enumeration.FxmlViewEnum;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@RequiredArgsConstructor
@Slf4j
public
class StageManager
{

	private       Stage            primaryStage;
	private final SpringFXMLLoader springFXMLLoader;
	private       double           xOffset = 0;
	private       double           yOffset = 0;

	public
	StageManager(SpringFXMLLoader springFXMLLoader, Stage stage)
	{
		this.springFXMLLoader = springFXMLLoader;
		this.primaryStage = stage;
	}

	public
	void switchScene(final FxmlViewEnum view)
	{
		Parent viewRootNodeHierarchy = loadViewNodeHierarchy(view.getFxmlFile());
		enableDruggable(viewRootNodeHierarchy);
		show(viewRootNodeHierarchy, view.getTitle());
	}

	private
	void enableDruggable(Parent root)
	{
		root.setOnMousePressed(event -> {
			xOffset = event.getSceneX();
			yOffset = event.getSceneY();
		});

		//move around here
		root.setOnMouseDragged(event -> {
			primaryStage.setX(event.getScreenX() - xOffset);
			primaryStage.setY(event.getScreenY() - yOffset);
		});

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);

		primaryStage.show();
	}

	private
	void show(final Parent rootnode, String title)
	{
		Scene scene = prepareScene(rootnode);

		primaryStage.setTitle(title);
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.centerOnScreen();

		try
		{
			primaryStage.show();
		}
		catch (Exception exception)
		{
			logAndExit("Unable to show scene for title" + title, exception);
		}
	}

	private
	Scene prepareScene(Parent rootnode)
	{
		Scene scene = primaryStage.getScene();

		if (scene == null)
		{
			scene = new Scene(rootnode);
		}
		scene.setRoot(rootnode);
		return scene;
	}

	/**
	 * Loads the object hierarchy from a FXML document and returns to root node
	 * of that hierarchy.
	 *
	 * @return Parent root node of the FXML document hierarchy
	 */
	private
	Parent loadViewNodeHierarchy(String fxmlFilePath)
	{
		Parent rootNode = null;
		try
		{
			rootNode = springFXMLLoader.load(fxmlFilePath);
			Objects.requireNonNull(rootNode, "A Root FXML node must not be null");
		}
		catch (Exception exception)
		{
			logAndExit("Unable to load FXML view" + fxmlFilePath, exception);
		}
		return rootNode;
	}

	private
	void logAndExit(String errorMsg, Exception exception)
	{
		log.error(errorMsg, exception, exception.getCause());
		Platform.exit();
	}
}
