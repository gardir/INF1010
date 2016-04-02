class BlaaResept extends Resept {
	public BlaaResept ( Legemiddel legemiddelet, String legenavn, String pasientnavn, int reit ) {
		super( legemiddelet, legenavn, pasientnavn, reit );
		this.pris = legemiddelet.hentPris() * 0.0; // subsidiert 100%
	}
}
