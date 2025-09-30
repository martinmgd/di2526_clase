package EjerciciosUnidad1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EJ3 extends Application{

    private int contador = 0;

    @Override
    public void start(Stage stage) throws Exception {


        //Creamos unha etiqueta(Label) con texto
        Label nameLbl = new Label("Contador: " + contador);
		TextField nameFld = new TextField();
        //Creamos el botón incrementar
        Button boton = new Button("Incrementar");
        //Crear controlador para manexar o evento dos botóns
		boton.setOnAction(e ->{
            contador ++;
            nameLbl.setText("Contador: " + contador);
        });
        //Creamos o elemento raíz
        VBox root = new VBox(10);

        root.getChildren().addAll(nameLbl, boton);
        //Creamos a escena especificando o seu tamaño
        Scene scene = new Scene(root, 300, 300);
        //Le damos un título a la escena
        stage.setTitle("Click Me!");
        //Asignamos a escena ó escenario
        stage.setScene(scene);
		//Mostramos o escenario
		stage.show();

    }

    public static void main(String[]args){
        Application.launch(args);
    }
}

