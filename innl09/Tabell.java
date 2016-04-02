import java.util.Iterator;

public class Tabell<E> implements AbstraktTabell<E> {
	private E[] tabell;
	private boolean[] ledigPlass;

	public Tabell( int n ) {
		this.tabell = (E[]) new Object[ n ];
		this.ledigPlass = new boolean[ n ];
		// Gjoer alle plassene ledig initielt
		for ( int i=0; i<n; i++ ) {
			ledigPlass[ i ] = true;
		}
	}

	/** AbstraktTabell GRENSESNITTMETODENE **/
	
	public boolean settInn( E e, int indeks ) {
		if ( !gyldigIndeks( indeks ) || !ledigPlass[ indeks ] ) {
			// Indeksen er feil eller plassen er ikke ledig
			return false; // _ikke_ vellykket innsettelse
		}
		tabell[ indeks ] = e;
		ledigPlass[ indeks ] = false;
		return true; // vellykket innsettelse
	}

	public E hent( int indeks ) {
		if ( gyldigIndeks( indeks ) ) {
			// henter elementet paa gitt posisjon
			// om det ikke er noe der er det nullpeker
			return tabell[ indeks ];
		}
		// ikke gyldig indeks
		return null;
	}

	public TabellIterator iterator() {
		return new TabellIterator();
	}

	/** PUBLIC HJELPEMETODER **/
	public void skrivUtLedige() {
		System.out.print("Ledige indekser: ");
		for (int i=0; i<tabell.length; i++) {
			if ( ledigPlass[ i ] ) {
				System.out.format("%d, ", i );
			}
		}
		System.out.println();
	}
	
	/** PRIVATE HJELPEMETODER **/

	private boolean gyldigIndeks( int indeks ) {
		/* Passer paa at indeksen er gyldig
		 * 0 <= indeks < n */
		return ( 0 <= indeks && indeks < tabell.length );
	}

	/** INDRE KLASSER **/

	private class TabellIterator implements Iterator<E> {
		private int teller = 0;

		public boolean hasNext() {
			while ( teller < tabell.length ) {
				if ( !ledigPlass[ teller ] ) {
					break;
				}
				teller++;
			}
			if ( teller < tabell.length ) { // telleren stoppet foer enden
				return true;
			}
			// telleren gikk til slutten, ingen flere elementer
			return false;
		}

		public E next() {
			teller++; // oeker for aa sikre at hasNext() sjekker fra neste
			return tabell[teller - 1]; // bruker -1 for aa hente "forrige"
		}

		public void remove() {
			// NADA
		}
	}
	
}
