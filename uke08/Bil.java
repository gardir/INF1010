public class Bil extends Kjoeretoy {
	public Bil( String skilt, String merke, int sitteplasser ) {
		super( skilt, merke, sitteplasser );
	}

	public void skrivUtInfo() {
		System.out.println( skilt + ": Er en bil av type " + merke +
		                    " med " + sitteplasser + " sitteplasser" );
	}

    public String hentInfo() {
        return String.format("%s;%s;%d", skilt, merke, sitteplasser);
    }
}
