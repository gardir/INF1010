public class Lege implements Lik, Comparable<Lege> {
	private String navn;
	
	private EldsteForstReseptListe resepter =  new EldsteForstReseptListe();

	public Lege( String navn ) {
		this.navn = navn;
	}

	public String hentNavn() {
		return this.navn;
	}
	
	public boolean samme( String annetNavn ) {
		return this.navn.equals( annetNavn );
	}

	public int compareTo( Lege l ) {
		return this.navn.compareTo( l.hentNavn() );
	}
}
