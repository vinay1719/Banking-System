import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class User {
	
	private Connection connection;
	private Scanner scanner;
	
	public User(Connection connection, Scanner scanner) {
		this.connection = connection;
		this.scanner = scanner;
	}
	
	public void register() {
		scanner.nextLine();
		System.out.println("Full Name: ");
		String full_name = scanner.nextLine();
		System.out.println("Email: ");
		String email = scanner.nextLine();
		System.out.println("Password: ");
		String password = scanner.nextLine();
		
		if(user_exist(email)) {
			System.out.println("User already exists for the this Emai Id");
			return;
		}
		String register_query = "insert into user(full_name, email, password) values(?,?,?);";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(register_query);
			preparedStatement.setString(1, full_name);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, password);
			int affectedrows = preparedStatement.executeUpdate();
			if(affectedrows>0) {
				System.out.println("Registration Successfull!");
			}else {
				System.out.println("Registration Failed!");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public String login() {
		scanner.nextLine();
		System.out.println("Email: ");
		String email = scanner.nextLine();
		System.out.println("Password: ");
		String password = scanner.nextLine();
		String login_query = "Select * from user where email = ? and password = ?;";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(login_query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(1, password);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean user_exist(String email) {
		String query = "Select * from user where email = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,email);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return true;
			}
			else {
				return false;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
