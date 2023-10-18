module MoneyTracker {
	exports applicationGUI;
	exports database;

	requires java.sql;
	requires javafx.controls;
	requires java.desktop;
	requires javafx.graphics;
	requires javafx.base;

	opens applicationGUI to javafx.graphics, javafx.fxml;
}
