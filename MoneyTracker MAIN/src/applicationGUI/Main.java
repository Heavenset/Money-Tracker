package applicationGUI;

import javafx.scene.control.TextField;
import database.ClearValuesDB;
import database.GettingValuesFromDB;
import database.GottenMoney;
import database.SpentMoney;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


// Current load time is ~370ms
public class Main extends Application {
	@SuppressWarnings({ "exports" })
	public void start(Stage stage) throws Exception {
		StackPane root = new StackPane();
		TextField textField = new TextField();
		Scene scene = new Scene(root);
		Image icon = new Image("image.png");

		Button gottenMoneyButton = new Button("Gotten Money");
		Button spentMoneyButton = new Button("Spent Money");
		Button profitButton = new Button("Display Profit");
		Button clearButton = new Button("Clear Data");

		Label outputLabel = new Label("Total");
		Label currentTransactionLabel = new Label("Current Transaction");

		SpentMoney spentMoney = new SpentMoney();
		GottenMoney gottenMoney = new GottenMoney();
		GettingValuesFromDB GettingValuesFromDB = new GettingValuesFromDB();
		ClearValuesDB ClearValuesDB = new ClearValuesDB();

		stage.setResizable(false);
		stage.setWidth(840);
		stage.setHeight(700);
		stage.getIcons().add(icon);
		stage.setTitle("Money Tracker");
		stage.setScene(scene);

		root.setStyle("-fx-background-color: black;");
		root.getChildren().addAll(outputLabel, currentTransactionLabel, gottenMoneyButton, spentMoneyButton,
				profitButton, clearButton, textField);

		gottenMoneyButton.setTranslateX(-250);
		gottenMoneyButton.setTranslateY(-200);
		gottenMoneyButton.setScaleX(2);
		gottenMoneyButton.setScaleY(2);

		spentMoneyButton.setTranslateX(260);
		spentMoneyButton.setTranslateY(-200);
		spentMoneyButton.setScaleX(2);
		spentMoneyButton.setScaleY(2);

		profitButton.setTranslateX(0);
		profitButton.setTranslateY(-200);
		profitButton.setScaleX(2);
		profitButton.setScaleY(2);

		clearButton.setTranslateX(0);
		clearButton.setTranslateY(-100);
		clearButton.setScaleX(2);
		clearButton.setScaleY(2);

		textField.setPromptText("Enter amount of money here");

		textField.setTranslateX(10);
		textField.setPrefWidth(0);
		textField.setPrefHeight(50);
		textField.setMaxWidth(300);

		currentTransactionLabel.setTranslateX(-10);
		currentTransactionLabel.setTranslateY(100);
		currentTransactionLabel.setScaleX(2.5);
		currentTransactionLabel.setScaleY(2.5);
		currentTransactionLabel.setTextFill(Color.WHITE);

		outputLabel.setTranslateX(-10);
		outputLabel.setTranslateY(200);
		outputLabel.setScaleX(2.5);
		outputLabel.setScaleY(2.5);
		outputLabel.setTextFill(Color.WHITE);

		stage.show();

		gottenMoneyButton.setOnAction(event -> {
			String text = textField.getText();
			int gotten = Integer.parseInt(text);
			currentTransactionLabel.setText("You've got $" + gotten);
			gottenMoney.gottenMoney(gotten);
			Integer total = GettingValuesFromDB.gettingValuesFromDB("gotten_money");
			outputLabel.setText("Amount of ALL GOTTEN money: $" + total.toString());
			textField.clear();
		});

		spentMoneyButton.setOnAction(event -> {
			String text = textField.getText();
			int spent = Integer.parseInt(text);
			currentTransactionLabel.setText("You've spent $" + spent);
			spentMoney.spentMoney(spent);
			Integer total = GettingValuesFromDB.gettingValuesFromDB("spent_money");
			total.toString();
			outputLabel.setText("Amount of ALL SPENT money: $" + total.toString());
			textField.clear();
		});

		profitButton.setOnAction(event -> {
			Integer total = GettingValuesFromDB.gettingValuesFromDB("gotten_money")
					- GettingValuesFromDB.gettingValuesFromDB("spent_money");
			total.toString();
			if (total < 0) {
				total = Math.abs(total);
				outputLabel.setText("Your PROFIT is: -$" + total.toString());
			} else {
				outputLabel.setText("Your PROFIT is: $" + total.toString());
			}
		});

		clearButton.setOnAction(event -> {
			ClearValuesDB.clearValuesDB();
			textField.clear();
		});
	}
}