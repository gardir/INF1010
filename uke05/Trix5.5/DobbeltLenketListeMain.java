class DobbeltLenketListeMain {
   
    public static void main( String[] args ) {
        DobbeltLenketListe<String> dobbeltLL = new DobbeltLenketListe<>();
        dobbeltLL.settInn( "Oscar" );
        dobbeltLL.settInn( "Fox" );
        dobbeltLL.settInn( "Alpha" );
        dobbeltLL.settInn( "Echo" );
        dobbeltLL.settInn( "Zulu" );
        dobbeltLL.printListe();
    }
}