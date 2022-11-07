public class FormaBidimensional extends Forma{

    protected double perimetro;

    public FormaBidimensional(double perimetro, double largura, double areaTotal, String nome) {
        super(nome, areaTotal);
        this.perimetro = perimetro;
    }

    public double getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(double perimetro) {
        this.perimetro = perimetro;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "FormaBidimensional{" +
                "perimetro=" + perimetro +
                '}';
    }
}
