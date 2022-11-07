public class Forma {

    protected String nome;
    protected double areaTotal;

    public Forma(String nome, double areaTotal) {
        this.nome = nome;
        this.areaTotal = areaTotal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getAreaTotal() {
        return areaTotal;
    }

    public void setAreaTotal(double areaTotal) {
        this.areaTotal = areaTotal;
    }

    @Override
    public String toString() {
        return "Forma{" +
                "nome='" + nome + '\'' +
                ", areaTotal=" + areaTotal +
                '}';
    }
}