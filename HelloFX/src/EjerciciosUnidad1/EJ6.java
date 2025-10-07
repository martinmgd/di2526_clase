package EjerciciosUnidad1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class EJ6 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

    //Creamos un nodo raíz vertical VBox
    VBox root = new VBox();

    //Creamos unha escena especificando nodo e tamaño
	Scene scene = new Scene(root, 300, 200);

    //Creamos las etiquetas
    Label lbl1 = new Label("Cal é a capital de Galicia?");
    Label lbl2 = new Label("-A Coruña");
    Label lbl3 = new Label("-Santiago de Compostela");
    Label lbl4 = new Label("-Vigo");

    //Creamos el campo de texto
    TextField texto = new TextField();

    //Creamos el boton
    Button btnResponder = new Button("Enviar resposta");

    btnResponder.setOnAction(e ->{
        try{
            String respostaCorrecta = "santiago de compostela";
            String resposta = texto.getText().trim();
            if( respostaCorrecta.toLowerCase().equals(resposta.toLowerCase())){
                root.setBackground(new Background(new BackgroundFill(Color.GREEN,null , null)));
            }
            else{
                root.setBackground(new Background(new BackgroundFill(Color.RED,null , null)));
            }
        }
        catch(Exception e2){
            System.err.println("Error, " + e2.getMessage());
        }
    });

    //Asignamos al nodo principal los elementos que tiene en el orden de aparición
    root.getChildren().addAll(lbl1, lbl2, lbl3, lbl4, texto, btnResponder);

    //Le damos un título a la escena
    stage.setTitle("Mini Cuestionario");

    //Asignamos a escena ó escenario
    stage.setScene(scene);

	//Mostramos o escenario
	stage.show();

    }
}
