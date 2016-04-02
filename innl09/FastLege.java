class FastLege extends Lege implements KommuneAvtale {
	private int avtale;

	public FastLege( String navn, int avtale ) {
		super( navn );
		this.avtale = avtale;
	}

	public int hentAvtale() {
		return this.avtale;
	}
}
