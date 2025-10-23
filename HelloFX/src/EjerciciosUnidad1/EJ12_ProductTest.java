package EjerciciosUnidad1;

import java.beans.PropertyChangeEvent;

public class EJ12_ProductTest {
    public static void main(String[] args) {
     
        final EJ12_Product p1 = new EJ12_Product("Coche", 30000.0);
            
        porcentajeDesconto(p1.getPrice());

        p1.addPropertyListener(EJ12_ProductTest::handlePropertyChange);  

        p1.setPrice(20000.00);
        p1.setPrice(18000.00);
        p1.setPrice(15000.00);
    
    }

    public static void handlePropertyChange(PropertyChangeEvent e) {
        String propertyPrice = e.getPropertyName();

        if ("Precio".equals(propertyPrice)){
            System.out.print("O precio cambiou. ");
            System.out.print("Anterior: " + e.getOldValue());
            System.out.println(", Novo: " + e.getNewValue());
            porcentajeDesconto((Double)e.getNewValue());
        } 
    }

    public static void porcentajeDesconto(double price){
        final double porcentajeDesconto = 20.0;
        double desconto = price * porcentajeDesconto / 100;
        System.out.println("Precio: " + price + ", Desconto: " + desconto);
    }
}
