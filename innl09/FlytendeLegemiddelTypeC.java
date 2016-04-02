class FlytendeLegemiddelTypeC extends FlytendeLegemiddel {

	public FlytendeLegemiddelTypeC( String navn, double pris, double volum, double virkestoffPrPille ) {
		super( navn, pris, volum, virkestoffPrPille );
    }
	
	public String hentInfo() {
		return String.format( "%s, 0", super.info("c") );
	}

}
