package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GettingValuesFromDB extends DatabaseService {
	public int gettingValuesFromDB(String transactionType) {
		int sum = 0;

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, dbName, password);
			Statement statement = connection.createStatement();

			String gettingDataSQL = "SELECT * FROM " + transactionType;
			ResultSet dataResult = statement.executeQuery(gettingDataSQL);
			int columnIndex = dataResult.findColumn("money_amount");
			while (dataResult.next()) {
				double value = dataResult.getDouble(columnIndex);
				sum += value;
			}

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sum;
	}
}