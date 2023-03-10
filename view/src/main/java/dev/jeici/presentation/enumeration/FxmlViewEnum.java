package dev.jeici.presentation.enumeration;

import java.util.ResourceBundle;

public
enum FxmlViewEnum
{
	USER
		{
			@Override
			public
			String getTitle()
			{
				return getStringFromResourceBundle("user.title");
			}

			@Override
			public
			String getFxmlFile()
			{
				return "/fxml/User.fxml";
			}
		},
	LOGIN
		{
			@Override
			public
			String getTitle()
			{
				return getStringFromResourceBundle("login.title");
			}

			@Override
			public
			String getFxmlFile()
			{
				return "/fxml/Login.fxml";
			}
		},
	LOGIN_CUSTOM
		{
			@Override
			public
			String getTitle()
			{
				return getStringFromResourceBundle("login.title");
			}

			@Override
			public
			String getFxmlFile()
			{
				return "/fxml/Login.fxml";
			}
		};

	public abstract
	String getTitle();
	public abstract
	String getFxmlFile();

	String getStringFromResourceBundle(String key)
	{
		return ResourceBundle.getBundle("Bundle").getString(key);
	}
}
