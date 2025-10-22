package EjerciciosUnidad1;

public class EJ11 {
    public static void main(String[] args) {
        EJ11_Coche coche = new EJ11_Coche();

        coche.setMarca("Ford");
        coche.getMarca();
        System.out.println("La marca del coche es: " + coche.getMarca());

        coche.setVelocidade(50);
        coche.acelerar(20);
        System.out.println("La velocidad final es: " + coche.getVelocidade());
    }
}
