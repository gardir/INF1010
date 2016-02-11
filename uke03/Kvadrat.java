public class Kvadrat extends GeometriskFigur{
    private double lengde;
    public Kvadrat(double l){
        lengde = l;
    }

    public double areal(){
        return lengde*lengde;
    }

}