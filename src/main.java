import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import statemachine.Runner;
import statemachine.State;
import statemachine.states.LoginState;
import dbms.DatabaseManager;

public class main {

	public main() {};
	
	public static void main(String[] args) {
		try {
			DatabaseManager.Initialize("jdbc:mysql://127.0.0.1/testdb", "testusr", "asdf");
			DatabaseManager.setLogFile(new File("C:/tmp/db.log"));
			Runner r = new Runner(LoginState.class);
			r.Run();	
		} catch (IllegalAccessException e1 ) {
			e1.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
