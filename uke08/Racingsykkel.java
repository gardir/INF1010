public class Racingsykkel extends Kjoeretoy {
    public Racingsykkel( String skilt, String merke ) {
        super( skilt, merke, 1 );
    }
    
    public void skrivUtInfo() {
        System.out.println( skilt + ": Er en racingsykkel av type "
                            + merke );
    }    
    
    public String hentInfo() {
        return String.format( "%s;%s", skilt, merke );
    }
}
