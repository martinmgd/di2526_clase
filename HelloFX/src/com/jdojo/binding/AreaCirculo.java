package com.jdojo.binding;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class AreaCirculo {
        public static void main(String[] args) throws Exception {
        DoubleProperty radius = new SimpleDoubleProperty(10.0);

        // Creamos un DoubleBinding que calcula a área.
        // Observa como se encadean os métodos .multiply().
        DoubleBinding area = radius.multiply(radius).multiply(Math.PI);

        System.out.println("Primer resultado.");
        System.out.println("Radio = " + radius.get() + ", Área = " + area.get());
        

        // Cando cambiamos o radio, a 'area' actualízase automaticamente.
        System.out.println("Resultado despues de cambiar el radio.");
        radius.set(14.0);
        System.out.println("Radio = " + radius.get() + ", Área = " + area.get());
    }
}
