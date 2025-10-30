package EjerciciosUnidad1;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class EJ14_Acount {

    private DoubleProperty balance = new SimpleDoubleProperty();

    public final DoubleProperty balanceProperty() {
        return balance;
    }

    public final Double getBalance() {
        return balance.get();
    }

    public final void setBalance(Double balance) {
        this.balance.set(balance);
    }
}
