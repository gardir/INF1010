class PilleLegemiddelTypeC extends PilleLegemiddel {

	public PilleLegemiddelTypeC( String navn, double pris, int piller, double virkestoffPrPille ) {
		super( navn, pris, piller, virkestoffPrPille );
	}

	public String hentInfo() {
		return String.format( "%s, 0", super.info("c") );
	}
	
}
