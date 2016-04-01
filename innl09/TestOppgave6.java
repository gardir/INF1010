import java.util.Iterator;

public class TestOppgave6 {

    /** TEST METODEN **/
    private static boolean test( boolean faktisk, boolean forventet, String forklaring ) {
        System.out.print( "Tester " + forklaring + ": " );
        if ( faktisk == forventet ) {
            System.out.println("Passerte");
            return true;
        }
        // Implisitt else {
        System.out.println("Feilet");
        System.out.println("Fikk " + faktisk + ", men forventet " + forventet);
        return false;
    }

    /** TABELL TEST **/
    private static void testTabell() {
        System.out.println("=== Tester Tabell START ===");
            
        // Setup
        int n = 10;
        Tabell<String> tabell = new Tabell<String>( n );

        // Test #1
        String forklaring = "negativ og paa grensen stor indeks";
        test( tabell.settInn( "minus", -1 ) || tabell.settInn( "n", n ), false, forklaring );

        // Test #2
        forklaring = "innsettelse av element";
        test( tabell.settInn( "midten", n/2 ), true, forklaring );

        // Test #3
        forklaring = "henting av samme element";
        test( tabell.hent( n/2 ).equals( "midten" ), true, forklaring );

        // Test #4
        forklaring = "henting av element paa ledig plass er null";
        test( tabell.hent( 0 ) != null, false, forklaring );

        // Test #5
        forklaring = "et element fra iteratoren";
        Iterator iterator = tabell.iterator();
        while ( iterator.hasNext() ) {
            test(iterator.next().equals("midten"), true, forklaring );
        }
                
        System.out.println("=== Tester Tabell SLUTT ===");
		
    }

    /** SORTERTENKELLISTE TEST **/
    private static void testSortertEnkelListe() {
        System.out.println("=== Tester SortertEnkelListe START ===");
            
        SortertEnkelListe<Lege> liste = new SortertEnkelListe<Lege>();

        // Test #1
        liste.settInn( new Lege( "beta" ) );
        liste.settInn( new Lege( "alpha" ) );
        liste.settInn( new Lege( "charlie" ) );
        Iterator<Lege> iterator = liste.iterator();
        System.out.println("Tester stigende rekkefølge: ");
        String foerste = iterator.next().hentNavn();
        while ( iterator.hasNext()  ) {
            String neste = iterator.next().hentNavn();
            test( foerste.compareTo( neste ) <= 0, true, String.format("%s < %s", foerste, neste ) );
            foerste = neste;
        }
                
        System.out.println("=== Tester SortertEnkelListe SLUTT ===");
    }

    /** YNGSTEFORSTRESEPTLISTE TEST **/
    private static void testYngsteForstReseptListe( Resept[] resepter ) {           
        System.out.println("=== Tester YngsteForstReseptListe START ===");
        YngsteForstReseptListe liste = new YngsteForstReseptListe();
        for ( Resept r: resepter ) {
            liste.settInn( r );
        }

        Iterator<Resept> iter = liste.iterator();
        int foerste = iter.next().hentNummer();
        while ( iter.hasNext() ) {
            int neste = iter.next().hentNummer();
            test( foerste >= neste, true, String.format( "%d >= %d", foerste, neste ) );
            foerste = neste;
        }
                
        System.out.println("=== Tester YngsteForstReseptListe SLUTT ===");
    }

    /** ELDSTEFORSTRESEPTLISTE TEST **/
    private static void testEldsteForstReseptListe( Resept[] resepter ) {
        System.out.println("=== Tester EldsteForstReseptListe START ===");
        
        EldsteForstReseptListe liste = new EldsteForstReseptListe();
        for ( Resept r: resepter ) {
            liste.settInn( r );
        }
		
        Iterator<Resept> iter = liste.iterator();
        int foerste = iter.next().hentNummer();
        while ( iter.hasNext() ) {
            int neste = iter.next().hentNummer();
            test( foerste <= neste, true, String.format( "%d <= %d", foerste, neste ) );
            foerste = neste;
        }
        
        System.out.println("=== Tester YngsteForstReseptListe SLUTT ===");

    }

    /** RESEPT DATA LAGING **/
    private static Resept[] lagResepter() {
        Resept[] resepter = new Resept[3];
        Lege gard = new Lege("Dr. Rosvold");
        Pasient per = new Pasient("Per Ove Nest", "14036684352", "Ingensteds 4", 0130);
        Pasient lise = new Pasient("Lise Oventun", "06079244845", "Ovenpaa 5", 1299);
        int i = 0;
        resepter[i++] = new HvitResept(
            new FlytendeLegemiddelTypeC("Nasanex", 99.00, 45, 0.10),
            gard.hentNavn(), per.hentNavn(), 3);
        resepter[i++] = new BlaaResept(
            new PilleLegemiddelTypeB("Illidan Forte", 249.99, 30, 0.22, 5),
            gard.hentNavn(), lise.hentNavn(), 2);
        resepter[i++] = new HvitResept(
            new FlytendeLegemiddelTypeB("No-more-allergy", 149.9, 70, 0.15, 40),
            gard.hentNavn(), per.hentNavn(), 4);
        return resepter;
    }

    /** MAIN **/
    public static void main(String[] args) {
        Resept[] resepter = lagResepter();
		
        // Test av Tabell
        testTabell();

        // Test av SortertEnkelListe
        testSortertEnkelListe();

        // Test av YngsteForstReseptListe
        testYngsteForstReseptListe( resepter );

        // Test av EldsteForstReseptListe
        testEldsteForstReseptListe( resepter );
    }
	
}
