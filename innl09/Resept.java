public abstract class Resept {
	private static int loepenummer = 0;

	private Legemiddel legemiddelet;
	private String legenavn;
	private String pasientnavn;
	private int idNummer;
	private int reit = 0;

	protected double pris; // protected for subklasse-akksess
    
	public Resept( Legemiddel legemiddelet, String legenavn, String pasientnavn, int reit ) {
		this.legemiddelet = legemiddelet;
		this.legenavn = legenavn;
		this.pasientnavn = pasientnavn;
		this.reit = reit;
		this.idNummer = loepenummer++;
	}

	public void bruk() {
		if ( reit > 0 ) {
			reit--;
		}
		else {
			// ingen flere bruk, trenger mer informasjon for å inne ut hva som skjer
			// returner boolean f.eks, eller utskrift?
		}
	}

	public int hentNummer() {
		return this.idNummer;
	}
	
}
