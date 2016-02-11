public class BygningMain{
    public static void main(String[] args){
        Skyskraper s = new Skyskraper(100.0, 5);
        if(s instanceof Bygning){
            Bygning b = (Bygning) s;
            System.out.println("Casting Skyskraper -> Bygning vellykket");
        }

        Bygning b2 = new Bygning(50.0);
        if(b2 instanceof Skyskraper){
            Skyskraper s2 = (Skyskraper) b2;
            System.out.println("Casting Bygning -> Skyskraper vellykket");
        }

        Skyskraper s3 = new Skyskraper(200.0, 6);
        Bygning b3 = (Bygning) s3;
        Skyskraper s4 = (Skyskraper) b3;

        
    }
}
