package EjerciciosUnidad1;

import javafx.application.Application;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class EJ20_IndicadorDeNumeroParOuImpar extends Application{

    @Override
    public void start(Stage stage) throws Exception {

        IntegerProperty numeroEnteiro = new SimpleIntegerProperty();

        Label texto = new Label("Número:");

        TextField opcionField = new TextField();

        Label parImpar = new Label();

        NumberStringConverter conversion = new NumberStringConverter();

        opcionField.textProperty().bindBidirectional(numeroEnteiro, conversion);

        StringBinding bindingPresonalizado = new StringBinding(){{
            this.bind(numeroEnteiro);
        }
            @Override
            protected String computeValue() {
                int numero = numeroEnteiro.get();

                if(numero % 2 == 0){
                    return "PAR";
                }
                else{
                    return "IMPAR";
                }
            }           
        };

        parImpar.textProperty().bind(bindingPresonalizado);

        VBox root = new VBox();
        root.getChildren().addAll(texto, opcionField, parImpar);

        Scene scene = new Scene(root,300,200);

        stage.setTitle("Indicador Par/Impar");

        stage.setScene(scene);

        stage.show();


    }
    public static void main(String[] args) {
        Application.launch(args);

    }
}
