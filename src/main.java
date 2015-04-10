import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import statemachine.Runner;
import statemachine.states.StartState;
import dbms.DatabaseManager;

public class main {

	public main() {};
	
	public static void main(String[] args) {
		try {
			Properties p = new Properties();
			p.load(new FileInputStream(new File("auth.conf")));
			String db = p.getProperty("DB_Name");
			String srv = p.getProperty("Server");
			String usr = p.getProperty("User");
			String pw = p.getProperty("Password");
			DatabaseManager.Initialize("jdbc:mysql://" + srv + "/" + db, usr, pw);
			DatabaseManager.setLogFile(new File("C:/tmp/db.log"));
			Runner r = new Runner(StartState.class);
			r.Run();	
		} catch (IllegalAccessException e1 ) {
			e1.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
