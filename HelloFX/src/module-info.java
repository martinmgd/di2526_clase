module HelloFX {
	requires javafx.graphics;
    requires javafx.controls;
    requires java.desktop;
    requires javafx.swing;
    requires javafx.media;
    requires javafx.web;
    requires javafx.fxml;
    requires jdk.jsobject;
    opens com.jdojo.intro to javafx.graphics, javafx.base;
}