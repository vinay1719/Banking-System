import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
public class BankingApp {
	
	private static final String url = "jdbc:mysql://localhost:3306/banking_system";
	
	private static final String username = "root";
	
	private static final String password = "01070107@Va";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		try {
//			Class.forName(className:"com.mysql.cj.jdbc.Driver");
//		}catch (ClassNotFoundException e) {
//			System.out.println(e.getMessage());
//		}
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection");
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		

	}

}
