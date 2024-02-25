import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class BankingApp {
	
	private static final String url = "jdbc:mysql://localhost:3306/banking_system";
	
	private static final String username = "root";
	
	private static final String password = "01070107@Va";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection");
			Scanner scanner = new Scanner(System.in);
			
			User user = new User(connection, scanner);
			Accounts accounts = new Accounts(connection, scanner);
			AccountManager accountManager = new AccountManger(connection, scanner);
			
			String email;
			long account_number;
			
			while(true) {
				System.out.println("-----Welcome To Banking System-----");
				System.out.println();
				System.out.println("1. Register");
				System.out.println("2. Login");
				System.out.println("3. Exit");
				
				System.out.println("Enter Your Choice");
				
				int choice = scanner.nextInt();
				
				switch(choice) {
				case 1:
					user.register();
					break;
					
				case 2:
					email = user.login();
					if(email!=null) {
						System.out.println();
						System.out.println("User Logged In");
						if(!accounts.account_exist(email)) {
							System.out.println("1. Open New Bank Account");
							System.out.println("2. Exit");
							if(scanner.nextInt() == 1) {
								account_number = accounts.open_account(email);
								System.out.println("Account Created Successfully");
								System.out.println("Your Account Number is: " + account_number);
							}else {
								break;
							}
						}
						account_number = accounts.getAccount_number(email);
					}
				case 3:
					System.out.println("Thank You for using Banking System");	
					return;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
