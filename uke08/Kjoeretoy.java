public abstract class Kjoeretoy {
	protected String skilt;
	protected String merke;
	protected int sitteplasser;

	public Kjoeretoy( String skilt, String merke, int sitteplasser ) {
		this.skilt = skilt;
		this.merke = merke;
		this.sitteplasser = sitteplasser;
	}

    public abstract void skrivUtInfo();
    public abstract String hentInfo();
	
}
