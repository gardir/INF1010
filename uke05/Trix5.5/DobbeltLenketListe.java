class DobbeltLenketListe<E extends Comparable<E>>{
    private Node forste;

    private class Node{
        Node neste;
        Node forrige;
        E data;
        Node(E e){
            data = e;
        }
    }

    public void settInn(E data){
        Node ny = new Node(data);

        if(forste == null){
            forste = ny;
            return;
        }

        Node curr = forste;
        
        if(curr.data.compareTo(data) > 0){
            ny.neste = curr;
            curr.forrige = ny;
            forste = ny;
            return;
        }

        while(curr.neste != null){
            if(curr.data.compareTo(data) > 0){
        
                //curr.forrige.neste = ny; // samme som de to setningene under
                Node forrige = curr.forrige;
                forrige.neste = ny;
                ny.forrige = curr.forrige;
                ny.neste = curr;
                curr.forrige = ny;
                return;
            }

            curr = curr.neste;
        }

        
        curr.neste = ny;
        ny.forrige = curr;
        

    }

    public void printListe(){
        Node tmp = forste;
        while(tmp != null){
            System.out.println(tmp.data);
            tmp = tmp.neste;
        }
    }

    public E hentStorste(){
        Node tmp = forste;
        while(tmp.neste != null){
            tmp = tmp.neste;
        }
        return tmp.data;
    }

    public E taUtStorste(){
        Node tmp = forste;

        if(forste == null){
            return null;
        }

        if ( forste != null && forste.neste == null ) {
            forste = null;
            return tmp.data;
        }
        
        while(tmp.neste != null) {
            tmp = tmp.neste;
        }
        tmp.forrige.neste = null;
        return tmp.data;

        /* OLD CODE
        Node tmp = forste;
        while(tmp.neste != null){
            tmp = tmp.neste;
        }
        return tmp.data;
        */
    }


}