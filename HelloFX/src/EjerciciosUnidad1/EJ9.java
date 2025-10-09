package EjerciciosUnidad1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EJ9 extends Application{

    int contador = 1;
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        //Creamos un nodo principal(vertical)
        VBox root = new VBox();
        //Creamolo campo de texto
        TextField txtF = new TextField();
        //Creamos op boton
        Button btnTarea = new Button("Nova tarefa");
        //Asignamoslle ó nodo principal os seus elementos en orden de aparición
        root.getChildren().addAll(txtF, btnTarea);
        //Abrimolo manejo do botón
        btnTarea.setOnAction(e ->{

            //Se o campo de texto está vacío mostrará en vermello o texto "Este campo es obligatorio"
            if(txtF.getText().equals("")){
                txtF.setStyle("-fx-prompt-text-fill: red");
                txtF.setPromptText("Este campo es obligatorio");
            }
            else{
                //Si non está vacío creará unha etiqueta cun texto e un estilo
                Label lbTarea = new Label("Tarefa_" + contador + ": " + txtF.getText());
                lbTarea.setStyle("-fx-padding: 6;");
                contador++;
            
            //Asignamoslle ó nodo principal a etiqueta
            root.getChildren().add(lbTarea);
            //Limpiamolo campo de texto
            txtF.clear();
            }
        });

        //Creamola escena
        Scene scene = new Scene(root, 300,400);
        //Damoslle un título ó escenario
        stage.setTitle("To-Do List");
        //Asignamoslle a escena ó escenario
        stage.setScene(scene);
        //mostramolo escenario
        stage.show();
    }

}
