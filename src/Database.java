import java.sql.*;

public class Database {
	
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/";

	static final String USER = "root";
	static final String PASS = "toor";
	
	public static String DatabaseURL(String dbName) {
		return DB_URL + dbName;
	}
	
	public static void connect() {
		
		Connection conn = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to a selected database...");
		    conn = myConnection();
		    System.out.println("Connected database successfully...");
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (conn != null)
					conn.close();
			}
			catch (SQLException se) {
				se.printStackTrace();
			}
		}	
	}
	
	public static void insertUser(int id, String name, String email) {
		Statement stmt = null;
		Connection conn = myConnection();
		try {
			stmt = conn.createStatement();
			String sql = "INSERT INTO user " +
	                "VALUES (" + id + ", '" + name + "', '" + email + "')";
			stmt.executeUpdate(sql);
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (conn != null)
					conn.close();;
			}
			catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
	
	public static void insertGroup(int id, String name, String description) {
		Statement stmt = null;
		Connection conn = myConnection();
		try {
			stmt = conn.createStatement();
			String sql = "INSERT INTO group " +
	                "VALUES (" + id + ", '" + name + "', '" + description + "')";
			stmt.executeUpdate(sql);
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (conn != null)
					conn.close();
			}
			catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
	
	public static Connection myConnection() {
		try {
			return DriverManager.getConnection(DatabaseURL("facebook-clone-db"), USER, PASS);
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		}
	}
	
}
