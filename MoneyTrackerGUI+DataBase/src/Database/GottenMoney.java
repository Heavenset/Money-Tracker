package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class GottenMoney extends DatabaseService {
	public String transactionType = "getting";

	public int gottenMoney(int gotten_Money) {

		try {
			connection.setAutoCommit(false);
			String gottenMoneySQL = "INSERT INTO gotten_money (money_amount) values (?)";
			PreparedStatement addGottenMoney = connection.prepareStatement(gottenMoneySQL,
					Statement.RETURN_GENERATED_KEYS);
			addGottenMoney.setLong(1, gotten_Money);
			addGottenMoney.executeUpdate();
			ResultSet addGottenMoneyResult = addGottenMoney.getGeneratedKeys();
			if (addGottenMoneyResult.next()) {
				addGottenMoneyResult.getInt(1);
			}
			connection.commit();

		} catch (Exception e) {

		}
		return gotten_Money;
	}
}
