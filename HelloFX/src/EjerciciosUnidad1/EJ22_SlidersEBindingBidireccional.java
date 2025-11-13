package EjerciciosUnidad1;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EJ22_SlidersEBindingBidireccional extends Application{

    @Override
public void start(Stage stage) throws Exception {



    Slider sliderVertical = new Slider(0, 100, 40);
    sliderVertical.setOrientation(Orientation.VERTICAL);

    Slider sliderHorizontal = new Slider(0,100,40);

    sliderVertical.valueProperty().bindBidirectional(sliderHorizontal.valueProperty());

    VBox root = new VBox(sliderVertical, sliderHorizontal);
    Scene scene = new Scene(root,200,150);
    stage.setScene(scene);
    stage.setTitle("Sliders y Bidings bidirecionales");
    stage.show();

}

public static void main(String[] args) {
    Application.launch(args);
}




}
