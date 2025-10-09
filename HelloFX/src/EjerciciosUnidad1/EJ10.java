package EjerciciosUnidad1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EJ10 extends Application{
    //Creamos contador como atributo para evitar errores, xa que se se pon como variable daba error
    int contador = 1;
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //Creamos un nodo principal(vertical)
        VBox root = new VBox();
        //Creamos un campo de texto para introducir as tarefas
        TextField txtF = new TextField();
        //Creamos o botón para agregalas novas tarefas
        Button btnTarea = new Button("Nova tarefa");
        
        //Metemoslle ó nodo raíz os seus elementos en orden de aparición
        root.getChildren().addAll(txtF, btnTarea);
        //Empezamos a manejar o boton para que raga as accións que necesitamos
        btnTarea.setOnAction(e ->{
            //Si o campo do texto está vacío amosaranos un texto vermello poñendo "Este campo es obligatorio"
            if(txtF.getText().equals("")){
                txtF.setStyle("-fx-prompt-text-fill: red");
                txtF.setPromptText("Este campo es obligatorio");
            }
            else{
                //Se non está vacío creará un HBox, un CheckBox e un Label
                HBox horBox = new HBox();
                CheckBox cb =new CheckBox();
                //Metemoslle texto e estilo á etiqueta, ademais facemos que o contador vaia aumentando
                Label lbTarea = new Label("Tarefa_" + contador + ": " + txtF.getText());
                lbTarea.setStyle("-fx-padding: 6;");
                contador++;
                //Creamos o boton borrar
                Button btnBorrar = new Button("Borrar");
                //Manejamos o checkBox para que maneje á sua vez o boton borrar
                cb.selectedProperty().addListener((obs, antes, agora) -> {
                btnBorrar.setDisable(!agora);               
                });
                //Manejamos o boton borrar para que cando o pulsemos borré o seu parent(padre, e decir, o HBox) en resumen, elimina o HBox
                btnBorrar.setOnAction(e2 -> root.getChildren().remove(btnBorrar.getParent()));

                //Asignamoslle ó HBox os seus elementos, neste caso o ChechBox, o Label e o Boton en orden de aparición
                horBox.getChildren().addAll(cb,lbTarea, btnBorrar);
            
            //Á súa vez, asignamoslle ó nodo principal(VBox) os seus elemento(o HBox)
            root.getChildren().add(horBox);
            //Limpiamos o campo de texto(TextField)
            txtF.clear();
            }
        });
        //Creamola escena
        Scene scene = new Scene(root, 300,400);

        //Damoslle un título ó escenario
        stage.setTitle("To-Do List con borrado");

        //Asignamos a escena ó escenario
        stage.setScene(scene);

        //Mostramos o escenario
        stage.show();       
    }
}
