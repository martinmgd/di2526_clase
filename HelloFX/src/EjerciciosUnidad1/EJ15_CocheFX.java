package EjerciciosUnidad1;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EJ15_CocheFX {
    // Propiedad de tipo String que representa la marca del coche.
    // Se usa StringProperty para poder enlazarla (bind) fácilmente con elementos JavaFX (como Labels).
    private StringProperty marca = new SimpleStringProperty(this, "marca", "");

    // Propiedad entera que representa la velocidad del coche.
    // Igual que arriba, pero usando SimpleIntegerProperty para enlaces dinámicos.
    private SimpleIntegerProperty velocidade = new SimpleIntegerProperty(this, "velocidade", 0);
   
    // Método setter: establece el valor de la marca.
    public void setMarca(String marca) {
        this.marca.set(marca);
    }

    // Método getter: devuelve el valor actual de la marca.
    public String getMarca() {
        return marca.get();
    }

    // Setter de la velocidad: cambia la velocidad actual del coche.
    public void setVelocidade(int velocidade) {
        this.velocidade.set(velocidade);
    }

    // Getter de la velocidad: obtiene el valor actual de la velocidad.
    public int getVelocidade() {
        return velocidade.get();
    }

    // Devuelve la propiedad "marca" completa, necesaria para hacer binding (enlaces) en JavaFX.
    public StringProperty marcaProperty() {
        return marca;
    }

    // Devuelve la propiedad "velocidade" completa, también para binding.
    public IntegerProperty velocidadeProperty() {
        return velocidade;
    }

    // Método para aumentar la velocidad del coche en una cantidad específica.
    public void acelerar(int aumento) {
        setVelocidade(getVelocidade() + aumento);
    }
}