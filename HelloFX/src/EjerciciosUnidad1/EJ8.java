package EjerciciosUnidad1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class EJ8 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        //Creamos un nodo principal(horizontal)
        HBox root = new HBox();

        //Creamos unha escena especificando nodo e tamaño
	    Scene scene = new Scene(root, 600, 400);

        //Creamos dos TextField
        TextField txtf1 = new TextField();
        TextField txtf2 = new TextField();

        txtf1.setPromptText("Operando 1");
        txtf2.setPromptText("Operando 2");

        //Creamos una etiqueta
        Label lblRsult = new Label("Resultado:");

        //Creamos los botones
        Button btnSumar = new Button("+");
        Button btnRestar = new Button("-");
        Button btnMultiplicar = new Button("*");
        Button btnDividir = new Button("/");


        
        //Manejamos los botenes asignandole sus operaciones
        btnSumar.setOnAction(e -> {
            Double Operando1 = Double.parseDouble(txtf1.getText());
            Double Operando2 = Double.parseDouble(txtf2.getText());
            Double resultado;
            try{          
            resultado = Operando1 + Operando2;
            lblRsult.setText(resultado.toString());
            }
            catch(Exception e2){
                lblRsult.setText("Error con los operandos");
            }
        });

        btnRestar.setOnAction(e -> {
            Double Operando1 = Double.parseDouble(txtf1.getText());
            Double Operando2 = Double.parseDouble(txtf2.getText());    
            Double resultado;
            try{          
            resultado = Operando1 - Operando2;
            lblRsult.setText(resultado.toString());
            }
            catch(Exception e2){
                lblRsult.setText("Error con los operandos");
            }
        });

        btnMultiplicar.setOnAction(e -> {
            Double Operando1 = Double.parseDouble(txtf1.getText());
            Double Operando2 = Double.parseDouble(txtf2.getText());
            Double resultado;
            try{          
            resultado = Operando1 * Operando2;
            lblRsult.setText(resultado.toString());
            }
            catch(Exception e2){
                lblRsult.setText("Error con los operandos");
            }
        });
        
        btnDividir.setOnAction(e -> {
            Double Operando1 = Double.parseDouble(txtf1.getText());
            Double Operando2 = Double.parseDouble(txtf2.getText());
            Double resultado;
            try{          
            resultado = Operando1 / Operando2;
            lblRsult.setText(resultado.toString());
            }
            catch(Exception e2){
                lblRsult.setText("Error con los operandos");
            }
        });

        //Asignamos al nodo principal los elementos que tiene en el orden de aparición
        root.getChildren().addAll(txtf1,txtf2,lblRsult,btnSumar,btnRestar,btnMultiplicar,btnDividir);

        //Le damos un título a la escena
        stage.setTitle("Mini Cuestionario");

        //Asignamos a escena ó escenario
        stage.setScene(scene);

	    //Mostramos o escenario
	    stage.show();
    }
}
