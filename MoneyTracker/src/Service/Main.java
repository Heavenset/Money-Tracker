package Service;

import java.util.Scanner;

import Database.GottenMoney;
import Database.SpentMoney;

public class Main {

	SpentMoney spentMoney = new SpentMoney();
	GottenMoney gottenMoney = new GottenMoney();

	protected Scanner scanner = new Scanner(System.in);
	boolean exit;

	public static void main(String[] args) {
		Main main = new Main();
		main.launch();
	}

	public void launch() {
		while (!exit) {
			displayMenu();
			int choice = getInput();
			chooseOperation(choice);
		}
	}

	public void displayMenu() {
		System.out.println("Choose: " + "\n1. Earned money" + "\n2. Spent money" + "\n3. Display profit" + "\n0. Exit");
	}

	public void chooseOperation(int choice) {

		switch (choice) {
		case 0:
			System.out.println("Bye.");
			System.exit(0);
			break;
		case 1:
			gottenMoney.gottenMoney();
			break;
		case 2:
			spentMoney.spentMoney();
			break;
		case 3:
			displayProfit();
		}
	}

	public int displayProfit() {
		int profit = spentMoney.spentMoney() - gottenMoney.gottenMoney();
		System.out.println(profit);
		return profit;
	}

	public int getInput() {
		int choice = -1;

		do {
			System.out.print("Your choice: ");
			try {
				choice = Integer.parseInt(scanner.nextLine());

				if (choice < 0 || choice > 3) {
					System.out.println("Choice is out of range.");
				}

			} catch (NumberFormatException e) {
				System.err.println(e);
			}

		} while (choice < 0 || choice > 3);
		return choice;
	}
}
