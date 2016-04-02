public class YngsteForstReseptListe extends EnkelReseptListe {

	public void settInn ( Resept nyResept ) {
		Node nyNode = new Node( nyResept );
		if ( erTom ) {
			foerst = nyNode;
			sist = nyNode;
			erTom = false;
			return;
		}

		nyNode.neste = foerst;
		foerst = nyNode;
	}
	
}
