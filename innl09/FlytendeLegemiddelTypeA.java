class FlytendeLegemiddelTypeA extends FlytendeLegemiddel {
	private int narkotiskStyrke;

	public FlytendeLegemiddelTypeA( String navn, double pris, double volum, double virkestoffPrPille, int narkotiskStyrke ) {
		super( navn, pris, volum, virkestoffPrPille );
		this.narkotiskStyrke = narkotiskStyrke;
	}

	public String hentInfo() {
		return String.format( "%s, %d", super.info("a"), narkotiskStyrke );
	}

}
