package EjerciciosUnidad1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class EJ2 extends Application{

     @Override
    public void start(Stage stage) throws Exception {

    //Creamos un nodo raíz VBox
    VBox root = new VBox();

    //Creamos unha escena especificando nodo e tamaño
	Scene scene = new Scene(root, 300, 200);

    //Creamos los botones
    Button btnVermello = new Button("Vermello");
    Button btnVerde = new Button("Verde");
    Button btnAzul = new Button("Azul");
 
    //Creamos la acción del botón rojo, si pusamos el botón cambiará el color del fondo de la escena al respectivo color
    btnVermello.setOnAction(e -> root.setBackground(new Background(new BackgroundFill(Color.RED, null, null))));
    btnVerde.setOnAction(e -> root.setBackground(new Background(new BackgroundFill(Color.GREEN,null , null))));
    btnAzul.setOnAction(e -> root.setBackground(new Background(new BackgroundFill( Color.BLUE, null, null))));

    root.getChildren().addAll(btnVermello, btnVerde, btnAzul);

    //Poñemoslle título á escena
		stage.setTitle("Cambiar cor de fondo");

		//Creamos a escena 
		stage.setScene(scene);
		
		//Mostramolo escenario
		stage.show();
    }
    public static void main(String[]args){
        Application.launch(args);
    }

}
