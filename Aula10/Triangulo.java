public class Triangulo extends FormaBidimensional{
    private double altura;
    private double base;
    private double lado1;
    private double lado2;
    private String tipo;

    public Triangulo(double perimetro, double largura, double areaTotal, String nome, double base, double lado1, double lado2) {
        super(perimetro, largura, areaTotal, nome);
        this.base = base;
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    public Triangulo(double perimetro, double largura, double areaTotal, String nome, double altura, double base, String tipo) {
        super(perimetro, largura, areaTotal, nome);
        this.altura = altura;
        this.base = base;
        this.tipo = tipo;
    }

    public Triangulo(double perimetro, double largura, double areaTotal, String nome, double altura, double base) {
        super(perimetro, largura, areaTotal, nome);
        this.altura = altura;
        this.base = base;
    }

    public void calculaArea(){
        double areaTotal = (base * altura) / 2;
        super.setAreaTotal(areaTotal);
    }

    public void calcularPerimetro(){
        double perimetro = base + lado1 + lado2;
        super.setPerimetro(perimetro);
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "Triangulo{" +
                "altura=" + altura +
                ", base=" + base +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
