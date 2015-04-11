import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;

import dbms.DatabaseManager;

public class RebuildDatabase {

	public RebuildDatabase() {};
	
	public static void main(String[] args) {
		try {
			Properties p = new Properties();
			p.load(new FileInputStream(new File("auth.conf")));
			String db = p.getProperty("DB_Name");
			String srv = p.getProperty("Server");
			String usr = p.getProperty("User");
			String pw = p.getProperty("Password");
			DatabaseManager.Initialize("jdbc:mysql://" + srv + "/" + db, usr, pw);
			//DatabaseManager.setLogFile(new File("C:/tmp/db.log"));
			List<String> cmds = getSqlCmds("sql/dropTables.sql");
			cmds.addAll(getSqlCmds("sql/createTables.sql"));
			cmds.addAll(getSqlCmds("sql/initData.sql"));
			System.out.println("Loaded " + cmds.size() + " commands from files");
			for (String cmd : cmds) {
				try {
					DatabaseManager.getConnection().createStatement().execute(cmd);
					Thread.sleep(25);
				} catch (CommunicationsException ex) {
					System.out.println("Server connection failure!");
					ex.printStackTrace();
					System.exit(-1);
				}
				 catch (SQLException ex) {
					System.out.println("Failed to execute: " + cmd);
					ex.printStackTrace();
				 }
			}
			System.out.println("Database rebuild completed.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<String> getSqlCmds (String path) throws IOException {
		File f = new File(path);
		assert(f.canRead());
		FileInputStream is = new FileInputStream(f);
		List <String> tmp = new LinkedList<String>();
		do {
			StringBuilder cmd = new StringBuilder();
			boolean leadingSpaces = true;
			do {
				int in = is.read();
				if (in < 0) {
					break;
				}
				char c = (char) in;
				if (leadingSpaces) {
					switch(c) {
					case ' ':
					case '\n':
					case '\r':
					case '\t':
						continue;
					default:
						leadingSpaces = false;
					}
				}
				cmd.append(c);
				if (c == ';') {
					break;
				}
			} while (true);
			if (cmd.length() == 0) {
				break;
			}
			tmp.add(cmd.toString());
		} while (true);
		is.close();
		return tmp;
	}

}
