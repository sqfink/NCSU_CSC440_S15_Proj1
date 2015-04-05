package statemachine.states;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dbms.DatabaseManager;
import dbms.beans.LoginTestBean;
import dialogs.impl.LoginPrompt;
import statemachine.Runner;
import statemachine.State;

public class LoginState extends State {

	@Override
	public String doState(Runner r) {
		LoginPrompt prompt = new LoginPrompt();
		try {
			prompt.doCLIPrompt();
		} catch (IllegalAccessException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pwHash = prompt.hashString(prompt.password);
		List<LoginTestBean> res = null;
		try {
			res = DatabaseManager.executeBeanQuery(
					"SELECT * FROM `users` WHERE `Username`=\"" + prompt.username + "\" AND `Password`=\"" + pwHash + "\";",
					LoginTestBean.class
			);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (res.size() > 0) {
			System.out.println("Login accepted.");
			r.setKV("Username", prompt.username);
			r.setKV("UserID", res.get(0).ID);
			return null;
		} else {
			System.out.println("Login request failed. Invalid username/password");
			return null;
		}
	}
	
}
