package Database;

import java.sql.*;
import java.util.Scanner;

public class DatabaseService {
	String url = "jdbc:postgresql://localhost:5432/";
	String dbName = "MoneyTracker";
	String password = "moneyTracker";
	private static String stopWord = " ";

	public Connection connect_to_DB() {
		Connection connection = null;

		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(url, dbName, password);
			if (connection != null) {
				if (stopWord != "stop") {
					System.out.println("Connection established.");
					stopWord = "stop";
				}
			} else {
				System.out.println("Connection failed.");
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return connection;
	}

	Connection connection = connect_to_DB();
	static Scanner scanner = new Scanner(System.in);
}
