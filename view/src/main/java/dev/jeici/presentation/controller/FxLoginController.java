package dev.jeici.presentation.controller;

import dev.jeici.presentation.enumeration.FxmlViewEnum;
import dev.jeici.presentation.state.StageManager;
import dev.jeici.service.UserService;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Slf4j
@Controller
public
class FxLoginController
	implements Initializable
{
	@SuppressWarnings("unused")
	@FXML
	public Button btnLogin;

	@SuppressWarnings("unused")
	@FXML
	public Button btnExitLogin;

	@FXML
	private PasswordField password;

	@FXML
	private TextField username;

	@FXML
	private Label lblLogin;

	@Autowired
	private UserService  userService;
	@Autowired
	@Lazy
	private StageManager stageManager;

	@SuppressWarnings("unused")
	@FXML
	private
	void exitLogin(ActionEvent actionEvent)
	{
		log.info("exit program...");
		Platform.exit();
	}

	@SuppressWarnings("unused")
	@FXML
	private
	void login(ActionEvent event)
	{
		if (userService.authenticate(getUsername(), getPassword()))
		{
			stageManager.switchScene(FxmlViewEnum.USER);
		}
		else
		{
			lblLogin.setText("Login Failed.");
		}
	}

	public
	String getPassword()
	{
		return password.getText();
	}

	public
	String getUsername()
	{
		return username.getText();
	}

	@Override
	public
	void initialize(URL location, ResourceBundle resources)
	{

	}
}

