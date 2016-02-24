public class LenkelisteTall {
     
    private Node listeStart;

    public void settInn( int tall ){
        Node nyttTall = new Node( tall );
        if ( listeStart == null ) {
            listeStart = nyttTall;
        }
        else {
            nyttTall.neste = listeStart;
            listeStart = nyttTall;
        }
    }

    public int taUt() {
        if ( listeStart != null ) {
            int returTallet = listeStart.tallet;
            listeStart = listeStart.neste;
            return returTallet;
        }
        return -1;  // default returverdi
    }

    private class Node {
        Node neste;
        int tallet;
        
        protected Node (int tallet) {
            this.tallet = tallet;
        }
    }
}