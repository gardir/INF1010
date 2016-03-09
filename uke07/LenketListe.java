import java.util.NoSuchElementException;

public class LenketListe implements Iterable<String>{
    private Node forste;

    public void settInnSist(String s){
        Node ny = new Node(s);
        if(forste == null){
            forste = ny;
        }else{
            forste.settInn(ny);
        }
    }

    public void printListe1(){
        if(forste != null){
            forste.printPrefiks();
        }
    }

    public void printListe2(){
        if(forste != null){
            forste.printPostfiks();
        }
    }

    public Iterator iterator(){
        return new MinIterator();
    }

    private class MinIterator implements Iterator<String>{
        Node curr;
        
        MinIterator(){
            curr = forste;
        }
        
        public boolean hasNext(){
            return curr != null;
        }

        public String next(){
            if(hasNext()){
                String toReturn = curr.data;
                curr = curr.neste;
                return toReturn;
            }else{
                throw new NoSuchElementException();
            }
        }
    }

    private class Node{
        Node neste;
        String data;

        Node(String s){
            data = s;
        }

        public void settInn(Node ny){
            if(neste == null){
                neste = ny;
            }else{
                neste.settInn(ny);
            }
        }

        public void printPrefiks(){
            System.out.println(data);
            if(neste != null){
                neste.printPrefiks();
            }
        }

        public void printPostfiks(){
            if(neste != null){
                neste.printPostfiks();
            }
            System.out.println(data);
        }

    }


}