abstract class PilleLegemiddel extends Legemiddel implements Pilleform {
	private int pilleAntall;
	private double virkestoffPrPille;

	public PilleLegemiddel( String navn, double pris, int piller, double virkestoffPrPille ) {
		super( navn, pris );
		this.pilleAntall = piller;
		this.virkestoffPrPille = virkestoffPrPille;
	}

	public int hentPilleAntall() {
		return pilleAntall;
	}

	public double hentVirkestoffPrPille() {
		return virkestoffPrPille;
	}

	public double totaltVirkestoff() {
		return pilleAntall * virkestoffPrPille;
	}

	protected String info( String type ) {
		return String.format( "%d, %s, pille, %s, %f, %d, %d", idNummer, navn, type, pris, pilleAntall, virkestoffPrPille );
	}
	
}
