package dbms;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {	
	private Connection c = null;
	private static DatabaseManager _singleton = null;
	
	public static Connection getConnection() {
		if (_singleton == null)
			throw new IllegalAccessError("The database connection must be initialized before getting the connection");
		return _singleton.c;
	}
	
	private DatabaseManager(String dbPath, String user, String password) throws SQLException {
		try {
			c = java.sql.DriverManager.getConnection(dbPath, user, password);
		} catch (SQLException e) {
			_singleton = null;
			System.err.println("Failed to get connection to database");
			throw e;
		}
		_singleton = this;
	}

	private DatabaseManager(String dbPath) {
		try {
			c = java.sql.DriverManager.getConnection(dbPath);
		} catch (SQLException e) {
			_singleton = null;
			System.err.println("Failed to get connection to database");
			e.printStackTrace();
		}
		_singleton = this;
	}
	
	public static boolean Initialize(String dbPath) {
		if (_singleton != null) {
			System.err.println("WARNING: overwriting currently loaded database connection");
		}
		_singleton = null;
		_singleton = new DatabaseManager(dbPath);
		if (_singleton == null) {
			return false;
		}
		System.out.println("Database connection established");
		return true;
	}
	
	public static boolean Initialize(String dbPath, String user, String password) throws SQLException {
		if (_singleton != null) {
			System.err.println("WARNING: overwriting currently loaded database connection");
		}
		_singleton = null;
		_singleton = new DatabaseManager(dbPath, user, password);
		if (_singleton == null) {
			return false;
		}
		System.out.println("Database connection established");
		return true;
	}
	
	public static <T extends Bean> List<T> executeBeanQuery(String query, Class<T> bean) throws SQLException {
		ArrayList<T> l = null;
		Connection c = getConnection();
		Statement stmt = c.createStatement();
		
		if (!stmt.execute(query)) {
			System.err.println("SQL Error: No results returned by query");
			return null;
		}
		
		l = new ArrayList<T>();
		
		SQLWarning warn = stmt.getWarnings();
		if (warn != null) {
			System.err.println("Request returned warnings:");
			do {
				System.err.print("\t[" + warn.getErrorCode() + "] " + warn.getMessage());
			} while ((warn = warn.getNextWarning()) != null);
		}

		try {
			do {
				ResultSet rs = stmt.getResultSet();
				if (!rs.next()) {
					throw new SQLException("Error moving to first row of results");
				}
				do {
					T b = bean.newInstance();
					b.loadFromRS(rs);
					rs.next();
					l.add(b);
				} while(!rs.isAfterLast());
			} while (stmt.getMoreResults());
		} catch (InstantiationException e) {
			System.err.println("Unable to create new instance of " + bean.getName());
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			System.err.println("Access Errror while loading beans");
			e.printStackTrace();
		}
		
		return l;
	}
}
