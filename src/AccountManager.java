import java.math.BigDecimal;
import java.sql.*;
import java.util.Scanner;


public class AccountManager {
    private Connection connection;
    private Scanner scanner;
    AccountManager(Connection connection, Scanner scanner){
        this.connection = connection;
        this.scanner = scanner;
    }
}
