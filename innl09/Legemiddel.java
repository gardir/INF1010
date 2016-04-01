public abstract class Legemiddel {
	private static int loepenummer = 0;

	protected String navn;
	protected int idNummer;
	
	protected double pris;
    
	public Legemiddel( String navn, double pris ) {
		this.navn = navn;
		this.pris = pris;
		this.idNummer = loepenummer++;
	}

	public String hentNavn() {
		return navn;
	}

	public double hentPris() {
		return this.pris;
	}

	public abstract double totaltVirkestoff();

	public abstract String hentInfo();
}
