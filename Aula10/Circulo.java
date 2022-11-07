import java.lang.Math;

public class Circulo extends FormaBidimensional{
    private double raio;
    private double diametro;

    public Circulo(double perimetro, double largura, double areaTotal, String nome, double raio, double diametro) {
        super(perimetro, largura, areaTotal, nome);
        this.raio = raio;
        this.diametro = diametro;
    }

    public Circulo(double perimetro, double largura, double areaTotal, String nome, double raio) {
        super(perimetro, largura, areaTotal, nome);
        this.raio = raio;
        this.setDiametro(raio * 2);
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public double getDiametro() {
        return diametro;
    }

    public void setDiametro(double diametro) {
        this.diametro = diametro;
    }

    public void calculaArea(){
        double areaTotal = raio * (Math.pow(Math.PI, 2));
        super.setAreaTotal(areaTotal);
    }

    public void calcularPerimetro(){
        double perimetro = raio * Math.PI * 2;
        super.setPerimetro(perimetro);
    }

    @Override
    public String toString() {
        return  super.toString() +
                "Circulo{" +
                "raio=" + raio +
                ", diametro=" + diametro +
                '}';
    }
}
