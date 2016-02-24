public class LenketListe<E extends Comparable<E>>{
    private Node forste;
    private Node siste;

    private class Node{
        Node neste;
        E data;
        Node(E e){
            data = e;
        }
    }

    public void settInn(E data){
        Node ny = new Node(data);

        if(forste == null){
            forste = ny;
            siste = ny;
            return;
        }

        Node prev = forste;
        Node curr = forste.neste;
        
        if(prev.data.compareTo(data) > 0){
            ny.neste = prev;
            forste = ny;
            return;
        }

        while(curr != null){
            if(curr.data.compareTo(data) > 0){
                ny.neste = curr;
                prev.neste = ny;
                return;
            }

            curr = curr.neste;
            prev = prev.neste;
        }

        prev.neste = ny;
        siste = ny;

    }

    public void printListe(){
        Node tmp = forste;
        while(tmp != null){
            System.out.println(tmp.data);
            tmp = tmp.neste;
        }
    }

    public E hentStorste(){
        /*
        Node tmp = forste;
        while(tmp.neste != null){
            tmp = tmp.neste;
        }
        return tmp.data;
        */
        return siste.data;
    }


}