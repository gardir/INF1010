public class Sirkel extends GeometriskFigur{
    private double radius;
    public Sirkel(double r){
        radius = r;
        type = "Sirkel";
    }

    public double areal(){
        return Math.PI*radius*radius;
    }

}