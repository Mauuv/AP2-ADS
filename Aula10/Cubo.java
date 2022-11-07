public class Cubo extends FormaTridimensional{
    private double lado;

    public Cubo(double volume, double qtLados, double areaTotal, String nome, double lado) {
        super(volume, qtLados, areaTotal, nome);
        this.lado = lado;
    }

    public void calcularArea(){
        double areaTotal = 6 * (lado * lado);
        super.setAreaTotal(areaTotal);
    }

    public void calcularVolume(){
        double volume = Math.pow(lado, 3);
        super.setVolume(volume);
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "Cubo{" +
                "lado=" + lado +
                '}';
    }
}
