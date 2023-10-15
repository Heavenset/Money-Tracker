package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SpentMoney extends DatabaseService {
	public String transactionType = "spending";
	ArrayList<Object> spent_Money_Values = new ArrayList<>();

	public int spentMoney(int spent_Money) {

		try {
			connection.setAutoCommit(false);
			String spentMoneySQL = "INSERT INTO spent_money (money_amount) values (?)";
			PreparedStatement addSpentMoney = connection.prepareStatement(spentMoneySQL,
					Statement.RETURN_GENERATED_KEYS);
			addSpentMoney.setLong(1, spent_Money);
			addSpentMoney.executeUpdate();
			ResultSet addSpentMoneyResult = addSpentMoney.getGeneratedKeys();
			if (addSpentMoneyResult.next()) {
				addSpentMoneyResult.getInt(1);
			}

			connection.commit();

		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		return -spent_Money;
	}
}
