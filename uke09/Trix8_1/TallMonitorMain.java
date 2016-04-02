public class TallMonitorMain {

	private static void test( boolean faktisk, boolean forventet, String forklaring ) {
		System.out.print( "Tester " + forklaring + ": ");
		if ( faktisk == forventet ) {
			System.out.println("Passerte");
		} else {
			System.out.format("Feilet (fikk %b vs. %b forventet)\n", faktisk, forventet);
		}
	}

    public static void main(String[] args) {
        TallMonitor monitor = new TallMonitor(-5,5);
//        test( monitor.settMinste(0), true, "sett minste");
//        test( monitor.settStorste(0), false, "sett storste");

        Thread nedover = new Thread( new Nedover(0, monitor, Integer.MAX_VALUE) );
        nedover.start();
        Thread oppover = new Thread( new Oppover(1, monitor, Integer.MIN_VALUE ) );
        oppover.start();
        
    }
    
}
