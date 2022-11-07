public class FormaTridimensional extends Forma{
    protected double volume;
    protected double qtLados;

    public FormaTridimensional(double volume, double qtLados, double areaTotal, String nome) {
        super(nome, areaTotal);
        this.volume = volume;
        this.qtLados = qtLados;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getQtLados() {
        return qtLados;
    }

    public void setQtLados(double qtLados) {
        this.qtLados = qtLados;
    }

    //public void setAreaTotal(double areaTotal){
        //super.setAreaTotal(areaTotal);
    //}

    @Override
    public String toString() {
        return  super.toString() +
                "FormaTridimensional{" +
                "volume=" + volume +
                ", qtLados=" + qtLados +
                '}';
    }
}
