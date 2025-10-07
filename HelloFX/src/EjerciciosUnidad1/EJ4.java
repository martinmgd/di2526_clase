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

public class EJ4 extends Application{

        private Integer numero = 0;
        private Integer nsecreto = 0;
        private int intentos = 0;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
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


        btnProbar.setOnAction(e ->{
        try{
            numero =Integer.parseInt(texto.getText());

            if(numero < 0 || numero > 100){
                lbl2.setText("El número está fuera de rango");
                intentos++;
                lbl3.setText("Intentos: " + intentos);
            }
            else if(numero > nsecreto){
                lbl2.setText("O número é mais baixo.");
                intentos++;
                lbl3.setText("Intentos: " + intentos);
            }
            else if(numero < nsecreto){
                lbl2.setText("O número é mais alto.");
                intentos++;
                lbl3.setText("Intentos: " + intentos);
            }
            else if(numero == nsecreto){
                lbl2.setText("Correcto, o número é: " + nsecreto);
                lbl2.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, null, null)));
                intentos++;
                lbl3.setText("Intentos: " + intentos);
            }
        }
        catch(NumberFormatException e2){
            lbl2.setText("O introducido non é un número");
        }    
        } );
        btnReiniciar.setOnAction(e ->{
             nsecreto = (int) (Math.random() * 100);
             intentos = 0;
             lbl2.setText("");
             lbl2.setStyle("-fx-background-color: transparent");
             texto.clear();
             lbl3.setText("Intentos: " + intentos);

            /* 
            try {
                start(stage);
                intentos = 0;
                lbl3.setText("Intentos: " + intentos);
            } 
            catch (Exception e1) {
                e1.printStackTrace();
            }
            */
        });
        btnRendirse.setOnAction(e ->{
            lbl2.setText("O número secreto era: " + nsecreto);
            lbl2.setBackground(new Background(new BackgroundFill(Color.LIGHTCORAL, null, null)));
            intentos++;
            lbl3.setText("Intentos: " + intentos);    
        });
        
        //Asignamos al nodo principal los elementos que tiene en el orden de aparición
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
