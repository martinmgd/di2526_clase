package EjerciciosUnidad1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EJ5 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
    //Creamos un nodo raíz vertical VBox
    VBox root = new VBox();

    //Creamos unha escena especificando nodo e tamaño
	Scene scene = new Scene(root, 300, 200);

    //Creamos los nodos raiz horizontales HBox
    HBox campos1 = new HBox();
    HBox campos2 = new HBox();
   
    //Creamos las etiquetas
    Label lbl1 = new Label("Novo ancho");
    Label lbl2 = new Label("Nova altura");
   
    //Creamos los campos de texto
    TextField texto1 = new TextField();
    TextField texto2 = new TextField();
    //Le ponemos un texto orientativo "hint"
    texto1.setPromptText("Indica o novo ancho...");
    texto2.setPromptText("Indica o novo alto...");

    //Creamos el boton
    Button btnRedimensionar = new Button("Redimensionar");

    //Manejamos el funcionamiento del boton
    btnRedimensionar.setOnAction(e ->{
        try{
        int ancho = Integer.parseInt(texto1.getText());
        int alto = Integer.parseInt(texto2.getText());

			if(ancho > 0 && alto > 0){
			stage.setWidth(ancho);
            stage.setHeight(alto); 
			}
            else{
				System.err.println("Error, valores negativos");            
            }
        }
        catch(NumberFormatException e2){
            System.err.println("Error, introduce número válidos");
        }

    });

    //Asignamos a los nodos los elementos que tiene en el orden de aparición
    campos1.getChildren().addAll(lbl1,texto1);
    campos2.getChildren().addAll(lbl2,texto2);

    root.getChildren().addAll(campos1,campos2,btnRedimensionar);

    //Le damos un título a la escena
    stage.setTitle("Cambiar tamaño da xanela");

    //Asignamos a escena ó escenario
    stage.setScene(scene);

	//Mostramos o escenario
	stage.show();

    }
}
