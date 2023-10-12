package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GettingValuesFromDB extends DatabaseService {
	String transactionType;

	public double gettingValuesFromDB(String transactionType) {
		double sum = 0.0;
		{

			try (Connection connection = DriverManager.getConnection(url, dbName, password)) {
				// Code for querying and processing results will go here
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
			try (Statement statement = connection.createStatement()) {
				String gettingDataSQL = "SELECT * FROM " + transactionType;
				ResultSet dataResult = statement.executeQuery(gettingDataSQL);
				while (dataResult.next()) {
					double value = dataResult.getDouble("money_amount");
					sum += value;
					return sum;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sum;
	}
}