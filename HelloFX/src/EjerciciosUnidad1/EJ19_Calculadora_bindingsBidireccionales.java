package EjerciciosUnidad1;

import javafx.application.Application;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.StringBinding;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class EJ19_Calculadora_bindingsBidireccionales extends Application{
    @Override
    public void start(Stage stage) throws Exception {

        DoubleProperty prezo_unitario = new SimpleDoubleProperty();
        IntegerProperty cantidade = new SimpleIntegerProperty();
        DoubleProperty desconto = new SimpleDoubleProperty();

        Label prezo = new Label("Precio unitario:");
        Label cantidadeLbl = new Label("Cantidade:");
        Label prezo_totalLbl = new Label();
        Label descuentoLabel = new Label("Descuento");
        Label alertaLabel = new Label();

        TextField prezo_unitario_Field = new TextField();
        TextField cantidad_Field = new TextField();
        TextField desconto_Field = new TextField();

        //listeners para as propiedades
        prezo_unitario_Field.textProperty().addListener((obs, oldValue, newValue)->{
             try{
                if(!newValue.isEmpty()){
                    prezo_unitario.set(Integer.parseInt(newValue));
                }
            }catch(ArithmeticException e){

            }
        });

        cantidad_Field.textProperty().addListener((obs, oldValue, newValue)->{
                            try{
                if(!newValue.isEmpty()){
                    cantidade.set(Integer.parseInt(newValue));
                }
            }catch(ArithmeticException e){

            }
        });

        desconto_Field.textProperty().addListener((obs, oldValue, newValue)-> {
            try{
                if(!newValue.isEmpty()){
                    desconto.set(Integer.parseInt(newValue));
                }
            }catch(ArithmeticException e){

            }
        });

        prezo_unitario_Field.textProperty().addListener((obs, oldValue, newValue)->{
            try {
                if(!newValue.isEmpty()){
                prezo_unitario.set(Double.parseDouble(newValue));
                }
            } catch (NumberFormatException e) {
                
            }
        });

        prezo_unitario_Field.textProperty().bindBidirectional(prezo_unitario, new NumberStringConverter());
        cantidad_Field.textProperty().bindBidirectional(cantidade, new NumberStringConverter());
        desconto_Field.textProperty().bindBidirectional(desconto, new NumberStringConverter());

        DoubleBinding total = prezo_unitario.multiply(cantidade).subtract(
            prezo_unitario.multiply(cantidade).multiply(desconto.divide(100))
        );

        StringBinding alertaPrezo = Bindings.when(total.greaterThan(100)).then("Prezo alto").otherwise("");

        StringBinding totalFormateado = Bindings.createStringBinding(
            () -> String.format("Total: %.2f€", total.get()), total
        );


        prezo_totalLbl.textProperty().bind(totalFormateado);
        alertaLabel.textProperty().bind(alertaPrezo);


        VBox root = new VBox(new Label("Precio unitario:"), prezo_unitario_Field, new Label("Precio cantidade"), cantidad_Field,descuentoLabel,desconto_Field, prezo_totalLbl,alertaLabel);
        Scene scene = new Scene(root, 300, 200);

        stage.setTitle("Calculadora con Bindings bidireccionais");

        stage.setScene(scene);

        stage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
