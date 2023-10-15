package Service;

import java.util.Scanner;

public class GottenMoney{
	Scanner scanner = new Scanner(System.in);

	public int gottenMoney() {
		System.out.print("Enter amount of money you've earned: ");
		int gottenMoney = Integer.parseInt(scanner.nextLine());

		return +gottenMoney;
	}
}
