package EjerciciosUnidad1;



import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EJ17_Calculadora extends Application{

    @Override
    public void start(Stage stage) throws Exception {

        DoubleProperty prezo_unitario = new SimpleDoubleProperty();
        IntegerProperty cantidade = new SimpleIntegerProperty();

        Label prezo = new Label("Precio unitario:");
        Label cantidadeLbl = new Label("Cantidade:");
        Label prezo_totalLbl = new Label();

        TextField prezo_unitario_Field = new TextField();
        TextField cantidad_Field = new TextField();

        //listeners para as propiedades
        prezo_unitario.addListener((obs, oldValue, newValue)->{
            double total = newValue.doubleValue()* cantidade.get();
            prezo_totalLbl.setText(String.format("Total: %.2f€", total));
        });

        cantidade.addListener((obs, oldValue, newValue)->{
            double total = newValue.doubleValue() * prezo_unitario.get();
            prezo_totalLbl.setText(String.format("Total: %.2f€", total));
        });

        //Listeners para os campos

        prezo_unitario_Field.textProperty().addListener((obs, oldValue, newValue)->{
            try {
                if(!newValue.isEmpty()){
                prezo_unitario.set(Double.parseDouble(newValue));
                }
            } catch (NumberFormatException e) {
                
            }
        });

        cantidad_Field.textProperty().addListener((obs,oldValue,newValue)->{
            try{
                if(!newValue.isEmpty()){
                    cantidade.set(Integer.parseInt(newValue));
                }
            }
            catch(NumberFormatException e){

            }
        });

        VBox root = new VBox(new Label("Precio unitario:"), prezo_unitario_Field, new Label("Precio cantidade"), cantidad_Field, prezo_totalLbl);
        Scene scene = new Scene(root, 300, 200);

       

        stage.setTitle("Calculadora de prezo total sen Bindings");

        stage.setScene(scene);

        stage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }

}
