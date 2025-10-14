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

/**
 * Ejercicio EJ7 - Demostración del ciclo de vida de una aplicación JavaFX.
 * Muestra en pantalla y en consola en qué hilo y momento se ejecuta cada parte:
 * constructor, init(), start() y stop().
 */
public class EJ7 extends Application {

    // Área de texto donde se mostrarán los mensajes
    TextArea textTA = new TextArea();

    // Formateador de hora (aunque no se usa directamente como variable de clase)
    DateTimeFormatter f;

    // CONSTRUCTOR
    public EJ7() {
        // Obtiene el nombre del hilo actual (normalmente "main")
        String name = Thread.currentThread().getName();

        // Obtiene la hora actual formateada
        String f = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        // Muestra información en consola
        System.out.println("FXLifeCycleApp() constructor: " + name + "\n");

        // Añade texto al área de texto con la información del constructor
        textTA.appendText("[" + f + "] Fío do constructor: (" + name + ")\n");
    }

    // MÉTODO MAIN
    public static void main(String[] args) {
        // Lanza la aplicación JavaFX (esto ejecuta constructor, init(), start(), stop())
        Application.launch(args);
    }


    // MÉTODO INIT()
    @Override
    public void init() {
        // Este método se ejecuta antes de start(), en un hilo distinto
        String name = Thread.currentThread().getName();
        String f = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        // Añade información al área de texto
        textTA.appendText("[" + f + "] Fío do init(): (" + name + ")\n");
    }


    // MÉTODO START()
    @Override
    public void start(Stage stage) throws Exception {
        // Configuramos el título de la ventana
        stage.setTitle("Ciclo de vida con consola");

        // Obtenemos el nombre del hilo actual (ahora será el hilo JavaFX Application Thread)
        String name = Thread.currentThread().getName();
        String f = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        // Damos estilo al área de texto
        textTA.setStyle("-fx-padding: 5px; -fx-background-color:#eef;");

        // Añadimos mensaje indicando que estamos en el método start()
        textTA.appendText("[" + f + "] Fío do start(): (" + name + ")\n");

        // Creamos un botón para cerrar la aplicación
        Button btnCerrar = new Button("Cerrar aplicación");

        // Etiqueta con instrucciones
        Label lblPeche = new Label("Pecha a aplicación e comproba na consola a mensaxe");
        lblPeche.setStyle("-fx-text-fill: red;");

        // Contenedor principal vertical
        VBox root = new VBox();

        // Añadimos los elementos al contenedor
        root.getChildren().addAll(textTA, lblPeche, btnCerrar);

        // Acción del botón: cerrar la aplicación al pulsarlo
        btnCerrar.setOnAction(e -> {
            Platform.exit(); // Finaliza la aplicación, ejecutando el método stop()
        });

        // Creamos la escena con el contenedor principal
        Scene scene = new Scene(root, 400, 200);

        // Asociamos la escena a la ventana
        stage.setScene(scene);

        // Mostramos la ventana
        stage.show();
    }

    // MÉTODO STOP()
    @Override
    public void stop() {
        // Este método se ejecuta justo antes de que la aplicación se cierre
        // Aquí normalmente se liberarían recursos o se guardarían datos
        textTA.appendText("\nAplicación finalizada (método stop() ejecutado)\n");

        // También mostramos mensaje en consola
        System.out.println("Método stop() ejecutado correctamente.");
    }
}
  

