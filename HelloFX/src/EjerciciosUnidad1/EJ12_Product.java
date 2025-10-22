package EjerciciosUnidad1;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class EJ12_Product {
    private String name;
    private Double price;

    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public EJ12_Product(){
        this.name = "";
        this.price = 0.0;

    }

    public EJ12_Product(String name, Double price){
        this.name = name;
        this.price = price;

    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(Double price){
        this.price = price;
    }

    public Double getPrice(){
        return price;
    }

    public void setPrice(Double newPrice){
        double oldPrice = this.price;
        this.price = newPrice;

        pcs.firePropertyChange("Precio", oldPrice, newPrice);
    }

    public void addPropertyListener(PropertyChangeListener listener){
        pcs.removePropertyChangeListener(listener);
    }

    public String toString(){
    return "name = " + name + ", price = " + price;
    }
}
