package Database;

import java.sql.Statement;

public class ClearValuesDB extends DatabaseService {
	public void clearValuesDB() {
		try {
			Statement statement = connection.createStatement();
			String deletingDataSQL = "TRUNCATE gotten_money, spent_money";
			statement.executeUpdate(deletingDataSQL);
		} catch (Exception e) {

		}
	}
}
