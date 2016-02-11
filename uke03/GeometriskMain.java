public class GeometriskMain{
    public static void main(String[] args){
        Kvadrat k = new Kvadrat(4.0);
        Sirkel s = new Sirkel(3.0);
        Trekant t = new Trekant(2.0, 3.0);
        Rektangel r = new Rektangel(7.0, 3.0);

        System.out.println("Figur  --  Areal");
        System.out.format("Kvadrat -- %.3f\n", k.areal());
        System.out.println("Sirkel -- " + s.areal());
        System.out.println("Trekant -- " + t.areal());
        System.out.println("Rektangel -- " + r.areal());

        GeometriskFigur[] figurer = {k, s, t, r};
        double areal = 0.0;
        for(GeometriskFigur f : figurer){
            areal += f.areal();
        }
        System.out.println("Totalt areal: " + areal);
    }

}