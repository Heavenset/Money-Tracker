module Prototype {
	exports applicationGUI;
	exports etc;

	requires java.sql;
	requires javafx.controls;
	requires java.desktop;
	requires javafx.graphics;
	requires javafx.base;
	requires org.apache.commons.lang3;

	opens applicationGUI to javafx.graphics, javafx.fxml;
}
