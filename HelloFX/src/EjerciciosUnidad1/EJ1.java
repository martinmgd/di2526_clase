package EjerciciosUnidad1;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class EJ1 extends Application{

    public void start(Stage stage){
		//Creamos un nodo raíz Group
		Group root = new Group();

		//Creamos unha escena especificando nodo e tamaño
		Scene scene = new Scene(root, 400, 300);

		//Creamos dous títulos de tipo String para o stage
		String primerTitulo = "Miña primeira xanela";
		String segundoTitulo = "Título cambiado";

		//Creamos os botóns
		Button btnTitulo = new Button("Cambiar título");

		//Creamos a acción para o boton, se cando pulsamolo boton o título é igual ó orixinal cambiao ó segundo título e en caso contrario cambiao ó orixinal
		btnTitulo.setOnAction(e ->{
			if(stage.getTitle().equals(primerTitulo)){
			stage.setTitle(segundoTitulo); 
			}else{
				stage.setTitle(primerTitulo);
			}
		});
		//Facemos que o nodo raíz colla ós seus fillos, neste caso só ó botón
		root.getChildren().addAll(btnTitulo);

		//Poñemoslle título á escena
		stage.setTitle(primerTitulo);

		//Creamos a escena 
		stage.setScene(scene);
		
		//Mostramolo escenario
		stage.show();
    }
	    public static void main(String[]args){

        Application.launch(args);

    }
}
