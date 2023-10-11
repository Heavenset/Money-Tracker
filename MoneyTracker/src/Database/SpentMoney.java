package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SpentMoney extends DatabaseService {
	public int spentMoney() {
		System.out.print("Enter amount of money you've spent: ");
		int spent_Money = Integer.parseInt(scanner.nextLine());

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
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		return -spent_Money;
	}
}
