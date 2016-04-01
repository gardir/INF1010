class PilleLegemiddelTypeA extends PilleLegemiddel {
	private int narkotiskStyrke;

	public PilleLegemiddelTypeA( String navn, double pris, int piller, double virkestoffPrPille, int narkotiskStyrke ) {
		super( navn, pris, piller, virkestoffPrPille );
		this.narkotiskStyrke = narkotiskStyrke;
	}

	public String hentInfo() {
		return String.format( "%s, %d", super.info("a"), narkotiskStyrke );
	}

}
