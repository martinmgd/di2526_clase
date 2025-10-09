package EjerciciosUnidad1;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EJ7 extends Application{
    TextArea textTA = new TextArea();
    DateTimeFormatter f;

    public EJ7(){

        //Creamos boton
        String name = Thread.currentThread().getName();
        String f = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println("FXLifeCycleApp() constructor: " + name + "\n");
        textTA.appendText("[" + f + "]" + " Fío do constructor: " + "(" + name +")"+ "\n");
    }
    public static void main(String[] args) {
        Application.launch(args);
    }


    @Override
    public void init(){
        // creamos boton
    String name = Thread.currentThread().getName();
    String f = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    textTA.appendText("[" + f + "] " + "Fío do init(): " + "(" + name + ")" + "\n");
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Ciclo de vida con consola");

        String name = Thread.currentThread().getName();
        String f = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        textTA.setStyle("-fx-padding: 5px; -fx-background-color:#eef;");
        textTA.appendText("[" + f + "] " + "Fío do start(): " + "(" + name + ")" );
        //textarea.setText(textTA.get(2);
        Button btnCerrar = new Button("Cerrar aplicacion");

        Label lblPeche = new Label("Pecha a aplicación e comproba na consola a mensaxe");
        lblPeche.setStyle("-fx-text-fill: red;");

        VBox root = new VBox();
        root.getChildren().addAll(textTA,lblPeche, btnCerrar);

        // controlar botones
        btnCerrar.setOnAction(
        e -> {
        Platform.exit();
    });

        Scene scene = new Scene(root, 400, 200);
        stage.setScene(scene);
        stage.show();      

    }

    @Override
    public void stop(){
    textTA.appendText("Proba");
    }
}
  

