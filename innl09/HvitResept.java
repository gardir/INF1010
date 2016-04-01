class HvitResept extends Resept {
    
	public HvitResept( Legemiddel legemiddelet, String legenavn, String pasientnavn, int reit ) {
		super( legemiddelet, legenavn, pasientnavn, reit );
		this.pris = legemiddelet.hentPris();
	}
}
