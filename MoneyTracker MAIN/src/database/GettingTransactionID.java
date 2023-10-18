package database;

import java.sql.ResultSet;
import java.sql.Statement;

public class GettingTransactionID extends DatabaseService {
	public int gettingTransactionID(String transactionType) {
		int maxNumber = 0;
		try {
			Statement statement = connection.createStatement();
			String gettingTransactionIdSQL = "SELECT MAX(transaction_id) FROM " + transactionType;
			ResultSet resultSet = statement.executeQuery(gettingTransactionIdSQL);
			if (resultSet.next()) {
				maxNumber = resultSet.getInt(1);
			}
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		return maxNumber;
	}
}
