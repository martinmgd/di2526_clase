package EjerciciosUnidad1;

import javafx.beans.property.ReadOnlyProperty;

public class EJ13_StudentTest {

    public static void main(String[] args) {
        EJ13_Student estudiante = new EJ13_Student("DAM1", "Pablo José", 8.0);

        System.out.println("Despues de crear el objeto estudiante...");

        // Imprimir detalles das propiedades
        printDetails(estudiante.idProperty());
        printDetails(estudiante.nomeProperty());
        printDetails(estudiante.promedioProperty());

        // Cambiar as propiedades do libro
        estudiante.setNome("Sujeiri Sulin");
        estudiante.setPromedio (9.49);

        System.out.println("\nDespues de cambiar las propiedades del estudiante...");

        // Imprimir detalles das propiedades
        printDetails(estudiante.idProperty());
        printDetails(estudiante.nomeProperty());
        printDetails(estudiante.promedioProperty());
    }

        public static void printDetails(ReadOnlyProperty<?> p) {
        String name = p.getName();
        Object value = p.getValue();
        Object bean = p.getBean();
        String beanClassName = (bean == null) ? "null" : bean.getClass().getSimpleName();
        String propClassName = p.getClass().getSimpleName();

        System.out.print(propClassName);
        System.out.print("[Name: " + name);
        System.out.print(", Bean Class: " + beanClassName);
        System.out.println(", Value: " + value + "]");
    }
}
