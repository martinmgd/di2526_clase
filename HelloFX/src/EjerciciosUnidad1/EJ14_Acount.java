package EjerciciosUnidad1;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class EJ14_Acount {

    // Se crea una propiedad observable "balance" de tipo DoubleProperty.
    // En este caso usamos el constructor de SimpleDoubleProperty con 3 parámetros:
    //  ->  this → el objeto propietario de la propiedad (la instancia de EJ14_Acount).
    //  ->  "balance" → el nombre identificativo de la propiedad (útil para depuración o binding).
    //  ->  100 → el valor inicial del balance (es decir, la cuenta empieza con 100).
    // De este modo, al crear una nueva cuenta (new EJ14_Acount()),
    // el saldo por defecto será 100, y la propiedad ya está identificada y asociada al objeto.
    private DoubleProperty balance = new SimpleDoubleProperty(this, "balance", 100);

    // Método que devuelve la propiedad completa (balanceProperty)
    // Este método se usa cuando queremos hacer binding o añadir listeners.
    // Ejemplo: acc2.balanceProperty().bind(acc1.balanceProperty());
    public final DoubleProperty balanceProperty() {
        return balance;
    }

    // Getter del valor de la propiedad "balance".
    // Devuelve el valor double almacenado en la propiedad.
    // Ejemplo: double valor = acc1.getBalance();
    public final Double getBalance() {
        return balance.get();
    }

    // Setter del valor de la propiedad "balance".
    // Permite asignar un nuevo valor a la propiedad.
    // Ejemplo: acc1.setBalance(2000.0);
    // Si la propiedad está enlazada (bind), este método lanzará una excepción,
    // porque una propiedad enlazada no se puede modificar directamente.
    public final void setBalance(Double balance) {
        this.balance.set(balance);
    }
}
