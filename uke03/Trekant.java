public class Trekant extends GeometriskFigur{
    private double hoyde;
    private double bredde;
    public Trekant(double h, double b){
        hoyde = h;
        bredde = b;
    }

    public double areal(){
        return 0.5*hoyde*bredde;
    }

}