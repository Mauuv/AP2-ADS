import java.lang.Math;

public class Esfera extends FormaTridimensional{
    private double raio;

    public void calculaArea(){
        double areaTotal = 4 * Math.PI * Math.pow(raio, 2);
        super.setAreaTotal(areaTotal);
    }

    public void calculaVolume(){
        double volume = 4/3 * Math.PI * Math.pow(raio, 2);
        super.setVolume(volume);
    }

    public Esfera(double volume, double qtLados, double areaTotal, String nome, double raio) {
        super(volume, qtLados, areaTotal, nome);
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "Esfera{" +
                "raio=" + raio +
                '}';
    }
}
