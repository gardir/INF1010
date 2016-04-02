import java.util.Iterator;

public class SortertEnkelListe<E extends Comparable<E> & Lik>
	implements AbstraktSortertEnkelListe<E> {
	
	private Node hode;
	private boolean erTom = true;
	
	/** GRENSESNITTET AbstraktSortertEnkelListe METODER **/

	public void settInn( E e ) {
		// Setup
		Node nyNode = new Node( e );

		if ( erTom ) {
			hode = nyNode;
			erTom = false;
			return; // stopper metoden her
		}
		else if ( e.compareTo( hode.data ) < 0 ) {
			// nye elementet er mindre enn hode, skal foerst
			nyNode.neste = hode;
			hode = nyNode;
			return;
		}

		Node forrige = hode,
			aktuelle = hode.neste;
		while ( aktuelle != null && e.compareTo( aktuelle.data ) > 0 ) {
			forrige = forrige.neste;
			aktuelle = aktuelle.neste;
		}

		// sett inn element etter forrige, foer aktuelle
		forrige.neste = nyNode;
		nyNode.neste = aktuelle;
		
	}

	public E hent( String noekkel ) {
		// Setup
		Node itererNode = hode;

		while ( itererNode != null ) {
			if ( itererNode.data.samme( noekkel ) ) {
				// fant data lik noekkel
				return itererNode.data;
			}
			itererNode = itererNode.neste;
		}

		// fant ikke data lik noekkel
		return null;
	}

	public Iterator<E> iterator() {
		return new ListeIterator();
	}
	
	/** INDRE KLASSER **/

	private class Node {
		Node neste;
		E data;

		Node( E data ) {
			this.data = data;
		}
	}

	private class ListeIterator implements Iterator<E> {
		Node aktuell = hode;

		public boolean hasNext() {
			return aktuell != null;
		}

		public E next() {
			E data = aktuell.data;
			aktuell = aktuell.neste;
			return data;
		}

		public void remove() {
			// NADA
		}
	}

	
}
