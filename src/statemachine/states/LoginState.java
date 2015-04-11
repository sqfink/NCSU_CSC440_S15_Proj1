package statemachine.states;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dbms.DatabaseManager;
import dbms.beans.LoginStaffBean;
import dbms.beans.LoginStudentBean;
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

		try {
			switch (userType) {
			case 1:
			case 3:
				int isGuest;
				if (userType == 3)
					isGuest = 1;
				else
					isGuest = 0;
				
				String studentQuery = "SELECT * FROM `users` INNER JOIN `student` ON users.id=student.snumber WHERE `id`=\""
						+ prompt.username + "\" AND `password`=\"" + pwHash + "\" AND `guest`=\"" + isGuest + "\";";
				
				List<LoginStudentBean> res = DatabaseManager.executeBeanQuery(studentQuery, LoginStudentBean.class);
				
				if (res.size() != 1) {
					if (isGuest == 1)
						System.out.println("No guest with matching approval ID and password found");
					else
						System.out.println("No student with matching ID and password found");
					return this.getClass().getName();
				}
				
				r.setKV("LoggedInUser", res.get(0)); //Store the user details for this session

				return StudentHomepageState.class.getName();
			case 2:
				String staffQuery = "SELECT * FROM `users` INNER JOIN `staff` ON users.id=staff.staffnumber WHERE `id`=\""
						+ prompt.username + "\" AND `password`=\"" + pwHash + "\";";
				
				List<LoginStaffBean> res2 = DatabaseManager.executeBeanQuery(staffQuery, LoginStaffBean.class);
				
				if (res2.size() != 1) {
					System.out.println("No staff with matching staff number and password found");
					return this.getClass().getName();
				}
				
				r.setKV("LoggedInUser", res2.get(0)); //Store the user details for this session
				
				return StaffMainState.class.getName();
			default:
				System.err.println("Invalid user type reported by dialog");
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
