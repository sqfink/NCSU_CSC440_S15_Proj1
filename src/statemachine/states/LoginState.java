package statemachine.states;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dbms.DatabaseManager;
import dbms.beans.LoginTestBean;
import dialogs.impl.LoginPrompt;
import dialogs.impl.LoginTypeDialog;
import statemachine.Runner;
import statemachine.State;
import statemachine.states.staff.StaffMainState;
import statemachine.states.student.StudentHomepageState;

public class LoginState extends State {

	@Override
	public String doState(Runner r) {
		LoginTypeDialog d = new LoginTypeDialog();
		int userType = -1;
		try {
			userType = d.doCLIPrompt();
		} catch (IllegalAccessException | IOException e1) {
			System.out.println("Invalid selection");
			e1.printStackTrace();
		}
		if (userType == 4) {
			return StartState.class.getName();
		}
		
		LoginPrompt prompt = new LoginPrompt();
		try {
			prompt.doCLIPrompt();
		} catch (IllegalAccessException | IOException e) {
			System.out.println("Illegal input");
			e.printStackTrace();
		}
		String pwHash = prompt.hashString(prompt.password);
		List<LoginTestBean> res = null;
		try {
			res = DatabaseManager.executeBeanQuery(
					"SELECT * FROM `users` WHERE `Username`=\"" + prompt.username + "\" AND `Password`=\"" + pwHash + "\" AND `UserType`=\"" + userType + "\";",
					LoginTestBean.class
			);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (res.size() > 0) {
			System.out.println("Login accepted.");
			r.setKV("Username", prompt.username);
			r.setKV("UserID", res.get(0).ID);
			r.setKV("UserType", res.get(0).UserType);
			switch (res.get(0).UserType) {
			case 1:
				return StudentHomepageState.class.getName();
			case 2:
				return StaffMainState.class.getName();
			case 3:
				return StudentHomepageState.class.getName(); //TODO: are any real changes needed here?
			default:
				System.err.println("Invalid user type " + res.get(0).UserType + " loaded");
				return null;
			}
		} else {
			System.out.println("Login request failed. Invalid username/password");
			return this.getClass().getName();
		}
	}
	
}
