class Monitor {
    Beholder bmb;
    int aktiveTraader = 0;

    // Antar Beholder har en metode "storrelse" som henter storrelsen
    public Monitor( Beholder bmb ) {  
        this.bmb = bmb;
        aktiveTraader = bmb.storrelse() / 2 
            + (bmb.storrelse() % 2)); // REST
        for ( int i=0; i<bmb.storrelse(); i++) {
            (new Thread( new BeholderTraad( this ) ) ).start();
        }
    }
    
    public synchronized boolean giFraSeg( Object beholder ) {        
        bmb.settInn( beholder );
        if ( aktiveTraader == 1 ) {
            System.out.println("Done!");
        }
        else if ( aktiveTraader % 2 == 0 ) {
            aktiveTraader--;
            return false;
        }
        return true;
    }
    
    public synchronized Beholder hentBeholder() {
        Beholder b = bmb.hent();
        bmb.fjern(b);
        return b;
    }
}

class BeholderTraad implements Runnable {
    Monitor mon;

    BeholderTraad( Monitor mon) {
        this.mon = mon;
    }
    
    public void run() {
        Beholder beholderA;
        do {
            beholderA = (Beholder) mon.hentBeholder();
            Object beholderB = (Beholder) mon.hentBeholder();
            beholderA.ovfAlleFraBeholder( beholderB );
        } while ( mon.giFraSeg( beholderA );
    }
    
}