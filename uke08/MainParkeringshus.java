import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
/*
%% Parkeringshus (stoerrelse)
15

%% Biler (skilt;merke;sitteplasser;parkeringsplass)
AF74944;MitsubishiLancer;3;0
MT54298;AudiA6;5;13
XO11880;BMWX3;2;12
QY93530;NissanSkyline;4;8
LN37882;ToyotaNotYaris;5;5
OU00036;FordDuo;2;4
SO95419;BMW316;3;6

%% Racingsykler (skilt;merke;parkeringsplass)
II45336;RacestyleNX900;14
EB12555;SuzukiYiiha;3
 */

public class MainParkeringshus {
    private static Parkeringshus phus;
    private static Scanner tastatur = new Scanner( System.in );
    
    private static void lagNyBil( String data ) {
        String[] deler = data.split(";");
        String skilt = deler[0];
        String merke = deler[1];
        int sitteplasser = Integer.parseInt( deler[2] );
        int posisjon = Integer.parseInt( deler[3] );
        phus.parkerPaa( new Bil( skilt, merke, sitteplasser), posisjon);
    }

    private static void lagNySykkel( String data ) {
        String[] deler = data.split(";");
        String skilt = deler[0];
        String merke = deler[1];
        int posisjon = Integer.parseInt( deler[2] );
        phus.parkerPaa( new Racingsykkel( skilt, merke), posisjon);
    }
    
    private static boolean lesInnFraFil ( String filnavn ) {
        try {
            Scanner innfil = new Scanner( new File( filnavn ) );
            while ( innfil.hasNextLine() ) {
                String linje = innfil.nextLine();               
                if ( linje.startsWith("%% Parkeringshus") ) {
                    linje = innfil.nextLine();
                    phus = new Parkeringshus( Integer.parseInt( linje ) );
                } else if ( linje.startsWith("%% Biler") ) {
                    while ( innfil.hasNextLine() ) {
                        linje = innfil.nextLine();
                        if ( linje.length() == 0 ) {
                            break;
                        }
                        lagNyBil( linje );
                    }                    
                } else if ( linje.startsWith("%% Racingsykler") ) {
                    while ( innfil.hasNextLine() ) {
                        linje = innfil.nextLine();
                        lagNySykkel( linje );
                    } 
                }
            }
            return true;
            
        } catch ( FileNotFoundException e ) {
            System.out.println("Fant ikke fila");
        }
        return false;
    }

    private static String hentInput( String forklaring ) {
        System.out.print( forklaring + ": " );
        return tastatur.nextLine();
    }

    private static void lagBrukerBil() {
        String merke = hentInput("bilmerke");
        String skilt = hentInput("skilt");
        String spl = hentInput("sitteplass");
        /** LAGT TIL ETTER PLENUM **/
        phus.skrivUtLedigePlasser(); // skriver ut ledige plasser, for a lettere velge bra posisjon
        /** ==END== **/
        String posisjontekst = hentInput("posisjon");
        int posisjon;
        int sitteplasser;
        try {
            posisjon = Integer.parseInt( posisjontekst );
            sitteplasser = Integer.parseInt( spl );
        } catch ( NumberFormatException e ) {
            System.out.println( "possijon eller sitteplass er feil" );
            return;
        }
        System.out.println("plasserer bil paa plass " + posisjon);
        Bil bil = new Bil( skilt, merke, sitteplasser );
        /** LAGT TIL ETTER PLENUM - HOLDER BRUKER IGJEN TIL HAN FINNER GYLDIG PLASS **/
        while ( !phus.parkerPaa( bil, posisjon ) ) {
            // man fikk ikke lagret, spoer bruker om ny posisjon
            phus.skrivUtLedigePlasser();            
            try {
                posisjontekst = hentInput( "Ugyldig plass, proev igjen" );
                posisjon = Integer.parseInt( posisjontekst );
            } catch ( NumberFormatException e ) {
                posisjon = -1; // ugyldig posisjon sikrer loekken gaar igjen
                System.out.print( "Ikke en tallplass - " );
            }
        }
    }

    private static void skrivUtMeny() {
        System.out.println("==Kommandoer===");
        System.out.println("1 - Lag ny bil og parker");
        System.out.println("2 - Skriv ut alt");
    }

    private static void kommandoLoekke() {
        skrivUtMeny();
        String kommando = hentInput( "Kommando" );
        while ( !kommando.equals("q") ) {
            if ( kommando.equals("h") ) {
                skrivUtMeny();
            } else if ( kommando.equals("1") ) {
                lagBrukerBil();
            } else if ( kommando.equals("2") ) {
                phus.skrivUtAlt();
            }
            kommando = hentInput( "Kommando" );
        }
    }

    private static void skrivTilFil( String filnavn ) {
        try {
            PrintWriter utput = new PrintWriter( new File( filnavn ) );
            // System.out.println( phus.hentInfo() );
            /** LAGT TIL ETTER PLENUM **/
            utput.print( phus.hentInfo() );
            utput.close(); // Maa huske aa lukke filen for aa faa skrevet til filen
            /** ==END== **/
        } catch ( FileNotFoundException e ) {
            System.out.println("Fant ikke filen " + filnavn );
        }
    }

    public static void main( String[] args ) {
        String filnavn = "parkeringshus.info";
        if ( lesInnFraFil ( filnavn ) ) {
            kommandoLoekke();
            skrivTilFil( filnavn );
        } else {
            System.out.println("Klarte ikke lese fra fil: " + filnavn);
        }
    }

}