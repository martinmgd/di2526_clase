package EjerciciosUnidad1;

import javafx.scene.control.Label;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EJ16_VinculacionBidireccional extends Application {

    @Override
    public void start(Stage stage) {
        // 1. Crear la propiedad 'nome' de tipo StringProperty
        // Esta propiedad almacenará un valor de texto observable (reactivo)
        // de modo que otros componentes puedan vincularse a ella y actualizarse automáticamente.
        StringProperty nome = new SimpleStringProperty();

        // 2. Crear el campo de texto donde el usuario podrá escribir el nombre
        TextField campoTexto = new TextField();

        // 3. Vincular bidireccionalmente el campo de texto con la propiedad 'nome'
        // Esto significa que:
        //   - si el usuario escribe algo en el TextField, 'nome' se actualiza.
        //   - si cambiamos 'nome' desde el código, el TextField mostrará el nuevo valor.
        campoTexto.textProperty().bindBidirectional(nome);

        // 4. Crear una etiqueta (Label) vinculada a la propiedad 'nome'
        // Esta vinculación es unidireccional: el Label solo mostrará los cambios,
        // pero no podrá modificarlos.
        Label label = new Label();
        label.textProperty().bind(nome);

        // 5. Crear un botón que cambia el valor de 'nome' a "Invitado" al hacer clic
        // Como el TextField y el Label están vinculados a 'nome',
        // ambos se actualizarán automáticamente al pulsar el botón.
        Button botonCambiar = new Button("Cambiar a Invitado");
        botonCambiar.setOnAction(e -> nome.set("Invitado"));

        // 6. Crear un contenedor vertical (VBox) para organizar los componentes
        // con un espaciado de 10 píxeles entre ellos
        VBox root = new VBox(10, campoTexto, label, botonCambiar);

        // 7. Crear la escena principal con un tamaño de 300x100 píxeles
        Scene scene = new Scene(root, 300, 100);

        // 8. Configurar el escenario (ventana principal)
        stage.setScene(scene);
        stage.setTitle("Exercicio Vinculación Bidireccional");
        stage.show(); // Mostrar la ventana
    }

    // Método principal que lanza la aplicación JavaFX
    public static void main(String[] args) {
        Application.launch();
    }
}