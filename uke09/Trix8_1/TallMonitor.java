public class TallMonitor {
	private int minsteTall = Integer.MIN_VALUE;
	private int storsteTall = Integer.MAX_VALUE;

	private void defaultValues() {
		minsteTall = Integer.MIN_VALUE;
		storsteTall = Integer.MAX_VALUE;
	}
	
	public TallMonitor() {
		defaultValues();
	}
	
	public TallMonitor( int minste, int storste ) {
		if ( invariant( minste, storste ) ) {
			minsteTall = minste;
			storsteTall = storste;
		} else {
			System.out.format( "Illegal values, %d !< %d. Using default\n", minste, storste );
			defaultValues();
		}
	}
	
	private synchronized boolean invariant( int minst, int storst ) {
		return minst < storst;
	}
	
	public boolean settMinste( int verdi ) {
		if ( invariant( verdi, this.storsteTall ) ) {
			minsteTall = verdi;
			return true;
		}
		return false;
	}

	public boolean settStorste( int verdi ) {
		if ( invariant( this.minsteTall, verdi ) ) {
			storsteTall = verdi;
			return true;
		}
		return false;
	}

	/** HJELPEMETODER **/

	public void skrivUtTall() {
		System.out.format( "MONITOR: Minste/Storste: %d/%d\n", minsteTall, storsteTall );
	}
	
}
