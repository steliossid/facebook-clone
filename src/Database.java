import java.sql.*;
import java.util.Random;

public class Database {
	
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/";

	static final String USER = "root";
	static final String PASS = "toor";
	
	public static String DatabaseURL(String dbName) {
		return DB_URL + dbName;
	}
	
	public static void connect() {
		Statement stmt = null;
		Connection conn = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to a selected database...");
		    conn = myConnection();
		    System.out.println("Connected database successfully...");
			stmt = conn.createStatement();
			String sql = "DELETE FROM `user` ";
			stmt.executeUpdate(sql);
			String sql1 = "DELETE FROM `group` ";
			stmt.executeUpdate(sql1);

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

	public static void ExecuteSQL(String sql) {
		Statement stmt = null;
		Connection conn = myConnection();
		try {
			stmt = conn.createStatement();
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
	public static int getRandomNo(int limit) {
		Random randomno = new Random();
		return randomno.nextInt(limit);
	}
}
