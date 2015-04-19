package statemachine.states;

import java.io.IOException;
import java.sql.SQLException;

import daos.Dao;
import dbms.beans.NextOfKinBean;
import dbms.beans.StudentBean;
import dialogs.impl.CreatUserTypeSelectDialog;
import dialogs.impl.CreateStudentDialog;
import dialogs.impl.LoginPrompt;
import statemachine.Runner;
import statemachine.State;

public class CreateState extends State {

	@Override
	public String doState(Runner r) {
		CreatUserTypeSelectDialog d = new CreatUserTypeSelectDialog();
		try {
			int result = d.doCLIPrompt();
			switch(result) {
			case 1:
				CreateStudentDialog s = new CreateStudentDialog();
				s.doCLIPrompt();
				s.password = LoginPrompt.hashString(s.password);
				Long newUid = Dao.newUser(s.password);
				
				Long cnumber = null;
				try {
					cnumber = Dao.courseNo(s.course);
				} catch (SQLException e1) {
					System.out.println("Error getting course number");
					e1.printStackTrace();
					return null;
				}
				
				StudentBean sb = new StudentBean();
				sb.address = s.address;
				sb.alternatephone = s.altphone;
				sb.city = s.city;
				sb.comments = s.comments;
				sb.country = s.country;
				sb.dob = s.dob.toString();
				sb.firstname = s.firstName;
				sb.guest = (s.year > 5);
				sb.id = newUid;
				sb.lastname = s.lastName;
				sb.nationality = s.nationality;
				sb.password = s.password;
				sb.phone = s.phone;
				sb.sex = s.sex;
				sb.smoker = s.smoker;
				sb.snumber = newUid;
				sb.specialneeds = s.specialNeeds;
				sb.state = s.state;
				sb.year = s.year;
				sb.zip = s.zip;
				sb.course = cnumber;
				
				Dao.newStudent(newUid, sb);
				
				NextOfKinBean nb = new NextOfKinBean();
				nb.address = s.nokaddress;
				nb.city = s.nokcity;
				nb.country = s.nokcountry;
				nb.firstname = s.nokfirstName;
				nb.lastname = s.noklastName;
				nb.phone = s.nokphone;
				nb.relationship = s.nokRelationship;
				nb.snumber = newUid;
				nb.state = s.nokstate;
				nb.zip = s.nokzip;
				
				try {
					Dao.createNextOfKin(nb);
				} catch (SQLException e) {
					System.out.println("Failed to create next of kin. Check error log for detail");
					e.printStackTrace();
				}
				System.out.println("User ID " + newUid + " created");
				break;
			case 2:
				break;
			case 3:
				//do nothing
				break;
			default:
				throw new IOException("Invalid selection option");
			}
		} catch (IllegalAccessException | IOException e) {
			System.out.println("Failed to select an applicible option");
			e.printStackTrace();
		}
		return StartState.class.getName();
	}

}
