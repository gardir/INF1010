public class Oppover implements Runnable {
    private int indeks;
    private int verdi;
    private TallMonitor monitor;

    public Oppover( int indeks, TallMonitor monitor, int startVerdi ) {
        this.indeks = indeks;
        this.monitor = monitor;
        this.verdi = startVerdi;
    }
    
    public void run() {
        System.out.println("T#" + indeks);
//        int verdi = Integer.MIN_VALUE;
        while ( monitor.settMinste( verdi ) ) {
            verdi++;
        }
        System.out.println("Siste feilet minste verdi ble: " + verdi );
    }
}
