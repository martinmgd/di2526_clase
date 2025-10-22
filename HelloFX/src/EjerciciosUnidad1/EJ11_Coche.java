package EjerciciosUnidad1;

public class EJ11_Coche {
    private String marca;
    private int velocidade;

    
    public void setMarca(String marca){
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }
    
    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void acelerar(int aumento){
        velocidade = velocidade + aumento;
    }
}
