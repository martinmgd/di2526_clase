package EjerciciosUnidad1;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.ObjectBinding;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class EJ21_XanelaConBindingHelper extends Application{

    

    @Override
    public void start(Stage stage) throws Exception {

        Button boton = new Button("Pulsar");
        VBox root = new VBox(boton);
        root.setBackground(Background.EMPTY);  
        Scene scene = new Scene(root,300,250); 
        scene.fillProperty().bind(
        Bindings.when(boton.pressedProperty())
            .then(Color.MAGENTA)
            .otherwise(Color.AQUA)
        );


        stage.setTitle("Binding Helper");
        stage.setScene(scene);
        stage.show();

    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }


}



