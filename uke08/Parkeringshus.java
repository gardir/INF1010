public class Parkeringshus {
    private Kjoeretoy[] parkeringsplasser;

    public Parkeringshus( int plasser ) {
        parkeringsplasser = new Kjoeretoy[ plasser ];
    }

    private boolean gyldigPosisjon( int posisjon ) {
        return 0 <= posisjon && posisjon < parkeringsplasser.length;
    }

    private boolean ledigPlass( int posisjon ) {
        return parkeringsplasser[ posisjon] == null;
    }

    public boolean parkerPaa( Kjoeretoy kjoretoyet, int posisjon ) {
        if ( gyldigPosisjon( posisjon ) && ledigPlass( posisjon) ) {
            parkeringsplasser[ posisjon ] = kjoretoyet;
            return true;
        } else {
            return false;
        }
    }

    public Kjoeretoy hentKjoeretoy ( int posisjon ) {
        if ( gyldigPosisjon( posisjon ) ) {
            return parkeringsplasser[ posisjon ];
        }
        return null;
    }


    public void skrivUtAlt() {
        for ( Kjoeretoy k : parkeringsplasser ) {
            if ( k != null ) {
                k.skrivUtInfo();
            }
        }
    }

    public String hentInfo() {
        String resultat = "%% Parkeringshus (stoerrelse)\n";
        resultat += String.format( "%d\n", parkeringsplasser.length); // fjernet en \n her, for å få sammenstilt siste return-kode
        String biler = "%% Biler (skilt;merke;sitteplasser;parkeringsplass)\n";       
        String racingsykler = "%% Racingsykler(skilt;merke;parkeringsplass)\n";
        for (int i=0; i<parkeringsplasser.length; i++ ) {
            Kjoeretoy k = parkeringsplasser[ i ];
            if ( k != null ) {
                if ( k instanceof Bil ) {
                    biler += ((Bil)k).hentInfo() + ";" + i + "\n";
                }
                /** LAGT TIL ETTER PLENUM **/
                else if ( k instanceof Racingsykkel ) {
                    racingsykler += ((Racingsykkel)k).hentInfo() + ";" + i + "\n";
                }
                /** ==END== **/
            }
            
        }
        return resultat + "\n" + biler + "\n" + racingsykler; // lagt til \n som er newline (linjeskift)
    }

    /** LAGT TIL ETTER PLENUM **/
    public void skrivUtLedigePlasser() {
        System.out.print("Ledige plasser: ");
        for ( int i=0; i<parkeringsplasser.length; i++ ) {
            if ( ledigPlass( i ) ) {
                System.out.print( i + "," );
            }
        }
        System.out.println(); // newline
    }

}

/* FILFORMATET
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