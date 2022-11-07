public class Tetraedro extends FormaTridimensional{
    // SOMENTES TETRAEDROS REGULARES
    private double lado;

    public Tetraedro(double volume, double qtLados, double areaTotal, String nome, double lado) {
        super(volume, qtLados, areaTotal, nome);
        this.lado = lado;
    }

    public void calcularArea(){
        double areaTotal = Math.sqrt(3) * (lado * lado);
        super.setAreaTotal(areaTotal);
    }

    public void calcularVolume(){
        double volume = Math.pow(lado, 3) * Math.sqrt(2)/12;
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
                "Tetraedro{" +
                "lado=" + lado +
                '}';
    }
}
