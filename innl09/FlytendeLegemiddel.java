abstract class FlytendeLegemiddel extends Legemiddel implements Miksturform {
	private double volum;
	private double virkestoffPrVolum;

	public FlytendeLegemiddel( String navn, double pris, double volum, double virkestoffPrVolum ) {
		super( navn, pris );
		this.volum = volum;
		this.virkestoffPrVolum = virkestoffPrVolum;
	}

	public double hentVolum() {
		return volum;
	}

	public double hentVirkestoffPrVolum() {
		return virkestoffPrVolum;
	}

	public double totaltVirkestoff() {
		return volum * virkestoffPrVolum;
	}

	protected String info( String type ) {
		return String.format( "%d, %s, mikstur, %s, %f, %f, %d", idNummer, navn, type, pris, volum, virkestoffPrVolum );
	}
}
