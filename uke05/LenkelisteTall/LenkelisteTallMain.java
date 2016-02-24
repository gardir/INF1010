public class LenkelisteTallMain {
    
    public static void main( String[] args ) {
        LenkelisteTall lenkeliste = new LenkelisteTall();
        lenkeliste.settInn( 1 );
        lenkeliste.settInn( 4 );
        System.out.println( lenkeliste.taUt() );
        System.out.println( lenkeliste.taUt() );
        lenkeliste.settInn( 3 );
        lenkeliste.settInn( 1 );
        lenkeliste.settInn( 9 );
        System.out.println( lenkeliste.taUt() );
        lenkeliste.settInn( 10 );
    }

}