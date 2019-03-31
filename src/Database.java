import java.sql.*;
import java.util.UUID;

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
			String sql = "DELETE FROM user_post ";
			stmt.executeUpdate(sql);
			String sql1 = "DELETE FROM group_post ";
			stmt.executeUpdate(sql1);
			String sql2 = "DELETE FROM friends ";
			stmt.executeUpdate(sql2);
			String sql3 = "DELETE FROM members ";
			stmt.executeUpdate(sql3);
			String sql4 = "DELETE FROM `group` ";
			stmt.executeUpdate(sql4);
			String sql5 = "DELETE FROM user ";
			stmt.executeUpdate(sql5);
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

	public static void ExecuteUpdate(String sql) {
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

	public static void ExecuteQuery(String sql) {
		Statement stmt = null;
		Connection conn = myConnection();
		try {
			stmt = conn.createStatement();
			stmt.executeQuery(sql);
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

	public static void Execute(String sql) {
		Statement stmt = null;
		Connection conn = myConnection();
		try {
			stmt = conn.createStatement();
			stmt.execute(sql);
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
	public static String assignUID(){
		return UUID.randomUUID().toString();
	}
}
