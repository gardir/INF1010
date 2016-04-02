import java.util.Iterator;

public abstract class EnkelReseptListe implements Iterable<Resept> {
	protected Node foerst, sist;
	protected boolean erTom = true;

	public void settInn( Resept nyResept ) {
		Node nyNode = new Node( nyResept );
		if ( erTom ) {
			// lagre som eneste/foerste/siste element
			this.foerst = nyNode;
			this.sist = nyNode;
			erTom = false;
			return;
		}
		// lagre paa slutten av lista
		sist.neste = nyNode;
		sist = nyNode;
	}

	public Resept hent( int nummer ) {
		Node reseptNode = foerst;
		while ( reseptNode != null ) {
			if ( reseptNode.resept.hentNummer() == nummer ) {
				return reseptNode.resept;
			}
			reseptNode = reseptNode.neste;
		}
		return null;
	}

	public Iterator<Resept> iterator() {
		return new ListeIterator();
	}

	/** INDRE KLASSER **/
	
	protected class Node {
		Node neste;
		Resept resept;

		Node( Resept resept ) {
			this.resept = resept;
		}
	}

	private class ListeIterator implements Iterator<Resept> {
		Node reseptNoden = foerst;

		public boolean hasNext() {
			return reseptNoden != null;
		}

		public Resept next() {
			Resept resepten = reseptNoden.resept;
			reseptNoden = reseptNoden.neste;
			return resepten;
		}

		public void remove() {
			// NADA
		}
	}
	
}
