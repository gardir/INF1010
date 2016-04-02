public class Pasient {
	private static int loepenummer = 0;
    
	private String navn;
	private String fodselsnummer; // int blir for lite tall, maa vaere String
	private String addresse;
	private int postnummer;
	private int idNummer;

	private YngsteForstReseptListe resepter =  new YngsteForstReseptListe();
	
    //public Pasient( String navn, String fodselsnummer, String veinavn, int husnummer, int postnummer ) { { // konstruktør for oppg4
	public Pasient( String navn, String fodselsnummer, String addresse, int postnummer ) {
		this.navn = navn;
		this.fodselsnummer = fodselsnummer;
//		this.addresse = String.format( "%s %d, %04d", veinavn, husnummer, postnummer ); // oppg4
		this.addresse = addresse;
		this.postnummer = postnummer;
		this.idNummer = loepenummer++;
	}

	public String hentNavn() {
		return this.navn;
	}
	
}
