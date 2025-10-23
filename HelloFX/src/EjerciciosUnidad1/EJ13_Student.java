package EjerciciosUnidad1;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EJ13_Student {
    private ReadOnlyStringWrapper id = new ReadOnlyStringWrapper(this, "id", "Unknown");
    private StringProperty nome = new SimpleStringProperty(this, "nome", "Unknown");
    private DoubleProperty promedio = new SimpleDoubleProperty(this, "promedio", 0.0); 

    public EJ13_Student(){
    }

    public EJ13_Student(String id, String nome, double promedio){
        this.id.set(id);
        this.nome.set(nome);
        this.promedio.set(promedio);
    }

    public final String getId(){
        return id.get();
    }

    public final ReadOnlyStringProperty idProperty() {
        return id.getReadOnlyProperty();
    }

    public final String getNome(){
        return nome.get();
    }

    public final void setNome(String nome){
        this.nome.set(nome);
    }

    public final StringProperty nomeProperty() {
        return nome;
    }

    public final Double getPromedio(){
        return promedio.get();
    }

    public final void setPromedio(Double promedio){
        this.promedio.set(promedio);
    }

    public final DoubleProperty promedioProperty() {
        return promedio;
    }
}
