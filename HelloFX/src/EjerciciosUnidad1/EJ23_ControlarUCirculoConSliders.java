package EjerciciosUnidad1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class EJ23_ControlarUCirculoConSliders extends Application{

    @Override
    public void start(Stage stage) throws Exception {

        Pane root = new Pane();
        Circle circulo = new Circle();

        circulo.setCenterX(150);
        circulo.setCenterY(150);
        circulo.setRadius(40);
        circulo.setFill(Color.ANTIQUEWHITE);
        circulo.setStroke(Color.BLACK);
        circulo.setStrokeWidth(2);

        Slider sld1 = new Slider(0, 100, 40);
        sld1.setShowTickMarks(true);
        sld1.setShowTickLabels(true);
        sld1.setMajorTickUnit(20);
        sld1.relocate(85, 10);

        Slider sld2 = new Slider();
        sld2.setShowTickMarks(true);
        sld2.setShowTickLabels(true);
        sld2.setMajorTickUnit(2);
        sld2.relocate(85, 40);

        circulo.radiusProperty().bind(sld1.valueProperty());
        circulo.strokeWidthProperty().bind(sld2.valueProperty());
        root.getChildren().addAll(sld1, sld2, circulo);
        Scene scene = new Scene(root, 300, 250);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
