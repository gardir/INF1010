public class Bygning{
    protected double bruttoAreal;
    public Bygning(double brA){
        bruttoAreal = brA;
    }

    public String toString() {
        return String.format("Bygning med %.3f areal", bruttoAreal);
    }
}