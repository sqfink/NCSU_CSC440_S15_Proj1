import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dbms.DatabaseManager;

public class main {

	public main() {};
	
	public static void main(String[] args) {
		try {
			DatabaseManager.Initialize("jdbc:mysql://127.0.0.1/testdb", "testusr", "asdf");
			List<TestBean> r = DatabaseManager.executeBeanQuery("SELECT * FROM `Test`;", TestBean.class);
			for (TestBean tb : r) {
				System.out.println("TestBean (" + tb.Id + ", " + tb.firstName + ", " + tb.rate + ")");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			TestDialog t = new TestDialog();
			t.doCLIPrompt();
			TestSelection s = new TestSelection();
			s.doCLIPrompt();
		} catch (IllegalAccessException | IOException e1 ) {
			e1.printStackTrace();
		}
	}

}
