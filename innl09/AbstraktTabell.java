import java.util.Iterator;

public interface AbstraktTabell<E> extends Iterable<E> {

	/**
	 * Setter inn element på bestemt plass.
	 *
	 * Indeksen bestemmer plassen hvor elementet skal
	 * settes inn. Returverdien baserer seg på om
	 * elementet ble satt inn riktig (true) eller
	 * galt (false).
	 *
	 * @param e er elementet som skal settes inn
	 * @param indeks er posisjonene det skal lagres paa
	 * @return om operasjonen var vellykket eller ei
	 */
	public boolean settInn( E e, int indeks );

	/**
	 * Henter element fra bestemt plass.
	 *
	 * Operasjonen henter element fra bestemt plass.
	 * Hvis det ikke er noe element returnerer det
	 * 'null'.
	 *
	 * @param indeks er posisjonen det skal hentes fra
	 * @return elementet
	 */
	public E hent( int indeks );

	/**
	 * Gir tilbake en iterator over tabellen.
	 *
	 * Metoden skal opprette og gi tilbake en
	 * iterator som skal gå over tabellen. Denne
	 * iteratoren vil bare hente ut fra plasser
	 * i tabellen der det er elementer.
	 *
	 * @return iteratoren over tabellen
	 */
	public Iterator<E> iterator();
}
