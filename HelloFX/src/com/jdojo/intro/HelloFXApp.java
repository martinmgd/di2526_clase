package com.jdojo.intro;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloFXApp extends Application{

	
	public static void main(String[] args) {
		Application.launch(args);
	}
	@Override
	public void start(Stage stage)throws Exception{
		
		//Creamos un nodo raíz VBox
		VBox root = new VBox();
		//Creamos un nodo de texto
		Text msg = new Text("Hola JavaFX");
		//Añadimos un nodo Text ó VBox como fillo
		root.getChildren().add(msg);
		
		//Creamos unha escena especificando nodo e tamaño
		Scene scene = new Scene(root, 300, 50);
		//Asignamos a escena ó escenario
		stage.setScene(scene);
		//Establecer un título para o escenario
		stage.setTitle("Aplicación JavaFX con unha escena");
		//Amosar o escenario
		stage.show();
		
	}
}
