public class Quadrado extends FormaBidimensional{
    private double lado;

    public Quadrado(double perimetro, double largura, double areaTotal, String nome, double lado) {
        super(perimetro, largura, areaTotal, nome);
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    public void calculaArea(){
        double areaTotal = lado * lado;
        super.setAreaTotal(areaTotal);
    }

    public void calcularPerimetro(){
        double perimetro = lado * 4;
        super.setPerimetro(perimetro);
    }

    @Override
    public String toString() {
        return  super.toString() +
                "Quadrado{" +
                "lado=" + lado +
                '}';
    }
}
