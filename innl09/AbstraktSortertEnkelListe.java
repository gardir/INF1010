import java.util.Iterator;

public interface AbstraktSortertEnkelListe<E extends Comparable<E> & Lik> extends Iterable<E> {

	/**
	 * Setter inn element i listen.
	 *
	 * Metoden setter inn det nye elementet
	 * i lenkelisten. Posisjon blir bestemt
	 * av sortering (minste foerst).
	 *
	 * @param e er elementet som settes inn
	 */
	public void settInn( E e );

	/**
	 * Henter element basert paa noekkel.
	 *
	 * Finner og returnerer et element i
	 * listen basert paa noekkelen gitt
	 * som parameter. Hvis ikke elementet
	 * kan finnes returnerer den 'null'.
	 *
	 * @param noekkel er strengen som skal
	 *        finne elementet.
	 * @return elementet hvis funnet, ellers
	 *         null
	 */
	public E hent( String noekkel );

	/**
	 * Gir tilbake en iterator over listen.
	 *
	 * Metoden skal opprette og gi tilbake en
	 * iterator som skal gå over listen. Den
	 * skal dermed gi en iterator som henter
	 * element etter element sortert fra
	 * minste foerst.
	 *
	 * @return iteratoren over listen
	 */
	public Iterator<E> iterator();
	
}
