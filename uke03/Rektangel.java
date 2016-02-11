public class Rektangel extends GeometriskFigur{
    private double hoyde;
    private double bredde;
    public Rektangel(double h, double b){
        hoyde = h;
        bredde = b;
    }

    public double areal(){
        return hoyde*bredde;
    }

}