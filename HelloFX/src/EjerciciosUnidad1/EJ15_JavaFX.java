package EjerciciosUnidad1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EJ15_JavaFX extends Application{

    public void start(Stage stage){
        // Crea un objeto de la clase EJ15_CocheFX (modelo del coche)
        EJ15_CocheFX coche = new EJ15_CocheFX();
        
        // Establece valores iniciales del coche
        coche.setMarca("McLaren");
        coche.setVelocidade(100);

        // Crea etiquetas (labels) para mostrar los datos del coche
        Label labelMarca = new Label();
        Label labelVelocidade = new Label();

        // Enlaza (bind) las propiedades del coche con las etiquetas
        // Así, si cambia la marca o la velocidad, las etiquetas se actualizan automáticamente
        labelMarca.textProperty().bind(coche.marcaProperty());
        labelVelocidade.textProperty().bind(coche.velocidadeProperty().asString());

        // Crea un botón que, al hacer clic, aumenta la velocidad del coche en 25 km/h
        Button btnAcelerar = new Button("Acelerar (+25 km/h)");
        btnAcelerar.setOnAction(e -> coche.acelerar(25));

        // Crea un contenedor vertical (VBox) con un espacio de 10 píxeles entre elementos
        VBox root = new VBox(10);
        
        // Añade los elementos al contenedor: las etiquetas y el botón en orden de aparición
        root.getChildren().addAll(labelMarca, labelVelocidade, btnAcelerar);

        // Crea la escena (el contenido visual) con tamaño 300x200 píxeles
        Scene scene = new Scene(root, 300, 200);

        // Establece el título de la ventana
        stage.setTitle("Coche FX");

        // Asocia la escena al escenario (ventana principal)
        stage.setScene(scene);
        
        // Muestra la ventana
        stage.show();
    }

    // Método main: punto de entrada de la aplicación
    public static void main(String[] args) {
        // Lanza la aplicación JavaFX
        Application.launch(args);
    }
}