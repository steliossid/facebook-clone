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
		    conn = DriverManager.getConnection(DatabaseURL("facebook-clone-db"), USER, PASS);
		    System.out.println("Connected database successfully...");
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
	
	public static void insert() {
		
	}
	
}
