module MoneyTracker {
	exports ApplicationGUI;
	exports Database;

	requires java.sql;
	requires javafx.controls;
	requires java.desktop;
	requires javafx.graphics;
	requires javafx.base;

	opens ApplicationGUI to javafx.graphics, javafx.fxml;
}
