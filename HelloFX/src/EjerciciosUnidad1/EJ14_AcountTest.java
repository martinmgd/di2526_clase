package EjerciciosUnidad1;

public class EJ14_AcountTest {
public static void main(String[] args) {

    // Se crean dos objetos de tipo EJ14_Acount.
    // Cada objeto tiene una propiedad observable llamada "balance" (DoubleProperty),
    // que permite detectar y reaccionar ante cambios en su valor.
    EJ14_Acount acc1 = new EJ14_Acount();
    EJ14_Acount acc2 = new EJ14_Acount();

    // Se establece el balance inicial de la primera cuenta en 2000.0
    acc1.setBalance(2000.0);

    // Se vincula (bind) la propiedad "balance" de acc2 con la de acc1.
    // Esto significa que acc2.balance "depende" de acc1.balance.
    // Si cambia el balance de acc1, automáticamente se actualizará el de acc2.
    // La relación es unidireccional: acc1 -> acc2 (cambiar acc2 NO afecta a acc1).
    acc2.balanceProperty().bind(acc1.balanceProperty());

    // Se muestran los balances actuales de ambas cuentas.
    // Ambos mostrarán 2000.0 porque acc2 está enlazado a acc1.
    System.out.println("Balance acc1: " + acc1.getBalance());
    System.out.println("Balance acc2: " + acc2.getBalance());

    // Se añade un InvalidationListener a la propiedad "balance" de acc2.
    // Este tipo de listener se ejecuta cuando la propiedad cambia de estado (es "invalidada"),
    // pero NO da información sobre el valor anterior ni el nuevo.
    acc2.balanceProperty().addListener(i -> {
        System.out.println("Ha sido invalidada");
    });

    // Se añade un ChangeListener a la propiedad "balance" de acc2.
    // Este listener se ejecuta cuando el valor cambia y proporciona:
    //  - observable: la propiedad que cambió.
    //  - oldValue: el valor anterior.
    //  - newValue: el nuevo valor.
    acc2.balanceProperty().addListener((observable, oldValue, newValue) -> {
        System.out.println("La propiedad ha cambiado");
        System.out.println("valor antiguo: " + oldValue);
        System.out.println("valor nuevo: " + newValue);
    });

    // Se cambia el balance de acc1 a 1500.0.
    // Como acc2 está vinculado a acc1, su balance también cambia automáticamente a 1500.0.
    // Esto dispara ambos listeners:
    //   - Primero el InvalidationListener ("Ha sido invalidada")
    //   - Luego el ChangeListener con los valores antiguo y nuevo.
    acc1.setBalance(1500.0);

    // Se obtiene el balance de acc2 (aunque no se imprime).
    // El valor actual será 1500.0.
    acc2.getBalance();

    // Se vuelve a cambiar el balance de acc1, ahora a 9009.0.
    // De nuevo, acc2 se actualiza automáticamente, y los listeners vuelven a ejecutarse.
    acc1.setBalance(9009.0);

    // Se obtiene otra vez el balance de acc2 (actualmente 9009.0).
    acc2.getBalance();
    }
}
