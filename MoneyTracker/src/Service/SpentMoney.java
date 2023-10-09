package Service;

import java.util.Scanner;

public class SpentMoney {
	Scanner scanner = new Scanner(System.in);
	
	public int spentMoney() {
	
		System.out.print("Enter amount of money you've spent: ");
		int spentMoney = Integer.parseInt(scanner.nextLine());

		return -spentMoney;
	}
}
