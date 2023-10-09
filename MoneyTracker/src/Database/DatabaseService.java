package Database;

import java.sql.*;

public class DatabaseService {
	String url = "jdbc:postgresql://localhost:5432/";
	String dbName = "BankAdmin";
	String password = "securepassword";

	private Connection connect_to_DB() {
		Connection connection = null;
		try {
			Class.forName("org.postresql.Driver");
			connection = DriverManager.getConnection(url, dbName, password);
			if (connection != null) {
				System.out.println("Connection established.");
			} else {
				System.out.println("Connection failed.");
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return connection;
	}

	// CREATE
	int Money(int gotten_Money, int spent_Money) {
		Connection connection = connect_to_DB();
		int gottenMoney = -1;
		int spentMoney = -1;
		
		try {
			connection.setAutoCommit(false);
		}	catch (Exception e){
			System.err.println("Error: " + e.getMessage());
		}
		
		return spentMoney;

	}
}
