public class UrteMain {
    public static void main(String[] args) {
        Bed bedet = new Bed();
        bedet.plantNy(new Urt("timian"));
        bedet.plantNy(new Urt("persille"));
        bedet.plantNy(new Urt("dill"));
        Urt urten =        new Urt("koriander");
        bedet.plantNy(urten);
        
        System.out.println(urten.toString());

        BedGenerisk<Urt> genbed = new BedGenerisk<Urt>();
        genbed.plantNy(urten);
        System.out.println(genbed.fjernElement("koriander"));
    }
}