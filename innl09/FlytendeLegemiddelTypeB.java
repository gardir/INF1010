class FlytendeLegemiddelTypeB extends FlytendeLegemiddel {
	private int vanedannendeStyrke;

	public FlytendeLegemiddelTypeB( String navn, double pris, double volum, double virkestoffPrPille, int vanedannendeStyrke ) {
		super( navn, pris, volum, virkestoffPrPille );
		this.vanedannendeStyrke = vanedannendeStyrke;
	}
	
	public String hentInfo() {
		return String.format( "%s, %d", super.info("b"), vanedannendeStyrke );
	}
	
}
