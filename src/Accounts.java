
import java.sql.*;
import java.util.Scanner;

public class Accounts {
	
	private Connection connection;
	private Scanner scanner;
	
	public Accounts(Connection connection, Scanner scanner) {
		this.connection = connection;
		this.scanner = scanner;
	}
	
	public long open_account(String email) {
		if(!account_exist(email)) {
			String open_query = "insert into account(account_number, full_name, email, balance, security_pin) values(?,?,?,?,?);";
			System.out.println("Full Name: ");
			String full_name = scanner.nextLine();
			System.out.println("Opening Balance: ");
			double balance = scanner.nextDouble();
			System.out.println("Security Pin(4 Digits): ");
			String security_pin = scanner.nextLine();
			try {
				long account_number = generateAccountNumber();
				PreparedStatement preparedStatement = connection.prepareStatement(open_query);
				preparedStatement.setLong(1,account_number);
				preparedStatement.setString(2,full_name);
				preparedStatement.setString(3,email);
				preparedStatement.setDouble(4,balance);
				preparedStatement.setString(5,security_pin);
				
				int affectedrow = preparedStatement.executeUpdate();
				if(affectedrow>0) {
					return account_number;
				}else {
					throw new RuntimeException("Account Opening Failed");
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		throw new RuntimeException("Account Opening Failed");
	}
	
	public long generateAccountNumber() {
		try {
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery("select account_number from account order by account_number desc limit 1;");
			if(resultset.next()) {
				long last_account_number = resultset.getLong("account_number");
				return last_account_number+1;
			}
			else {
				return 27031010;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 27031010;
	}
	
	public long getAccount_number(String email) {
		String get_query = "select * from account where email = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(get_query);
			preparedStatement.setString(1, email);
			ResultSet resultset = preparedStatement.executeQuery();
			if(resultset.next()) {
				return resultset.getLong("account_number");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		throw new RuntimeException("Account Number Doesn't Exist!");
	}
	
	public boolean account_exist(String email) {
		String query = "select * from account where email = ?;";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			ResultSet resultset = preparedStatement.executeQuery();
			if(resultset.next()) {
				return true;
			}else {
				return false;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
