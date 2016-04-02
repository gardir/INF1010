public class TallMonitorMain {

    private static void test( boolean faktisk, boolean forventet, String forklaring ) {
        System.out.print("Tester " + forklaring + ": ");
        if ( faktisk == forventet ) {
            System.out.println("Passerte");
        } else {
            System.out.println("Feilet");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("tata");
        TallMonitor monitor = new TallMonitor(-10, 10);
        test( monitor.settMinste(5), true, "setter minste");
        test( monitor.settStorste(0), false, "setter storst");
    }
    
}
