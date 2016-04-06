import java.util.Scanner;

public class IOTips {    
    // stdin er 'standardnavn' for input fra terminal i den virkelige verden
    private static Scanner stdin = new Scanner( System.in ); 
    
/** Hjelpemetoder for utskrift **/ 

    /**
     * Skriver 'ut' til terminal, uten newline
     * Er public saa andre klasser kan si 
     * IOTips.print( "hei!" ); 
     * Det er jo det static er til - klassemetoder
     */
    public static void print( String ut ) {
        System.out.print( ut );
    }
    /**
     * Skriver 'ut' til terminal, med newline
     * Er public saa andre klasser kan si 
     * IOTips.println( "hei!" ); 
     * Det er jo det static er til - klassemetoder
     */
    public static void println( String ut ) {
        System.out.println( ut );
    }

/** Hjelpemetoder for input **/

    /**
     * Skriver ut info og gir tilbake brukerens input
     *
     * @param forklaring er hva som skal skrives ut
     * @return det brukeren tastet inn
     */
    private static String fraBruker( String forklaring ) {
        print( forklaring + ": " ); // skriver ut 'info' (forklaring) av hva som forventes av bruker med ': ' for aa skille
        return stdin.nextLine(); // gir tilbake det brukeren skrev som 'String'
    }
    
    /**
     * Konverterer data til int
     * Gir tilbake maks negativ verdi ved feil sammen med en tekst om at det gikk galt
     *
     * @param data er det som skal bli int
     * @return det som er konvertert, eller maks negativ ved feil input
     */
    private static int parseInt( String data ) {
        try {
            return Integer.parseInt( data );
        } catch ( NumberFormatException e ) {
            println( "Kunne ikke konvertere '" + data + "' til int." );
        }
        return Integer.MIN_VALUE; // standard feilverdi, aller minste mulige tall
    }
    
    /** 
     * Konverterer til int stoerre enn minsteverdi
     * Hvis brukeren har tastet ( og taster videre ) for lite
     * tall, spoer programmet om nytt tall med info om grenseverdi.
     *
     * @param data er det som skal bli int
     * @param minsteVerdi er den laveste aksepterte verdien
     * @return en gyldig int verdi mindre enn minsteVerdi
     */
    private static int parseInt( String data, int minsteVerdi ) {
        int verdi = parseInt( data );
        while ( verdi < minsteVerdi ) {
            verdi = parseInt( fraBruker( verdi + " er for lav verdi (<" + minsteVerdi + "), proev igjen" ) );
        }
        return verdi;
    }
    
    /** 
     * Konverterer til int stoerre enn minsteverdi
     * Hvis brukeren har tastet ( og taster videre ) for lite
     * tall, spoer programmet om nytt tall med info om grenseverdi.
     *
     * @param data er det som skal bli int
     * @param minsteVerdi er den laveste aksepterte verdien
     * @param maksVerdi er den stoerste aksepterte verdien
     * @return en gyldig int verdi mindre enn minsteVerdi
     */
    private static int parseInt( String data, int minsteVerdi, int maksVerdi ) {
        int verdi = parseInt( data );
        while ( verdi < minsteVerdi || verdi > maksVerdi ) {
            verdi = parseInt( 

                             /*
                               Koden under er ekvivalent til new String delen over - proev selv!
                               fraBruker( String.format("Tallet %d er ikke i intervallet [%d,%d], proev igjen",
                                          verdi, minsteVerdi, maksVerdi ) )
                             */
                             fraBruker( 
                                       new String("Tallet '" + verdi + 
                                                  "' er ikke i intervallet [" + minsteVerdi + "," + maksVerdi + "], proev igjen" )
                                        )
                              );
        }
        return verdi;
    }


/** Main metoden **/

    /** 
     * Main metoden viser programmets funksjoner
     */
    public static void main( String[] args ) {
        Scanner stdin = new Scanner( System.in );
        System.out.print("Hva vil du si: ");
        String fraBruker = stdin.nextLine();
        System.out.println("Fra bruker: " + fraBruker );

        // Dette var tungvint, er ikke det under bedre?

        String fraBruker2 = fraBruker( "Hva vil du si" );
        println( "Fra bruker: " + fraBruker2 );

        // Spesielt naar man skal gjoer det flere ganger
        int yndlingstall = parseInt( fraBruker( "Ditt yndlingstall" ) );
        println( "Yndlingstallet ditt er altsaa: " + yndlingstall );
        int positiv = parseInt( fraBruker( "Et positivt tall" ), 1 );
        int alder = parseInt( fraBruker( "Din alder" ), 16, 120 );
        println( "Hvis du fikk feilmelding er det fordi jeg antar alle som kjoerer dette er over 16 aar (og under 120), noe du til slutt var med " + alder );

        // Hvis dere vil kan dere jo proeve aa skrive koden over paa 'tradisjonell' maate :)


        // Denne viser lagring av variabel _i_ if-testen - klarer du aa forstaa hva som skjer?
        // Hint: Se paa parentesene, og tenk hva som blir brukt
        String pw1 = "1234";
        String pw2 = "123";
        do {
            String gjettet;
            if ( ( gjettet = fraBruker("Gjett pw")).equals( pw1 ) || gjettet.equals( pw2 ) ) {
                println( "Du er jaggu flink" );
                break;
            } else {
                println( "Du er jaggu daarlig, proev igjen!" );
            }
        } while ( true ); // dette er stygt - men vi breaker jo og trenger derfor ikke aa teste paa noe. kunne gjort det ogsaa (bedre praksis)

    }

/** Litt juksing, men dette er main fra innleveringsoppgaven vist **/

    /**
     * MAIN METODE
     *
     * Leser foerst inn fra fil
     * Hvis vellykket starter den ordreloekken
     * Foer den avslutter med aa skrive til fil igjen.
     * Hvis filnavn ikke er angitt i args spoer den bruker.
     */
    // maa vaere kommentert ut for aa kompilere og kjoere
    /*
    public static void mainOppgave7( String[] args ) {
        String filnavn;
        if ( args.length > 0 ) {
            filnavn = args[0];
        } else {
            filnavn = fraBruker( "Filnavn" );
        }
		
        if ( lesFraFil( filnavn ) ) { // vellykket ved true
            ordreloekke(); // hent input fra bruker
            skrivTilFil( filnavn ); // 'auto-save' i tilfelle bruker ikke har gjort det
        } else { // lesFraFil feilet, vil stoppe programmet og si hvilken fil som failet
            System.out.format( "Innlesing av '%s' failet, avslutter.\n", filnavn );
        }
    }
    */
}