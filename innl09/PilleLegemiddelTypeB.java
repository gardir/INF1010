class PilleLegemiddelTypeB extends PilleLegemiddel {
	private int vanedannendeStyrke;

	public PilleLegemiddelTypeB( String navn, double pris, int piller, double virkestoffPrPille, int vanedannendeStyrke ) {
		super( navn, pris, piller, virkestoffPrPille );
		this.vanedannendeStyrke = vanedannendeStyrke;
	}

	public String hentInfo() {
		return String.format( "%s, %d", super.info("b"), vanedannendeStyrke );
	}
	
}
