class Beholder {
    private Node forste;

    interface Slettbar {}

    // Antar at "utenfor" betyr utenfor  beholderen ikke noden
    private static class Node {
        Object verdi;
        Node neste;

        Node(Object verdi) {
            this.verdi = verdi;
        }

        Node fjernSlettbareNoderBakerst() {
            if (neste == null) {
                if (verdi instanceof Slettbar) {
                    return null;
                } else {
                    return this;
                }
            }
            neste = neste.fjernSlettbareNoderBakerst();
            if (neste == null && verdi instanceof Slettbar) {
                return null;
            } else {
                return this;
            }

        }
    }

    public void settInn(Object o) {
        if (forste == null) {
            forste = new Node(o);
            return;
        }

        Node peker = forste;
        hentePeker = forste;
        while (true) {
            if (o.equals(peker.verdi)) {
                return;
            }

            if (peker.neste == null) {
                peker.neste = new Node(o);
                return;
            }
            peker = peker.neste;
        }
    }

    public void fjern(Object o) {
        if (forste == null) {
            return;
        }

        if (forste.verdi.equals(o)) {
            forste = forste.neste;
            hentePeker = forste;
            return;
        }

        Node peker = forste;
        hentePeker = forste;

        while (peker.neste != null) {
            if (peker.neste.verdi.equals(o)) {
                peker.neste = peker.neste.neste;
                return;
            }
        }
    }

    // Antar at hent() blir nullstilt hver gang vi endrer lista
    private Node hentePeker;
    public Object hent() {
        if (hentePeker == null) {
            return null;
        }
        
        Object ret = hentePeker.verdi;
        hentePeker = hentePeker.neste;
        return ret;
    }

    
    // Oppgave 4
    public void ovfAlleFraBeholder( Beholder b ) {
        while( true ) {
            Object ny = b.hent();
            if ( ny == null ) {
                return;
            }
            settInn( ny );
            b.fjern( ny );
        }
    }
    
    // Oppgave 8

    public boolean identiske( Beholder b ) {
        while( true ) {
            Object min = this.hent();
            Object bsin = b.hent();
            if ( min != bsin) {
                return false;
            }
            if ( min == null ) {
                break; // return true;
            }
        }
        return true;
    }
}

