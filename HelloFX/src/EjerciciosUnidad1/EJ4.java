package EjerciciosUnidad1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EJ4 extends Application{
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        Integer numero = 0;
        Integer nsecreto = 0;
        int intentos = 0;
        //Creamos el nodo raíz
        VBox root = new VBox();
        //Creamos una etiqueta
        Label lbl1 = new Label("Adiviña o número comprendido entre 0 e 100");
        nsecreto = (int) (Math.random() * 100);
        //Creamos un campo de texto para introducir un número
        TextField texto = new TextField();

        //Creamos los botones
        Button btnProbar = new Button("Probar");
        Button btnReiniciar = new Button("Reiniciar Xogo");
        Button btnRendirse = new Button("Rendirse");
        //Creamos dos etiquetas  
        Label lbl2 = new Label();
        Label lbl3 = new Label("Intentos: " + intentos);

        root.getChildren().addAll(lbl1, texto, btnProbar, btnReiniciar, btnRendirse, lbl2, lbl3);
        //Creamos a escena especificando o seu tamaño
        Scene scene = new Scene(root, 300, 300);
        //Le damos un título a la escena
        stage.setTitle("Adiviña o número");
        //Asignamos a escena ó escenario
        stage.setScene(scene);
		//Mostramos o escenario
		stage.show();

      }
}
