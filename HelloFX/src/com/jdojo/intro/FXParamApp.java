package com.jdojo.intro;

import java.util.List;
import java.util.Map;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class FXParamApp extends Application{
	
	public void start(Stage stage) {
	//Obtenemos los parámetros de la aplicación
	Parameters p = this.getParameters();
	Map<String, String> namedParams = p.getNamed();
	List<String> unnamedParams = p.getUnnamed();
	List<String> rawParams = p.getRaw();

	String paramStr = "Parametros nomeados: " + namedParams + "\n" + 
	"Parametros non nomeados: " + unnamedParams + "\n" +
	"Parámetros en bruto: " + rawParams;
	
	TextArea ta = new TextArea(paramStr);
	Group root = new Group(ta);
	
	stage.setScene(new Scene(root));
	stage.setTitle("Parametros de la Aplicación");
	stage.show();

	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}
